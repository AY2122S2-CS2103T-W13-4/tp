package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPolicies.INSURANCE;
import static seedu.address.testutil.TypicalPolicies.INVESTMENT;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import seedu.address.model.policy.Policy;

public class PolicyCardTest {
    @Test
    public void constructor_nullClient_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new PolicyCard((Policy) null, 0));
    }

    @Test
    public void equals() {
        JFXPanel fxPanel = new JFXPanel();
        PolicyCard policyCard = new PolicyCard(INSURANCE, 0);
        assertTrue(policyCard.equals(new PolicyCard(INSURANCE, 0)));
        assertFalse(policyCard.equals(new PolicyCard(INSURANCE, 1)));
        assertFalse(policyCard.equals(new PolicyCard(INVESTMENT, 0)));
    }
}
