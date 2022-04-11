package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPreferenceMap.getTypicalPreferenceMaps;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PreferenceRowTest {

    @BeforeAll
    public static void init() {
        TestJavaApplication.TestApp.initialize();
    }

    @Test
    public void constructor_nullClient_throwsNullPointerException() {
        assertThrows(AssertionError.class, () -> new PreferenceRow(null));
    }

    @Test
    public void equals() {
        PreferenceRow preferenceRow = new PreferenceRow(getTypicalPreferenceMaps().get(0).asObservableList().get(0));
        assertTrue(preferenceRow.equals(new PreferenceRow(getTypicalPreferenceMaps().get(0).asObservableList()
                .get(0))));
        assertFalse(preferenceRow.equals(new PreferenceRow(getTypicalPreferenceMaps().get(0).asObservableList()
                .get(1))));
    }
}
