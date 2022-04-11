package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalMeetings.WITH_ALICE;
import static seedu.address.testutil.TypicalMeetings.WITH_BENSON;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MeetingCardTest {

    @BeforeAll
    public static void init() {
        TestJavaApplication.TestApp.initialize();
    }

    @Test
    public void constructor_nullClient_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new MeetingCard(null, 0));
    }

    @Test
    public void equals() {
        MeetingCard meetingCard = new MeetingCard(WITH_ALICE, 0);
        assertTrue(meetingCard.equals(new MeetingCard(WITH_ALICE, 0)));
        assertFalse(meetingCard.equals(new MeetingCard(WITH_ALICE, 1)));
        assertFalse(meetingCard.equals(new MeetingCard(WITH_BENSON, 0)));
    }
}
