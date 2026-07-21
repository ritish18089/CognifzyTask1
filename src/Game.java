import java.util.ArrayList;
import java.util.List;

public class Game {
    private Detective detective;
    private CaseFile caseFile;
    private List<CrimeScene> locations;
    private boolean isGameOver;
    private int difficulty; // 1 = Easy, 2 = Medium, 3 = Hard
    private int remainingTurns;

    public Game() {
        this.detective = new Detective();
        this.caseFile = new CaseFile();
        this.locations = new ArrayList<>();
        this.isGameOver = false;
        setupLocations();
    }

    private void setupLocations() {
        CrimeScene museum = new CrimeScene("Museum", "The main hall where the diamond was displayed. Glass is shattered everywhere.", false);
        museum.addEvidence(new Evidence("Broken Glass", "Glass shards with traces of blood."));
        museum.addClue(new Clue("Security Card", "A card belonging to a staff member."));
        
        CrimeScene library = new CrimeScene("Library", "A quiet room filled with old books. Someone has been searching through the archives.", false);
        library.addClue(new Clue("Torn Page", "A page ripped from a book about famous diamonds."));
        library.addEvidence(new Evidence("Fingerprints", "Partial prints found on the bookshelf."));

        CrimeScene hotel = new CrimeScene("Hotel", "A luxury suite booked under a fake name.", false);
        hotel.addClue(new Clue("Note pad imprint", "Faint writing that says 'Meet at the warehouse'."));

        CrimeScene warehouse = new CrimeScene("Warehouse", "An abandoned facility by the docks.", false); // Could be locked initially
        warehouse.addEvidence(new Evidence("Muddy Footprints", "Size 10 footprints leading away from a side door."));
        
        CrimeScene lab = new CrimeScene("Secret Laboratory", "Hidden behind the warehouse. Contains high-tech equipment.", true);
        
        CrimeScene park = new CrimeScene("Park", "A public park across from the museum.", false);
        park.addClue(new Clue("Cigarette Butt", "A unique brand smoked by someone waiting in the bushes."));
        
        CrimeScene policeStation = new CrimeScene("Police Station", "The local precinct. You can review profiles here.", false);

        locations.add(museum);
        locations.add(library);
        locations.add(hotel);
        locations.add(warehouse);
        locations.add(lab);
        locations.add(park);
        locations.add(policeStation);
    }

    public void start() {
        Story.printIntro();
        
        Utils.printHeader("Select Difficulty");
        System.out.println("1. Easy (30 turns)");
        System.out.println("2. Medium (20 turns)");
        System.out.println("3. Hard (15 turns)");
        difficulty = Utils.readInt("Choose difficulty", 1, 3);
        
        remainingTurns = switch (difficulty) {
            case 1 -> 30;
            case 2 -> 20;
            case 3 -> 15;
            default -> 20;
        };
        
        gameLoop();
    }

    private void gameLoop() {
        while (!isGameOver && remainingTurns > 0) {
            Utils.printHeader("DETECTIVE MYSTERY GAME");
            System.out.println("Turns left: " + remainingTurns);
            System.out.println("\n1. Visit Crime Scene");
            System.out.println("2. Interrogate Suspects");
            System.out.println("3. View Notebook (Clues)");
            System.out.println("4. Inventory (Evidence)");
            System.out.println("5. Solve Puzzle");
            System.out.println("6. Accuse Suspect");
            System.out.println("7. Help");
            System.out.println("8. Exit Game");

            int choice = Utils.readInt("Choose an action", 1, 8);

            switch (choice) {
                case 1 -> visitLocation();
                case 2 -> caseFile.interrogateSuspects();
                case 3 -> detective.viewNotebook();
                case 4 -> detective.viewInventory();
                case 5 -> caseFile.solvePuzzle();
                case 6 -> handleAccusation();
                case 7 -> showHelp();
                case 8 -> isGameOver = true;
            }
            
            if (choice >= 1 && choice <= 6 && choice != 3 && choice != 4) {
                remainingTurns--;
            }
        }

        if (remainingTurns <= 0 && !isGameOver) {
            Story.printLoseTime();
        }
    }

    private void visitLocation() {
        Utils.printHeader("Locations");
        for (int i = 0; i < locations.size(); i++) {
            CrimeScene loc = locations.get(i);
            System.out.println((i + 1) + ". " + loc.getName() + (loc.isLocked() ? " [LOCKED]" : ""));
        }
        System.out.println((locations.size() + 1) + ". Back");

        int choice = Utils.readInt("Where do you want to go?", 1, locations.size() + 1);
        
        if (choice <= locations.size()) {
            CrimeScene selected = locations.get(choice - 1);
            if (selected.isLocked()) {
                if (caseFile.isPuzzleSolved()) {
                    System.out.println("You unlock the door using the terminal code.");
                    selected.unlock();
                    selected.searchScene(detective);
                } else {
                    System.out.println("This location is locked. You need to solve a puzzle to enter.");
                }
            } else {
                selected.searchScene(detective);
            }
        }
    }

    private void handleAccusation() {
        boolean won = caseFile.accuseSuspect(detective);
        if (won) {
            Story.printWin();
            isGameOver = true;
        } else if (remainingTurns > 1) { // If they lost but still have turns, it means they made a wrong accusation and the game should end immediately. 
            // The prompt says "Player loses if: Wrong suspect arrested". So it should end game.
            Story.printLoseWrongSuspect();
            isGameOver = true;
        }
    }

    private void showHelp() {
        Utils.printHeader("Help");
        System.out.println("Your goal is to find the person who stole the diamond.");
        System.out.println("- Visit locations to find clues and evidence.");
        System.out.println("- Interrogate suspects to find inconsistencies in their stories.");
        System.out.println("- Solve puzzles to unlock new areas or prove your case.");
        System.out.println("- You must solve the main puzzle and collect at least 2 pieces of evidence to convict someone.");
        System.out.println("- Be careful, accusing the wrong person or running out of turns ends the game!");
        Utils.pressEnterToContinue();
    }
}
