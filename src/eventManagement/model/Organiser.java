package eventManagement.model;

public class Organiser extends User {

	@Override
	public void joinEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCalendar() {
		// TODO Auto-generated method stub

	}
	
    public void createEvent() {
        System.out.println("Se creează un eveniment nou...");
    }

    public Status approvePresentation(Event event, Presentation presentation) {
        System.out.println("Se analizează prezentarea: " + presentation.getTitle());
        return Status.APPROVED;
    }

    public void giveAward(Participant participant, Presentation presentation) {
        System.out.println("Premiu acordat lui " + participant.getName() + " pentru lucrarea " + presentation.getTitle());
    }

}
