package eventManagement.model;

public class Admin {
	private String userName;
    private String password;
    private boolean authenticated = false;
	
	public void manageAccounts() {
		System.out.println("Admin is managing user accounts.");
	}
	public void technicalSupport() {
		System.out.println("Admin is providing technical support.");
	}
	
	public boolean login(String enteredUsername, String enteredPassword) {
	    if (!this.userName.equals(enteredUsername)) {
	        System.out.println("Error: Username '" + enteredUsername + "' not found.");
	        this.authenticated = false;
	        return false;
	    }

	    if (!this.password.equals(enteredPassword)) {
	        System.out.println("Error: Incorrect password for user " + enteredUsername + ".");
	        this.authenticated = false;
	        return false;
	    }

	    System.out.println("Login successful! Welcome, admin!");
	    this.authenticated = true;
	    return true;
	}
	
	public void logout() {
        this.authenticated = false;
    }
}
