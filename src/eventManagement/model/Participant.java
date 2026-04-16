package eventManagement.model;

public class Participant extends User {

	public Participant(String userName, String password, String name, String surname) {
        super(userName, password, name, surname);
        this.role = "PARTICIPANT";
    }
	
	@Override
	public void joinEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCalendar() {
		// TODO Auto-generated method stub

	}
	
	public void giveFeedback() {
        System.out.println("Feedback sent.");
    }

}
