/**
 * 
 */
package prj5;

/**
 * This class tests all of the methods in the GlyphList
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class GlyphListTest extends student.TestCase
{

    /**
     * Tests the sorting method in the GlyphList
     */
    public void testSortGlyph()
    {
        GlyphList list = new GlyphList();
        list.add(new GUIGlyph(new Song(2, "B", "A", "B", "1", null, null)));
        list.add(new GUIGlyph(new Song(1, "A", "B", "A", "2", null, null)));

        list.sortGlyph("artist");
        Object[] arr = list.toArray();
        GUIGlyph glyph1 = (GUIGlyph)arr[0];
        GUIGlyph glyph2 = (GUIGlyph)arr[1];
        assertEquals("A", glyph1.getSong().getArtist());
        assertEquals("B", glyph2.getSong().getArtist());

        list.sortGlyph("genre");
        arr = list.toArray();
        glyph1 = (GUIGlyph)arr[0];
        glyph2 = (GUIGlyph)arr[1];
        assertEquals("A", glyph1.getSong().getGenre());
        assertEquals("B", glyph2.getSong().getGenre());

        list.sortGlyph("title");
        arr = list.toArray();
        glyph1 = (GUIGlyph)arr[0];
        glyph2 = (GUIGlyph)arr[1];
        assertEquals("A", glyph1.getSong().getTitle());
        assertEquals("B", glyph2.getSong().getTitle());

        list.sortGlyph("date");
        arr = list.toArray();
        glyph1 = (GUIGlyph)arr[0];
        glyph2 = (GUIGlyph)arr[1];
        assertEquals("1", glyph1.getSong().getDate());
        assertEquals("2", glyph2.getSong().getDate());

    }

}
