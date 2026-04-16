package eventManagement.model;

public class Guest {
	public boolean createAccount(String username, String password) {

        Participant newAccount = new Participant(username, password);
        
        System.out.println("Account successfully created for: " + username);
        
        return true;
	}
}
