import java.util.Random;
import java.util.Scanner;

public class theColiseum {
    private static int score = 0;
    private static String playerName;
    private static String mobName;
    private static int playerMaxH;
    private static int mobMaxH;
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static String[] art = {
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

            "                                 _A_\n" +
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

            "     /'\n" +
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


            "    ,   A           {}\n" +
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


            "                          ,dM\n" +
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

            "                    _\n" +
                    "                    \\`\\\n" +
                    "                     \\ \\\n" +
                    "                      \\ \\\n" +
                    "                       \\ \\\n" +
                    "                        \\.\\\n" +
                    "                         \\.\\\n" +
                    "                          \\.\\  \n" +
                    "                 _         \\.\\/)\n" +
                    "            _ _-' ')__     (\\.\\/)\n" +
                    "           /       /  \\.'`'-\\/)\\\\\n" +
                    "           \\__ ,.-'(_  Y    (_\\.\\)\n" +
                    "            / <     ,\\  \\    ,\\\\.\\\\\n" +
                    "            \\_ \\ _. /y(_|    : |\\.\\|\n" +
                    "             _\\_\\\\   |    : | \\.\\\n" +
                    "            (   `'-._>/ )     \\|  \\.\\\n" +
                    "            \\         `:=.    (\\   \\.\\\n" +
                    "             \\_      (    `--._)`--'\\.\\=7\n" +
                    "            _/|\\_    \\-._     `-:_ /```-3    \n" +
                    "           /  |  `-   \\  t--._    Y    _3 \n" +
                    "        ,-'   |       /  |   /``'-.\\--T x\\\n" +
                    "      _/     _(    ,./  /   (          \\ x\\\n" +
                    "         _.-/  \\  /    <     \\          \\ x\\\n" +
                    "      <`'  /   |\\/      `-.   :          \\_x\\\n" +
                    "       \\  /    |           `. |\n" +
                    "        \\_|    /             `.\n" +
                    "          |   /                `.\n" +
                    "         /  _/\\                /"
    };

    public static void main(String[] args) {
        beginGame();
    }

    private static void beginGame() {
//        Scanner sc = new Scanner(System.in);
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
//        Scanner sc = new Scanner(System.in);
        System.out.println("What is your Name Adventurer?");
        sc.nextLine();
        playerName = sc.nextLine();
//        sc.nextLine();
        int PlayerHealth = 100;
        playerMaxH = PlayerHealth;
        int PlayerAttackMax = 30;
        int PlayerPotions = 5;
        if (playerName.equalsIgnoreCase("wwssadadba")){
            System.out.println("Hello Konami!!!");
            PlayerHealth = 3000;
            playerMaxH = PlayerHealth;
            PlayerAttackMax = 100;
            PlayerPotions = 30;
            playerName = "Konami!!!";
        }else if (playerName.trim().equalsIgnoreCase("")) {
            System.out.println("That is not a name...");
            beginAdventure();
        }
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
//        Random rand = new Random();
        int randArt = rand.nextInt(art.length - 1);
        System.out.println("Here is comes your Opponent:");
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Now Entering:");
        System.out.println(art[randArt]);
        System.out.println();
        mobName = monsterName();
        int[] mobStats = generateMonsterStats();
        int mobHealth = mobStats[0];
        mobMaxH = mobHealth;
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
//        Random rand = new Random();
        return rand.nextInt(maxDamage);
    }

    private static int potionHeal() {
//        Random rand = new Random();
        return rand.nextInt(24) + 1;
    }


    private static void enemyTurn(int[] playerstats, int[] enemystats) {
//        Random rand = new Random();
        int move = rand.nextInt(2);
        int dmg = damageDone(enemystats[1]);
        int heal = potionHeal();
        if (move == 1) {
            playerstats[0] -= dmg;
            System.out.printf("%s attacks %s for %s damage!\n", mobName, playerName, dmg);
        } else {
            if (mobMaxH < enemystats[0]+ heal){
                heal = mobMaxH - enemystats[0];
                System.out.printf("Enemy used a potion and healed %s damage!\n", heal);
                enemystats[0] = mobMaxH;
            }else {
                enemystats[0] += heal;
                System.out.printf("Enemy used a potion and healed %s damage!\n", heal);
            }
        }
        if (playerstats[0] <= 0) {
            gameOver();
        } else {
            combat(playerstats, enemystats);
        }

    }

