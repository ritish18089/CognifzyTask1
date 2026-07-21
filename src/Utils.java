import java.util.Scanner;

public class Utils {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printHeader(String title) {
        System.out.println("\n=========================================");
        System.out.println("  " + title.toUpperCase());
        System.out.println("=========================================");
    }

    public static void printSeparator() {
        System.out.println("-----------------------------------------");
    }

    public static String readString(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim();
    }

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + " (" + min + "-" + max + "): ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void pressEnterToContinue() {
        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
