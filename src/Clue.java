public class Clue {
    private String name;
    private String description;
    private boolean isExamined;

    public Clue(String name, String description) {
        this.name = name;
        this.description = description;
        this.isExamined = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExamined() {
        return isExamined;
    }

    public void examine() {
        isExamined = true;
    }
}