    private static void combat(int[] playerStats, int[] mobStats) {
//        Scanner sc = new Scanner(System.in);
//        Random rand = new Random();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("%s Stats:%n", playerName);
        System.out.println();
        System.out.printf("Health: %s\nAttack: %s\nPotions: %s\n\n", playerStats[0], playerStats[1], playerStats[2]);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("What will you do?\nA.Attack\nB.Potion\nC.Run?");

        String action = sc.next();
        if (action.equalsIgnoreCase("a") || action.equalsIgnoreCase("attack")) {
            System.out.println("Attacking...");
            int damage = damageDone(playerStats[1]);
            System.out.printf("%s attacks %s for %s damage.\n", playerName, mobName, damage);
            mobStats[0] -= damage;
        } else if (action.equalsIgnoreCase("b") || action.equalsIgnoreCase("potion")) {
            System.out.println("Using Potion...");
            if (playerStats[2] > 0) {
                int heals = potionHeal();
                if (playerMaxH < playerStats[0]+heals){
                    heals = playerMaxH - playerStats[0];
                    System.out.printf("Potion heals %s for %s health", playerName, heals);
                    playerStats[0] = playerMaxH;
                }else {
                    System.out.printf("Potion heals %s for %s health", playerName, heals);
                    playerStats[0] += heals;
                }
                playerStats[2] -= 1;
                System.out.printf("You have %s potions left\n", playerStats[2]);
            } else {
                System.out.println("You Don't have any potions left...");
                combat(playerStats, mobStats);
            }
        } else if (action.equalsIgnoreCase("c") || action.equalsIgnoreCase("run")) {
            System.out.println("there is not escape from the arena...");
            combat(playerStats, mobStats);
        } else if(action.equalsIgnoreCase("quack")){
            gameOver();
        }

        if (mobStats[0] <= 0) {
            System.out.printf("%s Has Been Defeated!!!\n", mobName);
            int hasPotion = rand.nextInt(2);
            if (hasPotion == 1) {
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
            enemyTurn(playerStats, mobStats);
        }


    }

    private static int[] generateMonsterStats() {
//        Random rand = new Random();
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
//        Random rand = new Random();
        return mobNameC[rand.nextInt(mobNameC.length - 1)] + " " + mobTitle[rand.nextInt(mobTitle.length - 1)];
    }

    private static void gameOver() {
//        Scanner sc = new Scanner(System.in);

        System.out.printf(
                "                 _  /)\n" +

                        "                 mo / )\n" +
                        "                 |/)\\)\n" +
                        "                  /\\_\n" +
                        "                  \\__|=\n" +
                        "                 (    )\n" +
                        "                 __)(__\n" +
                        "           _____/      \\\\_____\n" +
                        "          |  _     ___   _   ||\n" +
                        "          | | \\     |   | \\  ||\n" +
                        "          | |  |    |   |  | ||\n" +
                        "          | |_/     |   |_/  ||\n" +
                        "          | | \\     |   |    ||\n" +
                        "          | |  \\    |   |    ||\n" +
                        "          | |   \\. _|_. | .  ||\n" +
                        "          |                  ||\n" +
                        "                 %s          \n" +
                        "          |                  ||\n", playerName);

        System.out.println("GAME OVER!!!");
        System.out.printf("Score: %s%n", score);
        System.out.println();
        System.out.println("Restart? (yes/no)");
        String continueGame = sc.next();
        if (continueGame.equalsIgnoreCase("yes")) {
            System.out.println("restarting...");
            beginAdventure();
        } else if (continueGame.equalsIgnoreCase("no")) {
            System.out.println("Goodbye");
            System.exit(0);
        } else {
            System.out.println("Not a valid input.");
            gameOver();
        }
    }
}