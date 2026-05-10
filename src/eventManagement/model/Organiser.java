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
	public void joinEvent() {
    System.out.println("Organiser " + this.getName() + " joined an event as host.");
    // For demonstration, add a dummy event to the calendar
    Event event = new Event("Organiser's Event", "Main Hall", this);
    calendar.add(event);
    System.out.println("Event '" + event.getName() + "' added to organiser's calendar.");
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

    public void createEvent() {
        System.out.println("Creating a new event...");
    }

    public Status approvePresentation(Event event, Presentation presentation) {
    	System.out.println("Reviewing presentation: " + presentation.getTitle());
        return Status.APPROVED;
    }

    public void giveAward(Participant participant, Presentation presentation) {
    	String fullName = participant.getName() + " " + participant.getSurname();
        System.out.println("Award granted to " + fullName + " for the paper: " + presentation.getTitle());
    }

}