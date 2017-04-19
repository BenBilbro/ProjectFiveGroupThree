/**
 * 
 */
package prj5;

/**
 * Tests all of the methods in the song class
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class SongTest extends student.TestCase
{
    private Song song;
    private LinkedList<Person> heardList;
    private LinkedList<Person> likedList;
    private String[] arr1 = new String[1];
    private String[] arr2 = new String[1];
    private String[] arr3 = new String[1];
    private String[] arr4 = new String[1];
    private Person p1;
    private Person p2;
    private Person p3;
    private Person p4;
    private Person p5;
    private Person p6;
    private Person p7;
    private Person p8;


    /**
     * instantiates the instance data
     */
    public void setUp()
    {
        arr1[0] = "Yes,Yes";

        arr2[0] = "Yes,Yes";

        arr3[0] = "Yes,Yes";

        arr4[0] = "Yes,Yes";

        heardList = new LinkedList<Person>();
        likedList = new LinkedList<Person>();

        p1 = new Person(1, MajorEnum.MATH_CMDA, RegionEnum.NORTHEAST,
            HobbyEnum.ART, arr1);

        p2 = new Person(2, MajorEnum.COMP_SCI, RegionEnum.SOUTHEAST,
            HobbyEnum.MUSIC, arr2);

        p3 = new Person(3, MajorEnum.OTHER_ENGE, RegionEnum.OTHER_US,
            HobbyEnum.READING, arr3);

        p4 = new Person(4, MajorEnum.OTHER, RegionEnum.OUTSIDE_US,
            HobbyEnum.SPORTS, arr4);

        p5 = new Person(1, MajorEnum.MATH_CMDA, RegionEnum.NORTHEAST,
            HobbyEnum.ART, arr1);
        p6 = new Person(2, MajorEnum.COMP_SCI, RegionEnum.SOUTHEAST,
            HobbyEnum.MUSIC, arr2);

        p7 = new Person(3, MajorEnum.OTHER_ENGE, RegionEnum.OTHER_US,
            HobbyEnum.READING, arr3);

        p8 = new Person(4, MajorEnum.OTHER, RegionEnum.OUTSIDE_US,
            HobbyEnum.SPORTS, arr4);

        heardList.add(p1);

        heardList.add(p2);

        heardList.add(p3);

        heardList.add(p4);

        likedList.add(p5);

        likedList.add(p6);

        likedList.add(p7);

        likedList.add(p8);

        LinkedList<Person> pList = new LinkedList<Person>();

        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        pList.add(p5);
        pList.add(p6);
        pList.add(p7);
        pList.add(p8);

        new PersonList(pList);

        song = new Song(0, "Maroon 5", "HipHop", "Maps", "10/01/2017",
            heardList, likedList);
    }


    /**
     * tests to make sure getArtist gets the correct artist
     */
    public void testGetArtist()
    {
        assertEquals("Maroon 5", song.getArtist());
    }


    /**
     * tests to make sure that getTitle gets the correct title of the song
     */
    public void testGetTitle()
    {
        assertEquals("Maps", song.getTitle());
    }


    /**
     * tests to make sure that getGenre returns the right genre
     */
    public void testGetGenre()
    {
        assertEquals("HipHop", song.getGenre());
    }


    /**
     * tests to make sure that the correct date is returned
     */
    public void testGetDate()
    {
        assertEquals("10/01/2017", song.getDate());
    }


    /**
     * tests to make sure that the correct list is returned
     */
    public void testGetHeardList()
    {
        assertEquals(heardList, song.getHeardList());
    }


    /**
     * tests to make sure that the correct list is returned
     */
    public void testGetLikedList()
    {
        assertEquals(likedList, song.getLikedList());
    }


    /**
     * tests to make sure that the toString outputs the correct information
     * it should be title by artist, genre; date
     */
    public void testToString()
    {
        assertEquals("Maps by Maroon 5, HipHop; 10/01/2017", song.toString());
    }


    /**
     * tests to make sure that the sortByRegion method works as expected
     */
    public void testSortByRegion()
    {
        int[][] arr = song.sortByRegion();
        assertEquals(arr[0][0], 50);
    }


    /**
     * tests to make sure that the sortByMajor method works as expected
     */
    public void testSortByMajor()
    {
        arr1[0] = "Yes,Yes";

        arr2[0] = "Yes,Yes";

        arr3[0] = "Yes,Yes";

        arr4[0] = "Yes,Yes";
        int[][] arr = song.sortByMajor();
        assertEquals(arr[0][0], 50);
    }


    /**
     * tests to make sure that the sortByHobby method works as expected
     */
    public void testSortByHobby()
    {
        arr1[0] = "Yes,Yes";

        arr2[0] = "Yes,Yes";

        arr3[0] = "Yes,Yes";

        arr4[0] = "Yes,Yes";
        int[][] arr = song.sortByHobby();
        assertEquals(arr[0][0], 50);
    }

}
