import java.util.Random;
import java.util.Scanner;

public class theColiseum {

    public static void main(String[] args) {
        beginGame();
    }

    public static String[] art = {"" +
            "  ,^.\n" +
            "  |||\n" +
            "  |||       _T_\n" +
            "  |||   .-.[:|:].-.\n" +
            "  ===_ /\\|  \"'\"  |/\n" +
            "   E]_|\\/ \\--|-|''''|\n" +
            "   O  `'  '=[:]| A  |\n" +
            "          /\"\"\"\"|  P |\n" +
            "         /\"\"\"\"\"`.__.'\n" +
            "        []\"/\"\"\"\\\"[]\n" +
            "        | \\     / |\n" +
            "        | |     | |\n" +
            "      <\\\\\\)     (///>",

    "                                         _A_\n" +
            "                                / | \\\n" +
            "                               |.-=-.|\n" +
            "                               )\\_|_/(\n" +
            "                            .=='\\   /`==.\n" +
            "                          .'\\   (`:')   /`.\n" +
            "                        _/_ |_.-' : `-._|__\\_\n" +
            "                       <___>'\\    :   / `<___>\n" +
            "                       /  /   >=======<  /  /\n" +
            "                     _/ .'   /  ,-:-.  \\/=,'\n" +
            "                    / _/    |__/v^v^v\\__) \\\n" +
            "                    \\(\\)     |V^V^V^V^V|\\_/\n" +
            "                     (\\\\     \\`---|---'/\n" +
            "                       \\\\     \\-._|_,-/\n" +
            "                        \\\\     |__|__|\n" +
            "                         \\\\   <___X___>\n" +
            "                          \\\\   \\..|../\n" +
            "                           \\\\   \\ | /\n" +
            "                            \\\\  /V|V\\\n" +
            "                             \\|/  |  \\\n" +
            "                              '--' `--` ",

    "             /'\n" +
            "     ||\n" +
            "     ||      ** *\n" +
            "     ||      __X_\n" +
            "     ||     ( ___\\\n" +
            "     ||     |:  \\\\\n" +
            "    ><><  ___)..:/_#__,\n" +
            "    (X|) (|+(____)+\\ _)\n" +
            "     o|_\\/>> + + + << \\\n" +
            "       |:\\/|+ + + +| \\_\\<\n" +
            "       \\./  XXXXXX.  (o_)_\n" +
            "           /+ + + |   \\:|\n" +
            "          /+ +/+ +|  -/->>>----.\n" +
            "         /+ +|+ /XX /   _--,  _ \\\n" +
            "        \\+ + + /  |X   (,\\- \\/_ ,\n" +
            "        /\\+ + /\\  |X \\    /,//_/\n" +
            "       +_+_+_( )o_)X  \\  (( ///\n" +
            "        (_o(  /__/ X   \\  \\\\//\n" +
            "         \\_|  |_/  X    \\ ///\n" +
            "         \\_| >(_/        \\,/\n" +
            "    ,////__o\\ /__////,    V    ",

    "           ,   A           {}\n" +
            "  / \\, | ,        .--.\n" +
            " |    =|= >      /.--.\\\n" +
            "  \\ /` | `       |====|\n" +
            "   `   |         |`::`|\n" +
            "       |     .-;`\\..../`;-.\n" +
            "      /\\\\/  /  |...::...|  \\\n" +
            "      |:'\\ |   /'''::'''\\   |\n" +
            "       \\ /\\;-,/\\   ::   /\\--;\n" +
            "       |\\ <` >  >._::_.<,<__>\n" +
            "       | `\"\"`  /   ^^   \\|  |\n" +
            "       |       |        |\\::/\n" +
            "       |       |        |/|||\n" +
            "       |       |___/\\___| '''\n" +
            "       |        \\_ || _/\n" +
            "       |        <_ >< _>\n" +
            "       |        |  ||  |\n" +
            "       |        |  ||  |\n" +
            "       |       _\\.:||:./_\n" +
            "       |      /____/\\____\\",
    "                                 ,dM\n" +
            "                         dMMP\n" +
            "                        dMMM'\n" +
            "                        \\MM/\n" +
            "                        dMMm.\n" +
            "                       dMMP'_\\---.\n" +
            "                      _| _  p ;88;`.\n" +
            "                    ,db; p >  ;8P|  `.\n" +
            "                   (``T8b,__,'dP |   |\n" +
            "                   |   `Y8b..dP  ;_  |\n" +
            "                   |    |`T88P_ /  `\\;\n" +
            "                   :_.-~|d8P'`Y/    /\n" +
            "                    \\_   TP    ;   7`\\\n" +
            "         ,,__        >   `._  /'  /   `\\_\n" +
            "         `._ \"\"\"\"~~~~------|`\\;' ;     ,'\n" +
            "            \"\"\"~~~-----~~~'\\__[|;' _.-'  `\\\n" +
            "                    ;--..._     .-'-._     ;\n" +
            "                   /      /`~~\"'   ,'`\\_ ,/\n" +
            "                  ;_    /'        /    ,/\n" +
            "                  | `~-l         ;    /\n" +
            "                  `\\    ;       /\\.._|\n" +
            "                    \\    \\      \\     \\\n" +
            "                    /`---';      `----'\n" +
            "                   (     /            fsc\n" +
            "                    `---'",
    };

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
        int PlayerAttackMax = 30;
        int PlayerPotions = 5;
        int score = 0;

