package eventManagement.model;

public abstract class User {
	protected String userName;
    protected String password;
    protected String name;
    protected String surname;
    protected String role;
    
    public String getUserName() { return userName; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getRole() { return role; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }

    // Password validation
    public boolean verifyPassword(String input) {
        return this.password.equals(input);
    }

public boolean login(String enteredUsername, String enteredPassword) {
    if (!this.userName.equals(enteredUsername)) {
        System.out.println("Error: Username '" + enteredUsername + "' not found.");
        return false;
    }

    if (!this.password.equals(enteredPassword)) {
        System.out.println("Error: Incorrect password for user " + enteredUsername + ".");
        return false;
    }

    System.out.println("Login successful! Welcome, " + this.name + " " + this.surname + ".");
    return true;
}

    public abstract void joinEvent();
    
    public abstract void viewCalendar();
}
