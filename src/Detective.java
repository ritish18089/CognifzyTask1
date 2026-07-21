import java.util.ArrayList;
import java.util.List;

public class Detective {
    private List<Clue> notebook;
    private List<Evidence> inventory;
    
    public Detective() {
        this.notebook = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }
    
    public void addClue(Clue clue) {
        if (!notebook.contains(clue)) {
            notebook.add(clue);
        }
    }
    
    public void addEvidence(Evidence evidence) {
        if (!inventory.contains(evidence)) {
            inventory.add(evidence);
        }
    }
    
    public List<Clue> getNotebook() {
        return notebook;
    }
    
    public List<Evidence> getInventory() {
        return inventory;
    }
    
    public void viewNotebook() {
        Utils.printHeader("Detective Notebook");
        if (notebook.isEmpty()) {
            System.out.println("Your notebook is empty. Search for clues!");
            return;
        }
        for (int i = 0; i < notebook.size(); i++) {
            Clue c = notebook.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " - " + (c.isExamined() ? c.getDescription() : "[Not Examined]"));
        }
        System.out.println("\nOptions:");
        System.out.println("1. Examine a clue");
        System.out.println("2. Back");
        
        int choice = Utils.readInt("Choose option", 1, 2);
        if (choice == 1) {
            int clueChoice = Utils.readInt("Select clue to examine", 1, notebook.size());
            Clue clue = notebook.get(clueChoice - 1);
            clue.examine();
            System.out.println("\nYou examined: " + clue.getName());
            System.out.println("Details: " + clue.getDescription());
        }
    }
    
    public void viewInventory() {
        Utils.printHeader("Inventory");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty. Collect some evidence!");
            return;
        }
        for (int i = 0; i < inventory.size(); i++) {
            Evidence e = inventory.get(i);
            System.out.println((i + 1) + ". " + e.getName() + " - " + (e.isExamined() ? e.getDescription() : "[Not Examined]"));
        }
        System.out.println("\nOptions:");
        System.out.println("1. Examine evidence");
        System.out.println("2. Back");
        
        int choice = Utils.readInt("Choose option", 1, 2);
        if (choice == 1) {
            int evChoice = Utils.readInt("Select evidence to examine", 1, inventory.size());
            Evidence ev = inventory.get(evChoice - 1);
            ev.examine();
            System.out.println("\nYou examined: " + ev.getName());
            System.out.println("Details: " + ev.getDescription());
        }
    }
}
