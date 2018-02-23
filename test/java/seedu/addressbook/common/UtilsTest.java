package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void isAnyNull_nullList_returnTrue() throws Exception {

        // list of null objects
        assertAnyNull(null, null, null);

        // contains a null object
        assertAnyNull(null, 12, 2);
        assertAnyNull("ABC", "cd", null);
        assertAnyNull(0, (Object) null, ",");

    }

    @Test
    public void isAnyNull_objectList_returnFalse() throws Exception {

        //an empty object
        assertNotAnyNull();

        //only one object
        assertNotAnyNull("tree");
        assertNotAnyNull("");

        //a list of concrete objects
        assertNotAnyNull("A", 12, 2);

    }


    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertAnyNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNotAnyNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
}
