package eventManagement.model;

public class Presentation {
	private String title;
    private String author;
    private String subject;
    private Status status; 

    public Presentation(String title, String author) {
        this.title = title;
        this.author = author;
        this.status = Status.PENDING; // initial state
    }

    // Getters
    public String getTitle() { return title; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
