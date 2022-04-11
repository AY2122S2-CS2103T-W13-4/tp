package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.BOB;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import seedu.address.model.client.Client;

public class ClientCardTest {

    @BeforeAll
    public static void init() {
        TestJavaApplication.TestApp.initialize();
    }

    @Test
    public void constructor_nullClient_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new ClientCard((Client) null, 0));
    }

    @Test
    public void equals() {
        ClientCard clientCard = new ClientCard(ALICE, 0);
        assertTrue(clientCard.equals(new ClientCard(ALICE, 0)));
        assertFalse(clientCard.equals(new ClientCard(ALICE, 1)));
        assertFalse(clientCard.equals(new ClientCard(BOB, 0)));
        assertFalse(new ClientCard(BOB, 0).equals(new ClientCard(BOB, 1)));
    }
}
