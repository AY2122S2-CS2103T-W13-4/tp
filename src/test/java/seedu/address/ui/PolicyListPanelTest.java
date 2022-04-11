package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPolicies.INSURANCE;
import static seedu.address.testutil.TypicalPolicies.INVESTMENT;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import seedu.address.model.policy.Policy;

public class PolicyListPanelTest {

    private JFXPanel panel = new JFXPanel();

    @Test
    public void constructor_nullClients_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new PolicyListPanel(null));
    }

    @Test
    public void equals() {
        List<Policy> list1 = new ArrayList<>();
        list1.add(INSURANCE);
        list1.add(INVESTMENT);
        List<Policy> list2 = new ArrayList<>();
        list2.add(INSURANCE);
        assertNotEquals(new PolicyListPanel(FXCollections.observableList(list1)),
                new PolicyListPanel(FXCollections.observableList(list2)));
    }
}
