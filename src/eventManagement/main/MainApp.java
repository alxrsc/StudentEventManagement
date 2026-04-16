package eventManagement.main;

import eventManagement.model.*;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=== Student Event Management System ===\n");

        Organiser admin = new Organiser("admin_raul", "pass123", "Raul", "Ionescu");
        Participant student = new Participant("stud_maria", "maria2026", "Maria", "Enache");

        // Login
        System.out.println("--- Testing Login Functionality ---");
        admin.login("admin_raul", "pass123"); // Success
        student.login("stud_maria", "wrong_pass"); // Failure demo
        System.out.println();

        // association
        Event JavaConf = new Event("Java University Conference", "Aula Magna", admin);
        JavaConf.addToCalendar();
        System.out.println("Event '" + JavaConf.getName() + "' is managed by: " + admin.getName());
        System.out.println();

        // composition
        System.out.println("--- Testing Composition (Event-Feedback) ---");
        JavaConf.addFeedback(5, "Excellent organization and great speakers!");
        JavaConf.addFeedback(4, "Very informative, but the room was a bit cold.");
        
        System.out.println("Total feedback entries for this event: " + JavaConf.getFeedbackCount());
        System.out.println();

        System.out.println("--- Testing Specific Actions ---");
        admin.createEvent();
        
        Presentation myPresentation = new Presentation("AI in 2026", "Maria Enache");
        Status result = admin.approvePresentation(JavaConf, myPresentation);
        
        if(result == Status.APPROVED) {
            admin.giveAward(student, myPresentation);
        }

        System.out.println("\n=== All UML relationships verified in code ===");
	}

}
