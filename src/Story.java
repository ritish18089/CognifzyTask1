public class Story {

    public static void printIntro() {
        System.out.println("\n");
        System.out.println("      ____  _____ _____ _____ ____ _____ _____     _____ ");
        System.out.println("     |    \\|   __|__   __|   |    |     |   | |   |     |    ");
        System.out.println("     |  |  |   __|  | |  |   |  |  |   | | | | |   |  |  |    ");
        System.out.println("     |____/|_____|  |_|  |___|____/|___|_|_|___|   |_____|    ");
        System.out.println("\n");
        System.out.println("     M Y S T E R Y   G A M E   -   T H E   S T O L E N   D I A M O N D");
        System.out.println("\n");
        System.out.println("A valuable diamond, the 'Star of Cognifzy', has been stolen from the City Museum.");
        System.out.println("You are a seasoned detective assigned to solve this high-profile case.");
        System.out.println("You must visit different crime locations, search for clues, collect evidence,");
        System.out.println("interrogate suspects, and identify the real criminal before they escape!");
        System.out.println("\nGood luck, Detective.");
    }

    public static void printWin() {
        System.out.println("\n");
        System.out.println("=========================================");
        System.out.println("          C A S E   C L O S E D         ");
        System.out.println("=========================================");
        System.out.println("\nCongratulations! You have identified the correct criminal and solved the case.");
        System.out.println("The 'Star of Cognifzy' has been recovered and the criminal is behind bars.");
        System.out.println("You are a true master detective!");
    }

    public static void printLoseTime() {
        System.out.println("\n");
        System.out.println("=========================================");
        System.out.println("          G A M E   O V E R             ");
        System.out.println("=========================================");
        System.out.println("\nYou ran out of time! The criminal has escaped with the diamond.");
        System.out.println("The case remains unsolved.");
    }

    public static void printLoseWrongSuspect() {
        System.out.println("\n");
        System.out.println("=========================================");
        System.out.println("          G A M E   O V E R             ");
        System.out.println("=========================================");
        System.out.println("\nYou arrested the wrong suspect! The real criminal got away.");
        System.out.println("Your reputation as a detective is ruined.");
    }
}
