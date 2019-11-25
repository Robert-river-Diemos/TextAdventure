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

        } else if (startArena.equalsIgnoreCase("no")) {
            System.out.println("Too Bad, your going anyway");

        } else {
            System.out.println("...off you go.");

        }


    }

    private static void Arena(int playerHealth, int playerAttack, int playerPotions) {
        System.out.println("Here is comes your Opponent:");

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

    private static void combat() {

    }


}

