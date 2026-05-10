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
	public void joinEvent() {
		System.out.println("Participant " + this.getName() + " joined an event as attendee.");
		// For demonstration, add a dummy event to the calendar
		Event event = new Event("Participant's Event", "Room 101", null);
		calendar.add(event);
		System.out.println("Event '" + event.getName() + "' added to participant's calendar.");
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
	
	public void giveFeedback() {
        System.out.println("Feedback sent.");
    }

}