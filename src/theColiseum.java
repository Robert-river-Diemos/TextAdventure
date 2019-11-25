import java.util.Random;
import java.util.Scanner;

public class theColiseum {

    public static void main(String[] args) {
        beginGame();
    }

    private static void beginGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Shall we play a game? (Yes/No)");
        String playGame = sc.next();
        if (playGame.equalsIgnoreCase("yes")) {
            beginAdventure();
        } else if (playGame.equalsIgnoreCase("no")) {
            System.out.println("Fine, be that way...");
        } else {
            System.out.println("...What?");
            beginGame();
        }
    }

    private static void beginAdventure() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your Name Adventurer?");
        String playerName = sc.nextLine();
        sc.nextLine();
        if (playerName.trim().equalsIgnoreCase("")) {
            System.out.println("That is not a name...");
            beginAdventure();
        }
        int PlayerHealth = 100;
        int PlayerAttackMax = 15;
        int PlayerPotions = 5;

        System.out.printf("Welcome %s, to the Arena.%n%nAre you ready for your first challenge? (yes/no)%n", playerName);
        String startArena = sc.next();

        if (startArena.equalsIgnoreCase("yes")) {
            System.out.println("Then onward you go.");
            Arena(PlayerHealth, PlayerAttackMax, PlayerPotions);
        } else if (startArena.equalsIgnoreCase("no")) {
            System.out.println("Too Bad, your going anyway");
            Arena(PlayerHealth, PlayerAttackMax, PlayerPotions);
        } else {
            System.out.println("...off you go.");
            Arena(PlayerHealth, PlayerAttackMax, PlayerPotions);
        }


    }

    private static void Arena(int playerHealth, int playerAttack, int playerPotions) {
        System.out.println("Here is comes your Opponent:");
        System.out.println();
        System.out.println("Now Entering:");
        System.out.println();
        String mobName = monsterName();
        int[] mobStats = generateMonsterStats();
        int mobHealth = mobStats[0];
        int mobAttack = mobStats[1];
        System.out.printf("\"%s\"%nHealth: %s%nAttack: %s%n", mobName, mobHealth, mobAttack);

        int[] playerStats = {playerHealth, playerAttack, playerPotions};

        System.out.println();
        System.out.println("Let the Battle Begin!");
        System.out.println();
        combat(playerStats, mobStats, mobName);


    }

    private static int damageDone(int maxDamage) {
        Random rand = new Random();
        int damage = rand.nextInt(maxDamage);
        return damage;
    }

    private static int potionHeal() {
        Random random = new Random();
        return random.nextInt(24) + 1;
    }


    private static void enemyTurn(int[] playerstats, int[] enemystats, String mobName){
        Random rand = new Random();
        int move = rand.nextInt(2);
        int dmg = damageDone(enemystats[1]);
        int heal = potionHeal();
        switch (move){
            case 1: {
                playerstats[0] -= dmg;
                System.out.printf("You took %s damage!\n", dmg);
                break;
            }
            default: {
                enemystats[0] += heal;
                System.out.printf("Enemy used a potion and healed %s damage!\n", heal);
                break;
            }
        }
        combat(playerstats, enemystats, String mobName);
    }

    private static void combat(int[] playerStats, int[] mobStats, String mobName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player Stats:");
        System.out.println();
        System.out.printf("Health: %s\nAttack: %s\nPotions: %s\n\n", playerStats[0], playerStats[1], playerStats[2]);
        System.out.println("What will you do?\nA.Attack\nB.Potion\nC.Run?");
        String action = sc.next();
        if (action.equalsIgnoreCase("a") || action.equalsIgnoreCase("attack")) {
            System.out.println("Attacking...");
            int damage = damageDone(playerStats[1]);
            System.out.printf("You attack for %s damage\n", damage);
            mobStats[0] -= damage;
        } else if (action.equalsIgnoreCase("b") || action.equalsIgnoreCase("potion")) {
            System.out.println("Using Potion...");
            if (playerStats[2] > 0) {
                int heals = potionHeal();
                System.out.printf("Potion heals you for %s health");
                playerStats[0] += heals;
                playerStats[2] -= 1;
                System.out.printf("You have %s potions left\n", playerStats[2]);
            } else {
                System.out.println("You Don't have any potions left...");
                combat(playerStats, mobStats, mobName);
            }
        } else if (action.equalsIgnoreCase("c") || action.equalsIgnoreCase("run")) {
            System.out.println("there is not escape from the arena...");
            combat(playerStats, mobStats, mobName);
        }

        System.out.println(mobName + ":");
        System.out.printf("Health: %s%n", mobStats[0]);
        System.out.printf("Attack: %s%n", mobStats[1]);

        if (mobStats[0] <= 0) {
            System.out.printf("%s Has Been Defeated!!!\n", mobName);
            System.out.println("You ready for the next Round? (yes/no)");
            String nextRound = sc.next();
            if (nextRound.equalsIgnoreCase("yes")) {
                System.out.println("Alright, Lets go...");
            } else if (nextRound.equalsIgnoreCase("no")) {
                System.out.println("To bad for you, the crowd waits for no one...");
            } else {
                System.out.println("I will take that as a yes...");
            }
            Arena(playerStats[0], playerStats[1], playerStats[2]);
        } else {
            System.out.println("Enemies Turn:");
            enemyTurn(playerStats[],mobStats,mobName);
        }
        if (playerStats[0] <= 0) {
            gameOver();
        } else {
            combat(playerStats, mobStats, mobName);
        }
        enemyTurn(playerStats, mobStats);
    }

    private static int[] generateMonsterStats() {
        Random rand = new Random();
        int monsterHealth = rand.nextInt(199) + 1;
        int monsterAttack = rand.nextInt(20);
        int[] returnArray = new int[2];
        returnArray[0] = monsterHealth;
        returnArray[1] = monsterAttack;

        return returnArray;
    }

    private static String monsterName() {
        String[] mobName = {"Bob", "Phil", "Dave", "Kile", "Joe", "Rile", "Steve"};
        String[] mobTitle = {"the Slime", "the Warrior", "the goblin", "the Coward", "The Brave", "the duck"};
        Random rand = new Random();
        return mobName[rand.nextInt(mobName.length - 1)] + " " + mobTitle[rand.nextInt(mobTitle.length - 1)];
    }

    private static void gameOver() {
        Scanner sc = new Scanner(System.in);
        System.out.println("GAME OVER!!!");
        System.out.println("Restart? (yes/no)");
        String continueGame = sc.next();
        if (continueGame.equalsIgnoreCase("yes")) {
            System.out.println("restarting...");
            beginAdventure();
        } else if (continueGame.equalsIgnoreCase("no")) {
            System.out.println("Goodbye");
        } else {
            System.out.println("Not a valid input.");
            gameOver();
        }
    }


}

