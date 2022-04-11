package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.BOB;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import seedu.address.model.client.Client;

public class ClientDisplayTest {
    @Test
    public void constructor_nullClient_throwsNullPointerException() {
        JFXPanel fxPanel = new JFXPanel();
        assertThrows(AssertionError.class, () -> new ClientDisplay((Client) null));
    }

    @Test
    public void equals() {
        JFXPanel fxPanel = new JFXPanel();
        assertEquals(new ClientDisplay(ALICE), new ClientDisplay(ALICE));
        assertNotEquals(new ClientDisplay(ALICE), new ClientDisplay(BOB));
    }
}
