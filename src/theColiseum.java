import java.util.Random;
import java.util.Scanner;

public class theColiseum {
    private static int score = 0;
    private static String playerName;
    private static String mobName;


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
        playerName = sc.nextLine();
        sc.nextLine();
        if (playerName.trim().equalsIgnoreCase("")) {
            System.out.println("That is not a name...");
            beginAdventure();
        }
        int PlayerHealth = 100;
        int PlayerAttackMax = 30;
        int PlayerPotions = 5;
        score = 0;
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
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Now Entering:");
        System.out.println();
        mobName = monsterName();
        int[] mobStats = generateMonsterStats();
        int mobHealth = mobStats[0];
        int mobAttack = mobStats[1];
        System.out.printf("\"%s\"%nHealth: %s%nAttack: %s%n", mobName, mobHealth, mobAttack);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int[] playerStats = {playerHealth, playerAttack, playerPotions};

        System.out.println();
        System.out.println("Let the Battle Begin!");
        System.out.println();
        combat(playerStats, mobStats);


    }

    private static int damageDone(int maxDamage) {
        Random rand = new Random();
        return rand.nextInt(maxDamage);
    }

    private static int potionHeal() {
        Random random = new Random();
        return random.nextInt(24) + 1;
    }


    private static void enemyTurn(int[] playerstats, int[] enemystats){
        Random rand = new Random();
        int move = rand.nextInt(2);
        int dmg = damageDone(enemystats[1]);
        int heal = potionHeal();
        if (move == 1) {
            playerstats[0] -= dmg;
            System.out.printf("%s attacks %s for %s damage!\n", mobName, playerName, dmg);
        } else {
            enemystats[0] += heal;
            System.out.printf("Enemy used a potion and healed %s damage!\n", heal);
        }
        if (playerstats[0] <= 0){
            gameOver();
        }else {
            combat(playerstats, enemystats);
        }

    }

    private static void combat(int[] playerStats, int[] mobStats) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("%s Stats:%n",playerName);
        System.out.println();
        System.out.printf("Health: %s\nAttack: %s\nPotions: %s\n\n", playerStats[0], playerStats[1], playerStats[2]);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("What will you do?\nA.Attack\nB.Potion\nC.Run?");

        String action = sc.next();
        if (action.equalsIgnoreCase("a") || action.equalsIgnoreCase("attack")) {
            System.out.println("Attacking...");
            int damage = damageDone(playerStats[1]);
            System.out.printf("%s attacks %s for %s damage.\n", playerName,mobName, damage);
            mobStats[0] -= damage;
        } else if (action.equalsIgnoreCase("b") || action.equalsIgnoreCase("potion")) {
            System.out.println("Using Potion...");
            if (playerStats[2] > 0) {
                int heals = potionHeal();
                System.out.printf("Potion heals %s for %s health",playerName,heals);
                playerStats[0] += heals;
                playerStats[2] -= 1;
                System.out.printf("You have %s potions left\n", playerStats[2]);
            } else {
                System.out.println("You Don't have any potions left...");
                combat(playerStats, mobStats);
            }
        } else if (action.equalsIgnoreCase("c") || action.equalsIgnoreCase("run")) {
            System.out.println("there is not escape from the arena...");
            combat(playerStats, mobStats);
        }

        if (mobStats[0] <= 0) {
            System.out.printf("%s Has Been Defeated!!!\n", mobName);
            int hasPotion = random.nextInt(2);
            if ( hasPotion == 1){
                playerStats[2]++;
                System.out.printf("You found a potion on %s. You now have %s potions. \n", mobName, playerStats[2]);
            }
            score++;
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
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(mobName + ":");
            System.out.printf("Health: %s%n", mobStats[0]);
            System.out.printf("Attack: %s%n", mobStats[1]);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Enemies Turn:");
            System.out.println();
            enemyTurn(playerStats,mobStats);
        }


    }

    private static int[] generateMonsterStats() {
        Random rand = new Random();
        int monsterHealth = rand.nextInt(99) + 1;
        int monsterAttack = rand.nextInt(25) + 1;
        int[] returnArray = new int[2];
        returnArray[0] = monsterHealth;
        returnArray[1] = monsterAttack;

        return returnArray;
    }

    private static String monsterName() {
        String[] mobNameC = {"Bob", "Phil", "Dave", "Kile", "Joe", "Rile", "Steve"};
        String[] mobTitle = {"the Slime", "the Warrior", "the goblin", "the Coward", "The Brave", "the duck"};
        Random rand = new Random();
        return mobNameC[rand.nextInt(mobNameC.length - 1)] + " " + mobTitle[rand.nextInt(mobTitle.length - 1)];
    }

    private static void gameOver() {
        Scanner sc = new Scanner(System.in);
        System.out.println("GAME OVER!!!");
        System.out.printf("Score: %s%n",score);
        System.out.println();
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

