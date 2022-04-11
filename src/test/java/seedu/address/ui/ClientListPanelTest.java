package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.BOB;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import seedu.address.model.client.Client;
import seedu.address.model.client.SortCriteria;

public class ClientListPanelTest {

    @BeforeAll
    public static void init() {
        TestJavaApplication.TestApp.initialize();
    }

    @Test
    public void constructor_nullClients_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new ClientListPanel(null));
    }

    @Test
    public void equals() {
        List<Client> listWithBob = new ArrayList<>();
        listWithBob.add(ALICE);
        listWithBob.add(BOB);
        List<Client> listWithoutBob = new ArrayList<>();
        listWithoutBob.add(ALICE);
        assertNotEquals(new ClientListPanel(FXCollections.observableList(listWithBob)),
                new ClientListPanel(FXCollections.observableList(listWithoutBob)));
    }

    @Test
    public void setClientCount() {
        JFXPanel fxPanel = new JFXPanel();
        List<Client> clients = new ArrayList<>();
        clients.add(ALICE);
        ClientListPanel panel1 = new ClientListPanel(FXCollections.observableList(clients));
        clients.add(BOB);
        panel1.setClientCount();
        List<Client> listWithBob = new ArrayList<>();
        listWithBob.add(ALICE);
        listWithBob.add(BOB);
        ClientListPanel panel2 = new ClientListPanel(FXCollections.observableList(listWithBob));
        assertEquals(panel1, panel2);
    }

    @Test
    public void setSortCriteria() {
        JFXPanel fxPanel = new JFXPanel();
        List<Client> clients = new ArrayList<>();
        clients.add(ALICE);
        ClientListPanel panel1 = new ClientListPanel(FXCollections.observableList(clients));
        ClientListPanel panel2 = new ClientListPanel(FXCollections.observableList(clients));
        assertEquals(panel1, panel2);
        panel1.setSortCriteria(SortCriteria.lastContacted);
        assertNotEquals(panel1, panel2);
    }
}
