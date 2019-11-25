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

        System.out.printf("Welcome %s, to the Arena.%n%n Are you ready for your first challenge? (yes/no)%n", playerName);
        String startArena = sc.next();

        if (startArena.equalsIgnoreCase("yes")) {
            System.out.println("Then onward you go.");
            Arena(PlayerHealth,PlayerAttackMax,PlayerPotions);
        } else if (startArena.equalsIgnoreCase("no")) {
            System.out.println("Too Bad, your going anyway");
            Arena(PlayerHealth,PlayerAttackMax,PlayerPotions);
        } else {
            System.out.println("...off you go.");
            Arena(PlayerHealth,PlayerAttackMax,PlayerPotions);
        }


    }

    private static void Arena(int playerHealth, int playerAttack, int playerPotions) {
        System.out.println("Here is comes your Opponent:");
        System.out.println();
        System.out.println("Now Entering:");
        String mobName = monsterName();
        int[] mobStats = generateMonsterStats();
        int mobHealth = mobStats[0];
        int mobAttack = mobStats[1];
        System.out.printf("\"%s\"%nHealth: %s%nAttack: %s%n",mobName,mobHealth,mobAttack);

        int[] playerStats = {playerHealth,playerAttack,playerPotions};

        System.out.println("Let the Battle Begin!");
        combat(playerStats,mobStats);



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

    private static void combat(int[] playerStats, int[] mobStats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What will you do?\nA.Attack\nB.Potion\nC.Run?");
        String action = sc.next();
        if (action.equalsIgnoreCase("a") || action.equalsIgnoreCase("attack")){

        }else if (action.equalsIgnoreCase("b")||action.equalsIgnoreCase("potion")){

        }else if (action.equalsIgnoreCase("c")||action.equalsIgnoreCase("run")){
            System.out.println("there is not escape from the arena...");
            combat(playerStats,mobStats);
        }
    }

    private static int[] generateMonsterStats(){
        Random rand = new Random();
        int monsterHealth = rand.nextInt(199)+1;
        int monsterAttack = rand.nextInt(20);
        int[] returnArray = new int[2];
        returnArray[0] = monsterHealth;
        returnArray[1] = monsterAttack;

        return returnArray;
    }

    private static String monsterName(){
        String[] mobName = {"Bob","Phil","Dave","Kile","Joe","Rile","Steve"};
        String[] mobTitle = {"the Slime","the Warrior","the goblin","the Coward","The Brave","the duck"};
        Random rand = new Random();
        return mobName[rand.nextInt(mobName.length-1)] + " " + mobTitle[rand.nextInt(mobTitle.length-1)];
    }

    private static void gameOver(){
        Scanner sc = new Scanner(System.in);
        System.out.println("GAME OVER!!!");
        System.out.println("Restart? (yes/no)");
        String continueGame = sc.next();
        if(continueGame.equalsIgnoreCase("yes")){
            System.out.println("restarting...");
            beginAdventure();
        }else if (continueGame.equalsIgnoreCase("no")){
            System.out.println("Goodbye");
        }else {
            System.out.println("Not a valid input.");
            gameOver();
        }
    }


}

