package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalMeetings.WITH_ALICE;
import static seedu.address.testutil.TypicalMeetings.WITH_BENSON;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;

public class MeetingCardTest {

    private JFXPanel panel = new JFXPanel();

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
