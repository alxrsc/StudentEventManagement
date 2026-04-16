package eventManagement.model;

public class Event {
	private String name;
    private String location;
    private String date;
    private Organiser organiser;
    private int maxNumberOfParticipants;

    public Event(String name, String location, Organiser organiser) {
        this.name = name;
        this.location = location;
        this.organiser = organiser;
    }

    public void joinEvent(Category category) {
    	System.out.println("User registered as: " + category);
    }

    public void addToCalendar() {
    	System.out.println("Event " + name + " has been scheduled for " + date);
    }
}
