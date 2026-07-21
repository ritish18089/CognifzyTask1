import java.util.ArrayList;
import java.util.List;

public class CrimeScene {
    private String name;
    private String description;
    private List<Clue> clues;
    private List<Evidence> evidences;
    private boolean isLocked;

    public CrimeScene(String name, String description, boolean isLocked) {
        this.name = name;
        this.description = description;
        this.clues = new ArrayList<>();
        this.evidences = new ArrayList<>();
        this.isLocked = isLocked;
    }

    public void addClue(Clue clue) {
        clues.add(clue);
    }

    public void addEvidence(Evidence evidence) {
        evidences.add(evidence);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return isLocked;
    }
    
    public void unlock() {
        isLocked = false;
    }

    public List<Clue> getClues() {
        return clues;
    }

    public List<Evidence> getEvidences() {
        return evidences;
    }

    public void searchScene(Detective detective) {
        Utils.printHeader("Searching " + name);
        System.out.println(description);
        System.out.println("\nYou found some items!");

        for (Clue clue : clues) {
            if (!detective.getNotebook().contains(clue)) {
                System.out.println("- Found a Clue: " + clue.getName());
                detective.addClue(clue);
            }
        }

        for (Evidence evidence : evidences) {
            if (!detective.getInventory().contains(evidence)) {
                System.out.println("- Found Evidence: " + evidence.getName());
                detective.addEvidence(evidence);
            }
        }
        
        if (clues.isEmpty() && evidences.isEmpty()) {
            System.out.println("Nothing interesting found here.");
        }
    }
}
