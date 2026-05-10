package eventManagement.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import eventManagement.model.Event;
import eventManagement.model.Organiser;
import eventManagement.model.Participant;

public class EventEnrollmentTest {

    private Event conference;
    private Participant participant;
    private Organiser admin;

    @BeforeEach
    public void setUp() {
        admin = new Organiser("admin", "Admin123", "AdminName", "AdminSurname");
        conference = new Event("Tech Conference", "Main Hall", admin);
        participant = new Participant("john_doe", "pass123", "John", "Doe");
    }

    @ParameterizedTest
    @CsvSource({
        "john_doe, pass123, 5, true, true, ''",                        // Valid auth, room for 5, expected true
        "john_doe, pass123, 1, true, true, ''",                        // Valid auth, room for 1, expected true
        "john_doe, wrong, 5, false, false, 'Authentication required'", // Bad password, expected throw
        "wrong_user, pass123, 5, false, false, 'Authentication required'" // Bad username, expected throw
    })
    public void testEnrollmentScenario(
            String uName, String pWord, int capacity,
            boolean expectAuth, boolean expectSuccess, String expectedMessageKey) {
        
        conference.setMaxNumberOfParticipants(capacity);
        boolean isLogged = participant.login(uName, pWord);
        assertEquals(expectAuth, isLogged, "Authentication result mismatch");
        assertEquals(expectAuth, participant.isAuthenticated(), "Participant session status mismatch");

        try {
            conference.enrollParticipant(participant);
            if (!expectSuccess) {
                fail("Expected exception was not thrown for failed scenario.");
            }
            assertTrue(conference.getEnrolledParticipants().contains(participant), "Participant should be enrolled");
        } catch (Exception e) {
            if (expectSuccess) {
                fail("Unexpected exception: " + e.getMessage());
            } else {
                assertTrue(e.getMessage().contains(expectedMessageKey), "Exception message did not match expected");
            }
        }
    }

    @Test
    public void testDuplicateEnrollmentException() {
        conference.setMaxNumberOfParticipants(10);
        participant.login("john_doe", "pass123");
        try {
            conference.enrollParticipant(participant);
            // Try again
            Exception exception = assertThrows(Exception.class, () -> {
                conference.enrollParticipant(participant);
            });
            assertEquals("Participant already enrolled.", exception.getMessage());
        } catch (Exception e) {
            fail("Initial enrollment should have succeeded.");
        }
    }

    @Test
    public void testEventCapacityLimitException() {
        conference.setMaxNumberOfParticipants(1);
        participant.login("john_doe", "pass123");
        
        Participant participant2 = new Participant("jane_doe", "pass123", "Jane", "Doe");
        participant2.login("jane_doe", "pass123");
        
        try {
            conference.enrollParticipant(participant);
            Exception exception = assertThrows(Exception.class, () -> {
                conference.enrollParticipant(participant2);
            });
            assertEquals("No available slots for this event.", exception.getMessage());
        } catch (Exception e) {
            fail("First enroll should succeed.");
        }
    }
}
