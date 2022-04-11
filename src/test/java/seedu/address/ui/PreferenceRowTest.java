package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPreferenceMap.getTypicalPreferenceMaps;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;

public class PreferenceRowTest {
    @Test
    public void constructor_nullClient_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new PreferenceRow(null));
    }

    @Test
    public void equals() {
        JFXPanel fxPanel = new JFXPanel();
        PreferenceRow preferenceRow = new PreferenceRow(getTypicalPreferenceMaps().get(0).asObservableList().get(0));
        assertTrue(preferenceRow.equals(new PreferenceRow(getTypicalPreferenceMaps().get(0).asObservableList()
                .get(0))));
        assertFalse(preferenceRow.equals(new PreferenceRow(getTypicalPreferenceMaps().get(0).asObservableList()
                .get(1))));
    }
}
