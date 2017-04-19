/**
 * 
 */
package prj5;

/**
 * Tests all of the methods in the project window
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class ProjectWindowTest extends student.TestCase
{

    /**
     * sets up the instance data
     */
    public void setUp()
    {
        ProjectWindow window = new ProjectWindow(new LinkedList<Glyph>());
        window.sortGlyphGenre(new LinkedList<Glyph>());
        window.sortGlyphTitle(new LinkedList<Glyph>());
        window.sortHobby(new LinkedList<Glyph>());
        window.sortMajor(new LinkedList<Glyph>());
        window.sortRegion(new LinkedList<Glyph>());
    }
}
