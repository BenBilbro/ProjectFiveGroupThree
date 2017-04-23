/**
 * 
 */
package prj5;

/**
 * @author seans
 *
 */
public class GlyphList extends LinkedList<GUIGlyph>
{

    public GlyphList()
    {
        super();
    }


    /**
     * Sorts the GUIGlyphs by the specified type of sort
     * 
     * @param type
     *            The type of sort
     */
    public void sortGlyph(String type)
    {
        CompareSong comparer = new CompareSong();
        Object[] arr = toArray();
        int i, j, first;
        GUIGlyph temp;
        for (i = arr.length - 1; i > 0; i--)
        {
            first = 0; // initialize to subscript of first element
            for (j = 1; j <= i; j++) // locate smallest element between
                                     // positions 1 and i.
            {
                if (comparer.compare(type, (GUIGlyph)arr[j],
                    (GUIGlyph)arr[first]) < 0)
                    first = j;
            }
            temp = ((GUIGlyph)arr[first]); // swap smallest found with element
                                           // in
                                           // position
            // i.
            arr[first] = arr[i];
            arr[i] = temp;
        }
        clear();
        for (int z = arr.length - 1; z >= 0; z--)
        {
            add(((GUIGlyph)arr[z]));
        }

    }
}
