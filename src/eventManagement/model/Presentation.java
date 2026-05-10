package eventManagement.model;

public class Presentation {
	private String title;
    private String author;
    private String subject;
    private Status status; 
    
    public Presentation() {
		// default constructor
	}

    public Presentation(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = Status.PENDING; // initial state
    }

    // Getters
    public String getTitle() { return title; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        this.status = status;
    }

    // method to notify the author about the status
    public String notifyAuthor(String message) {
        return "Notification sent: " + message;
    }

    // method to generate a diploma for the presentation
    public String generateDiploma() {
        return "Diploma generated for presentation: " + title;
    }
}