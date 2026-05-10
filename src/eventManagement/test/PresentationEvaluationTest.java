package eventManagement.test;

import eventManagement.model.Presentation;
import eventManagement.model.Status;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PresentationEvaluationTest {
    private List<Presentation> presentationList = new ArrayList<>();

    @Test
    void testApprovePresentation() {
        Presentation presentation = new Presentation();
        presentation.setStatus(Status.PENDING);
        presentation.setStatus(Status.APPROVED);
        String notification = presentation.notifyAuthor("approved");
        String diploma = presentation.generateDiploma();
        assertEquals(Status.APPROVED, presentation.getStatus());
        assertEquals("Notification sent: approved", notification);
        assertNotNull(diploma);
    }

    @Test
    void testRejectPresentation() {
        Presentation presentation = new Presentation();
        presentation.setStatus(Status.PENDING);
        presentation.setStatus(Status.REJECTED);
        String notification = presentation.notifyAuthor("rejected");
        assertEquals(Status.REJECTED, presentation.getStatus());
        assertEquals("Notification sent: rejected", notification);
    }

    @Test
    void testEmptyPresentationList() {
        assertTrue(presentationList.isEmpty(), "The presentation list should be empty.");
    }

    @Test
    void testAddPresentationToList() {
        Presentation presentation = new Presentation("Title1", "Author1");
        presentationList.add(presentation);
        assertFalse(presentationList.isEmpty(), "The presentation list should not be empty.");
        assertEquals(1, presentationList.size(), "The presentation list should contain one item.");
    }

    @Test
    void testRetrievePresentationFromList() {
        Presentation presentation = new Presentation("Title1", "Author1");
        presentationList.add(presentation);
        Presentation retrieved = presentationList.get(0);
        assertEquals(presentation, retrieved, "The retrieved presentation should match the added one.");
    }

    @Test
    void testAddDuplicatePresentation() {
        Presentation presentation = new Presentation("Title1", "Author1");
        presentationList.add(presentation);
        boolean addedAgain = presentationList.add(presentation);
        assertTrue(addedAgain, "Duplicate presentations should be allowed in the list.");
        assertEquals(2, presentationList.size(), "The list should contain two presentations.");
    }

    @Test
    void testInvalidStatusChange() {
        Presentation presentation = new Presentation("Title1", "Author1");
        presentation.setStatus(Status.APPROVED);
        assertThrows(IllegalArgumentException.class, () -> {
            presentation.setStatus(null);
        }, "Setting an invalid status should throw an exception.");
    }
}