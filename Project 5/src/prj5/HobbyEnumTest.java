package prj5;

/**
 * class that tests the different HobbyEnums
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class HobbyEnumTest extends student.TestCase
{
    /**
     * tests to make sure that all the correct HobbyEnums are returned from a
     * call to getHobby()
     */
    public void testGetHobby()
    {
        assertEquals(HobbyEnum.READING, HobbyEnum.getHobby("reading"));
        assertEquals(HobbyEnum.SPORTS, HobbyEnum.getHobby("sports"));
        assertEquals(HobbyEnum.MUSIC, HobbyEnum.getHobby("music"));
        assertEquals(HobbyEnum.ART, HobbyEnum.getHobby("art"));
        assertNull(HobbyEnum.getHobby("yolo"));
    }
}
