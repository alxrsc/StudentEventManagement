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
    private List<Participant> enrolledParticipants; 

    public Event() {
        this.feedbacks = new ArrayList<>();
        this.enrolledParticipants = new ArrayList<>(); 
    }

    public Event(String name, String location, Organiser organiser) {
        this(); 
        this.name = name;
        this.location = location;
        this.organiser = organiser;
        this.maxNumberOfParticipants = 0;
    }
    
    public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
        this.maxNumberOfParticipants = maxNumberOfParticipants;
    }
    
    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }
    
    public List<Participant> getEnrolledParticipants() {
        return enrolledParticipants;
    }

    public void enrollParticipant(Participant p) throws Exception {
        if (!p.isAuthenticated()) {
            throw new Exception("Authentication required. Please login first.");
        }
        if (enrolledParticipants.contains(p)) {
            throw new Exception("Participant already enrolled.");
        }
        if (enrolledParticipants.size() >= maxNumberOfParticipants && maxNumberOfParticipants > 0) {
            throw new Exception("No available slots for this event.");
        }
        
        enrolledParticipants.add(p);
        p.addEventToCalendar(this);
        System.out.println("Participant " + p.getName() + " successfully enrolled in " + this.name);
    }

    // add feedback, used for composition
    public void addFeedback(Feedback feedback) {
        this.feedbacks.add(feedback);
    }
    
    public int getFeedbackCount() {
        return feedbacks.size();
    }

    public String getName() { return name; }
    public String getLocation() { return location; }

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