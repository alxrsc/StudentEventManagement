package eventManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
	private String name;
    private String location;
    private String date;
    private Organiser organiser;
    private int maxNumberOfParticipants;
    private List<Feedback> feedbacks; // composition

    public Event() {
        // Inițializăm lista în constructor
        this.feedbacks = new ArrayList<>();
    }

    public Event(String name, String location, Organiser organiser) {
        this(); 
        this.name = name;
        this.location = location;
        this.organiser = organiser;
    }

    // add feedback, used for composition
    public void addFeedback(int stars, String description) {
        Feedback newFeedback = new Feedback(stars, description);
        this.feedbacks.add(newFeedback);
    }
    
    public int getFeedbackCount() {
        return feedbacks.size();
    }

    public String getName() { return name; }

    public void joinEvent(Category category) {
    	System.out.println("User registered as: " + category);
    }

    public void addToCalendar() {
    	System.out.println("Event " + name + " has been scheduled for " + date);
    }
    
    public boolean hasAvailableSlots(int currentParticipants) {
        return currentParticipants < maxNumberOfParticipants;
    }
}
