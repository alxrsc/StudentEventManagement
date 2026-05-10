package eventManagement.model;
import java.util.ArrayList;
import java.util.List;

public class Organiser extends User {
  private List<Event> calendar = new ArrayList<>();

	public Organiser(String userName, String password, String name, String surname) {
        super(userName, password, name, surname);
        this.role = "ORGANISER";
    }
	
	@Override
	public void joinEvent(Event newEvent) {
		if( isAuthenticated() ) {
			System.out.println("Organiser " + this.getName() + " joined an event as host.");
		    Event event =  newEvent;// Create a new event and join it
		    calendar.add(event);
		    System.out.println("Event '" + event.getName() + "' added to organiser's calendar.");
		}
		else {
			System.out.println("Error: Organiser must be logged in to join an event.");
		}
	}

	@Override
	public void viewCalendar() {
		System.out.println("Organiser " + this.getName() + " is viewing their event calendar.");
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

    public Event createEvent() {
        System.out.println("Creating a new event...");
        Event event = new Event("Organiser's Event", "Main Hall", this);
        joinEvent(event); // join the event as the host
        addEventToCalendar(event); // add the event to the calendar
        return event;
    }

    @Override
    public void addPresentation(Presentation presentation) {
		System.out.println("Presentation '" + presentation.getTitle() + "' added to participant's calendar.");
		approvePresentation(null, presentation); // approve presentation by default for organizer
	}

    
    public Status approvePresentation(Event event, Presentation presentation) {
        System.out.println("Reviewing presentation: " + presentation.getTitle());
        
        presentation.setStatus(Status.APPROVED);
        
        presentation.notifyAuthor("Your presentation has been approved!");
        
        presentation.generateDiploma();
        
        return Status.APPROVED;
    }
    
    public Status rejectPresentation(Event event, Presentation presentation) {
        System.out.println("Reviewing presentation: " + presentation.getTitle());
        
        presentation.setStatus(Status.REJECTED);
        presentation.notifyAuthor("Your presentation has been rejected.");
        
        return Status.REJECTED;
    }

    public void giveAward(Participant participant, Presentation presentation) {
    	String fullName = participant.getName() + " " + participant.getSurname();
        System.out.println("Award granted to " + fullName + " for the paper: " + presentation.getTitle());
        presentation.generateDiploma();
    }

}