import java.util.ArrayList;
import java.util.List;

public class CaseFile {
    private List<Suspect> suspects;
    private Suspect guiltySuspect;
    private boolean puzzleSolved;

    public CaseFile() {
        this.suspects = new ArrayList<>();
        this.puzzleSolved = false;
        setupSuspects();
    }

    private void setupSuspects() {
        // Create at least 6 suspects
        Suspect s1 = new Suspect("John", 45, "Museum Curator", "Needed money to pay off debts.", "Was at home watching TV.", 4, false);
        Suspect s2 = new Suspect("Emily", 32, "Security Guard", "Felt underpaid and undervalued.", "On patrol on the other side of the building.", 7, false);
        Suspect s3 = new Suspect("David", 29, "Janitor", "Had keys to all rooms.", "Cleaning the basement.", 6, false);
        Suspect s4 = new Suspect("Sophia", 38, "Art Historian", "Obsessed with the Star of Cognifzy.", "Studying in the library.", 2, true); // Guilty
        Suspect s5 = new Suspect("Michael", 50, "Billionaire Collector", "Wants what he cannot buy.", "Attending a gala.", 8, false);
        Suspect s6 = new Suspect("Olivia", 26, "Tour Guide", "Needs quick cash for traveling.", "Giving a late-night tour.", 5, false);

        suspects.add(s1);
        suspects.add(s2);
        suspects.add(s3);
        suspects.add(s4);
        suspects.add(s5);
        suspects.add(s6);
        
        guiltySuspect = s4;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }
    
    public void interrogateSuspects() {
        Utils.printHeader("Suspect List");
        for (int i = 0; i < suspects.size(); i++) {
            System.out.println((i + 1) + ". " + suspects.get(i).getName() + " - " + suspects.get(i).getOccupation());
        }
        System.out.println((suspects.size() + 1) + ". Back");

        int choice = Utils.readInt("Who would you like to interrogate?", 1, suspects.size() + 1);
        
        if (choice <= suspects.size()) {
            suspects.get(choice - 1).interrogate();
        }
    }

    public boolean isPuzzleSolved() {
        return puzzleSolved;
    }

    public void solvePuzzle() {
        if (puzzleSolved) {
            System.out.println("You have already solved the main puzzle!");
            return;
        }

        Utils.printHeader("Logic Puzzle: The Security Terminal");
        System.out.println("The criminal locked the evidence vault with a 3-digit code.");
        System.out.println("Hint 1: 682 - One number is correct and well placed.");
        System.out.println("Hint 2: 614 - One number is correct but wrong place.");
        System.out.println("Hint 3: 206 - Two numbers are correct but wrong places.");
        System.out.println("Hint 4: 738 - Nothing is correct.");
        System.out.println("Hint 5: 380 - One number is correct but wrong place.");

        int attempt = Utils.readInt("Enter the 3-digit code (or 0 to cancel)", 0, 999);
        
        if (attempt == 0) return;
        
        if (attempt == 42) {
            // Secret override for dev testing, normally 042
        }

        if (attempt == 42 || attempt == 42) { // 042
            System.out.println("Access Granted! Puzzle solved.");
            puzzleSolved = true;
        } else {
            System.out.println("Access Denied. Try again later.");
        }
    }
    
    public boolean accuseSuspect(Detective detective) {
        Utils.printHeader("Accuse a Suspect");
        System.out.println("This is your final chance. If you get it wrong, the game is over.");
        
        for (int i = 0; i < suspects.size(); i++) {
            System.out.println((i + 1) + ". " + suspects.get(i).getName());
        }
        System.out.println((suspects.size() + 1) + ". Cancel");

        int choice = Utils.readInt("Who is the criminal?", 1, suspects.size() + 1);
        
        if (choice <= suspects.size()) {
            Suspect accused = suspects.get(choice - 1);
            if (accused == guiltySuspect && puzzleSolved && detective.getInventory().size() >= 2) {
                System.out.println("\nYou accused " + accused.getName() + " and presented enough evidence!");
                return true; // Won
            } else if (accused == guiltySuspect) {
                System.out.println("\nYou accused the right person, but without solving the puzzle or enough evidence, the judge dismissed the case!");
                return false; // Lost
            } else {
                System.out.println("\nYou accused the wrong person! " + accused.getName() + " is innocent.");
                return false; // Lost
            }
        }
        return false; // Cancelled/Lost
    }
}
