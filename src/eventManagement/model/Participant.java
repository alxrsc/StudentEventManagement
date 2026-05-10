package eventManagement.model;
import java.util.ArrayList;
import java.util.List;

public class Participant extends User {
	private List<Event> calendar = new ArrayList<>();

	public Participant(String userName, String password, String name, String surname) {
        super(userName, password, name, surname);
        this.role = "PARTICIPANT";
    }
	
	@Override
	public void joinEvent(Event newEvent) {
		if ( isAuthenticated() ) {
			System.out.println("Participant " + this.getName() + " joined an event as attendee.");
			calendar.add(newEvent);
			System.out.println("Event '" + newEvent.getName() + "' added to participant's calendar.");
		}
		else {
			System.out.println("Error: Participant must be logged in to join an event.");
		}
	}

	@Override
	public void viewCalendar() {
		System.out.println("Participant " + this.getName() + " is viewing their event calendar.");
		if (calendar.isEmpty()) {
			System.out.println("No events in calendar.");
		} else {
			for (Event e : calendar) {
				System.out.println("- " + e.getName() + " at " + e.getLocation());
			}
		}
	}

	public void addEventToCalendar(Event event) {
        calendar.add(event);
    }
	
	@Override
	public void addPresentation(Presentation presentation) {
		System.out.println("Presentation '" + presentation.getTitle() + "' added to participant's calendar.");
	}
	
	public Feedback giveFeedback(Event event) {
		Feedback feedback = new Feedback(5, "Great event!"); 
		event.addFeedback(feedback);
        System.out.println("Feedback sent for event " + event.getName() + ": " + feedback.getStars() + " stars, " + feedback.getDescription());
        return feedback;
    }

}