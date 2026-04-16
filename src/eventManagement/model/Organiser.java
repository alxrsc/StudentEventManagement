package eventManagement.model;

public class Organiser extends User {

	public Organiser(String userName, String password, String name, String surname) {
        super(userName, password, name, surname);
        this.role = "ORGANISER";
    }
	
	@Override
	public void joinEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCalendar() {
		// TODO Auto-generated method stub

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
