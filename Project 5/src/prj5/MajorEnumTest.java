package prj5;

/**
 * class that tests getMajor
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class MajorEnumTest extends student.TestCase {
    /**
     * test class to make sure that all the correct enums are returned as
     * requested in the call to the getMajor method
     */
    public void testGetMajor() {
        assertEquals(MajorEnum.MATH_CMDA, MajorEnum.getMajor("Math or CMDA"));
        assertEquals(MajorEnum.COMP_SCI, MajorEnum.getMajor(
            "Computer Science"));
        assertEquals(MajorEnum.OTHER_ENGE, MajorEnum.getMajor(
            "Other Engineering"));
        assertEquals(MajorEnum.OTHER, MajorEnum.getMajor("Other"));
        assertNull(MajorEnum.getMajor("yolo"));
    }
}
