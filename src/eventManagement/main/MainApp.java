package eventManagement.main;

import eventManagement.model.*;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("=== Student Event Management System ===\n");

        Organiser organiser = new Organiser("admin_raul", "pass123", "Raul", "Ionescu");
        Participant student = new Participant("stud_maria", "maria2026", "Maria", "Enache");
        Admin sysAdmin = new Admin();

        // Login
        System.out.println("--- Testing Login Functionality ---");
        organiser.login("admin_raul", "pass123"); // Success
        student.login("stud_maria", "wrong_pass"); // Failure
        System.out.println();

        Event JavaConf = new Event("Java University Conference", "Aula Magna", organiser);
        JavaConf.addToCalendar();
        System.out.println("Event '" + JavaConf.getName() + "' is managed by: " + organiser.getName());
        System.out.println();

        // Add event to organizer and participant calendars
        organiser.addEventToCalendar(JavaConf);
        student.addEventToCalendar(JavaConf);

        // join an event
        organiser.joinEvent(JavaConf);
        student.joinEvent(JavaConf);

        // view their calendars
        System.out.println("\n--- Organiser Calendar ---");
        organiser.viewCalendar();
        System.out.println("\n--- Participant Calendar ---");
        student.viewCalendar();

        System.out.println("--- Testing (Event-Feedback) ---");
		student.giveFeedback(JavaConf);
		student.giveFeedback(JavaConf);        
		
        System.out.println("Total feedback entries for this event: " + JavaConf.getFeedbackCount());
        System.out.println();

        System.out.println("--- Testing Specific Actions ---");
        organiser.createEvent();
        
        Presentation myPresentation = new Presentation("AI in 2026", "Maria Enache");
        Status result = organiser.approvePresentation(JavaConf, myPresentation);
        
        if(result == Status.APPROVED) {
            organiser.giveAward(student, myPresentation);
        }

        // admin system actions
        System.out.println("\n--- Admin System Actions ---");
        sysAdmin.manageAccounts();
        sysAdmin.technicalSupport();

        
	}

}
