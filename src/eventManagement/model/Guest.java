package eventManagement.model;

public class Guest {
	public boolean createAccount(String username, String password, String name, String surname) {

        Participant newAccount = new Participant(username, password, name, surname);
        
        System.out.println("Account successfully created for: " + username);
        
        return true;
	}
}
