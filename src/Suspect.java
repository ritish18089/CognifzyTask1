import java.util.HashMap;
import java.util.Map;

public class Suspect {
    private String name;
    private int age;
    private String occupation;
    private String motive;
    private String alibi;
    private int truthfulnessLevel; // 1 to 10
    private boolean isGuilty;
    
    private Map<String, String> dialogueResponses;

    public Suspect(String name, int age, String occupation, String motive, String alibi, int truthfulnessLevel, boolean isGuilty) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.motive = motive;
        this.alibi = alibi;
        this.truthfulnessLevel = truthfulnessLevel;
        this.isGuilty = isGuilty;
        
        this.dialogueResponses = new HashMap<>();
        setupDialogue();
    }

    private void setupDialogue() {
        dialogueResponses.put("Where were you?", alibi);
        dialogueResponses.put("Do you know the victim?", "I've only heard of them in passing.");
        dialogueResponses.put("Tell the truth.", isGuilty ? "I am telling the truth! (Looks nervous)" : "I have nothing to hide.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getMotive() {
        return motive;
    }

    public boolean isGuilty() {
        return isGuilty;
    }

    public void interrogate() {
        Utils.printHeader("Interrogating " + name);
        System.out.println("Age: " + age + " | Occupation: " + occupation);
        System.out.println("Behavior: " + (truthfulnessLevel < 5 ? "Nervous and avoiding eye contact." : "Calm and collected."));
        
        boolean talking = true;
        while (talking) {
            System.out.println("\nQuestions:");
            System.out.println("1. Where were you during the crime?");
            System.out.println("2. Do you know the victim?");
            System.out.println("3. Tell the truth.");
            System.out.println("4. Stop interrogation");

            int choice = Utils.readInt("Choose a question", 1, 4);
            
            switch (choice) {
                case 1:
                    System.out.println("\n" + name + ": " + dialogueResponses.get("Where were you?"));
                    break;
                case 2:
                    System.out.println("\n" + name + ": " + dialogueResponses.get("Do you know the victim?"));
                    break;
                case 3:
                    System.out.println("\n" + name + ": " + dialogueResponses.get("Tell the truth."));
                    break;
                case 4:
                    talking = false;
                    break;
            }
        }
    }
}
