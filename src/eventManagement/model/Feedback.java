package eventManagement.model;

public class Feedback {
    private int stars;
    private String description;

    public Feedback(int stars, String description) {
        this.stars = stars;
        this.description = description;
    }

    // Getters
    public int getStars() { return stars; }
    public String getDescription() { return description; }
    
    public void displayFeedback() {
        System.out.println("Rating: " + stars + " stars. Comment: " + description);
    }
}