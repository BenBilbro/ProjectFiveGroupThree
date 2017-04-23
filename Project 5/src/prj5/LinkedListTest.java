package prj5;

import java.util.Iterator;

/**
 * Class that tests the linked list
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class LinkedListTest extends student.TestCase {
    private LinkedList<String> list;


    /**
     * instantiates the instance data
     */
    public void setUp() {
        list = new LinkedList<String>();
    }


    /**
     * tests to make sure that getLength returns the correct length when called
     */
    public void testGetLength() {
        assertEquals(0, list.getLength());
        list.add("hi");
        assertEquals(1, list.getLength());
    }


    /**
     * makes sure that isEmpty works as expected when called
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("hi");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * tests to make sure that add works as expected
     */
    public void testAdd() {
        list.add("hello");
        Iterator<String> iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals("hello", iter.next());
        assertEquals(1, list.getLength());
        assertFalse(iter.hasNext());
        String str = null;
        list.add(str);
        assertEquals(1, list.getLength());

    }


    /**
     * tests to make sure that clear works as expected
     */
    public void testClear() {
        list.add("hi");
        assertEquals(1, list.getLength());
        list.clear();
        assertEquals(0, list.getLength());
    }


    /**
     * tests to make sure that toArray correctly puts the list in array form
     */
    public void testToArray() {
        list.add("yes");
        assertEquals("yes", list.toArray()[0]);
    }
}