        System.out.printf("Welcome %s, to the Arena.%n%nAre you ready for your first challenge? (yes/no)%n", playerName);
        String startArena = sc.next();

        if (startArena.equalsIgnoreCase("yes")) {
            System.out.println("Then onward you go.");
            Arena(PlayerHealth, PlayerAttackMax, PlayerPotions,score);
        } else if (startArena.equalsIgnoreCase("no")) {
            System.out.println("Too Bad, your going anyway");
            Arena(PlayerHealth, PlayerAttackMax, PlayerPotions ,score);
        } else {
            System.out.println("...off you go.");
            Arena(PlayerHealth, PlayerAttackMax, PlayerPotions, score);
        }


    }

    private static void Arena(int playerHealth, int playerAttack, int playerPotions, int score) {
        System.out.println("Here is comes your Opponent:");
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Now Entering:");
        System.out.println();
        String mobName = monsterName();
        int[] mobStats = generateMonsterStats();
        int mobHealth = mobStats[0];
        int mobAttack = mobStats[1];
        System.out.printf("\"%s\"%nHealth: %s%nAttack: %s%n", mobName, mobHealth, mobAttack);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        int[] playerStats = {playerHealth, playerAttack, playerPotions};

        System.out.println();
        System.out.println("Let the Battle Begin!");
        System.out.println();
        combat(playerStats, mobStats, mobName, score);


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


    private static void enemyTurn(int[] playerstats, int[] enemystats, String mobName, int score){
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
        if (playerstats[0] <= 0){
            gameOver(score);
        }else {
            combat(playerstats, enemystats,mobName, score);
        }

    }

    private static void combat(int[] playerStats, int[] mobStats, String mobName, int score) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Player Stats:");
        System.out.println();
        System.out.printf("Health: %s\nAttack: %s\nPotions: %s\n\n", playerStats[0], playerStats[1], playerStats[2]);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("What will you do?\nA.Attack\nB.Potion\nC.Run?");

        String action = sc.next();
        if (action.equalsIgnoreCase("a") || action.equalsIgnoreCase("attack")) {
            System.out.println("Attacking...");
            int damage = damageDone(playerStats[1]);
            System.out.printf("You attack for %s damage.\n", damage);
            mobStats[0] -= damage;
        } else if (action.equalsIgnoreCase("b") || action.equalsIgnoreCase("potion")) {
            System.out.println("Using Potion...");
            if (playerStats[2] > 0) {
                int heals = potionHeal();
                System.out.printf("Potion heals you for %s health",heals);
                playerStats[0] += heals;
                playerStats[2] -= 1;
                System.out.printf("You have %s potions left\n", playerStats[2]);
            } else {
                System.out.println("You Don't have any potions left...");
                combat(playerStats, mobStats, mobName, score);
            }
        } else if (action.equalsIgnoreCase("c") || action.equalsIgnoreCase("run")) {
            System.out.println("there is not escape from the arena...");
            combat(playerStats, mobStats, mobName, score);
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
            Arena(playerStats[0], playerStats[1], playerStats[2] , score);
        } else {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(mobName + ":");
            System.out.printf("Health: %s%n", mobStats[0]);
            System.out.printf("Attack: %s%n", mobStats[1]);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Enemies Turn:");
            System.out.println();
            enemyTurn(playerStats,mobStats,mobName, score);
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
        String[] mobName = {"Bob", "Phil", "Dave", "Kile", "Joe", "Rile", "Steve"};
        String[] mobTitle = {"the Slime", "the Warrior", "the goblin", "the Coward", "The Brave", "the duck"};
        Random rand = new Random();
        return mobName[rand.nextInt(mobName.length - 1)] + " " + mobTitle[rand.nextInt(mobTitle.length - 1)];
    }

    private static void gameOver(int score) {
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
            gameOver(score);
        }
    }


}