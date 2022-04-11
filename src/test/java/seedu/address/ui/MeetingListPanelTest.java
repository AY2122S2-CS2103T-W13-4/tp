package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalMeetings.WITH_ALICE;
import static seedu.address.testutil.TypicalMeetings.WITH_BENSON;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import seedu.address.model.meeting.Meeting;

public class MeetingListPanelTest {

    private JFXPanel panel = new JFXPanel();

    @Test
    public void constructor_nullClients_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new MeetingListPanel(null, true));
    }

    @Test
    public void equals() {
        List<Meeting> listWithBenson = new ArrayList<>();
        listWithBenson.add(WITH_ALICE);
        listWithBenson.add(WITH_BENSON);
        List<Meeting> listWithoutBenson = new ArrayList<>();
        listWithoutBenson.add(WITH_ALICE);
        assertNotEquals(new MeetingListPanel(FXCollections.observableList(listWithBenson), false),
                new MeetingListPanel(FXCollections.observableList(listWithoutBenson), false));
        assertNotEquals(new MeetingListPanel(FXCollections.observableList(listWithoutBenson), true),
                new MeetingListPanel(FXCollections.observableList(listWithoutBenson), false));
    }
}
