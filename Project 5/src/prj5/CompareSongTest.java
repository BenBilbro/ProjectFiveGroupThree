/**
 * 
 */
package prj5;

/**
 * This class tests the comparisons made in CompareSong class
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class CompareSongTest extends student.TestCase
{
    private CompareSong comparer;
    private GUIGlyph glyph1;
    private GUIGlyph glyph2;


    /**
     * Sets up the test class
     */
    public void setUp()
    {
        comparer = new CompareSong();
        glyph1 = new GUIGlyph(new Song(1, "A", "A", "A", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
    }


    /**
     * Checks which artist comes first alphabetically
     */
    public void testCompareArtist()
    {
        Exception thrown = null;
        try
        {
            comparer.compare("", glyph1, glyph2);
        }
        catch (IllegalArgumentException e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        assertEquals(-1, comparer.compare("Artist", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "B", "A", "A", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
        assertEquals(0, comparer.compare("Artist", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "C", "A", "A", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
        assertEquals(1, comparer.compare("Artist", glyph1, glyph2));
    }


    /**
     * Checks which genre should come first alphabetically
     */
    public void testCompareGenre()
    {
        assertEquals(-1, comparer.compare("Genre", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "B", "B", "A", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
        assertEquals(0, comparer.compare("Genre", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "C", "C", "A", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
        assertEquals(1, comparer.compare("Genre", glyph1, glyph2));
    }


    /**
     * Checks which title should come first alphabetically
     */
    public void testCompareTitle()
    {
        assertEquals(-1, comparer.compare("Title", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "B", "B", "B", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
        assertEquals(0, comparer.compare("Genre", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "C", "C", "C", "1", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "B", "2", null, null));
        assertEquals(1, comparer.compare("Genre", glyph1, glyph2));
    }


    /**
     * Checks which date is older
     */
    public void testCompareDate()
    {
        assertEquals(-1, comparer.compare("Date", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "B", "B", "A", "2", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "A", "2", null, null));
        assertEquals(0, comparer.compare("Genre", glyph1, glyph2));
        glyph1 = new GUIGlyph(new Song(1, "C", "C", "A", "3", null, null));
        glyph2 = new GUIGlyph(new Song(2, "B", "B", "A", "2", null, null));
        assertEquals(1, comparer.compare("Genre", glyph1, glyph2));
    }
}
