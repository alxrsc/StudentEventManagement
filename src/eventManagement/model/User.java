package eventManagement.model;

public abstract class User {
	protected String userName;
    protected String password;
    protected String name;
    protected String surname;
    protected String role;

    public boolean login(String username, String password) {
        return true; 
    }

    public abstract void joinEvent();
    
    public abstract void viewCalendar();
}
