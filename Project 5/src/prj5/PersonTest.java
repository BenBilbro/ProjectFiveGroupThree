package prj5;

/**
 * Tests all of the methods in Person
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class PersonTest extends student.TestCase
{
    private Person p1;
    private String[] arr;


    /**
     * sets up the instance data
     */
    public void setUp()
    {
        arr = new String[4];
        arr[0] = "hi,yes";
        arr[1] = " , ";
        arr[2] = "yes, ";
        arr[3] = " ,no";

        p1 = new Person(MajorEnum.MATH_CMDA, RegionEnum.NORTHEAST,
            HobbyEnum.READING, arr);
    }


    /**
     * tests to make sure that the getMajor method correctly returns the right
     * major
     */
    public void testGetMajor()
    {
        assertEquals(MajorEnum.MATH_CMDA, p1.getMajor());
    }


    /**
     * tests to make sure that the getRegion method correctly returns the right
     * region
     */
    public void testGetRegion()
    {
        assertEquals(RegionEnum.NORTHEAST, p1.getRegion());
    }


    /**
     * tests to make sure that getHobby works as expected and returns the
     * correct hobby
     */
    public void testGetHobby()
    {
        assertEquals(HobbyEnum.READING, p1.getHobby());
    }


    /**
     * tests to make sure that getResponses returns the correct responses
     */
    public void testGetResponses()
    {
        assertEquals(arr, p1.getResponses());
    }


    /**
     * tests to make sure that getHeard returns the correct information; i.e.
     * everything before the comma in arr for the requested index
     */
    public void testGetHeard()
    {
        assertEquals("hi", p1.getHeard(0));
        assertEquals("", p1.getHeard(10));
    }


    /**
     * tests to make sure that getLiked returns the correct information; i.e.
     * everything after the comma in arr for the requested index
     */
    public void testGetLiked()
    {
        assertEquals(" ", p1.getLiked(2));
        assertEquals("", p1.getLiked(10));
    }

}
