package eventManagement.model;

public class Participant extends User {

	public Participant(String username, String password) {
        this.userName = username;
        this.password = password;
        this.role = "Participant"; // Assign default rights here
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
