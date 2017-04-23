/**
 * 
 */
package prj5;

/**
 * This class is used to compare the attributes of the songs
 * 
 * @author Sean Seth
 * @version 04.21.17
 *
 */
public class CompareSong
{

    public int compare(String str, GUIGlyph o1, GUIGlyph o2)
    {
        int compareVal = 0;
        if (str.equals("Artist"))
        {
            compareVal = compareArtist(o1, o2);
        }
        else if (str.equals("Date"))
        {
            compareVal = compareDate(o1, o2);
        }
        else if (str.equals("Genre"))
        {
            compareVal = compareGenre(o1, o2);
        }
        else if (str.equals("Title"))
        {
            compareVal = compareTitle(o1, o2);
        }

        return compareVal;

    }


    /**
     * Compares the artist of two songs from two glyph objects
     * 
     * @param o1
     *            The glyph that will compare
     * @param o2
     *            The glyph that will be compared to
     * @return a positive integer if the first glyph's song comes after, 0 if
     *         they're
     *         equal, -1 if the song comes before
     */
    private int compareArtist(GUIGlyph o1, GUIGlyph o2)
    {
        return o1.getSong().getArtist().compareToIgnoreCase(o2.getSong()
            .getArtist());
    }


    /**
     * Compares the genres of two songs from two glyph objects
     * 
     * @param o1
     *            The glyph that will be compare
     * @param o2
     *            The glyph that will be compared to
     * @return a positive integer if the first glyph's song comes after, 0 if
     *         they're
     *         equal, -1 if the song comes before
     */
    private int compareGenre(GUIGlyph o1, GUIGlyph o2)
    {

        return o1.getSong().getGenre().compareToIgnoreCase(o2.getSong()
            .getGenre());
    }


    /**
     * Compares the titles of two songs from two glyph objects
     * 
     * @param o1
     *            The glyph that will compare
     * @param o2
     *            The glyph that will be compared to
     * @return a positive integer if the first glyph's song comes after, 0 if
     *         they're
     *         equal, -1 if the song comes before
     */
    private int compareTitle(GUIGlyph o1, GUIGlyph o2)
    {
        return o1.getSong().getTitle().compareToIgnoreCase(o2.getSong()
            .getTitle());
    }


    /**
     * Compares the titles of two songs from two glyph objects
     * 
     * @param o1
     *            The glyph that will compare
     * @param o2
     *            The glyph that will be compared to
     * @return a positive integer if the first glyph's song comes after, 0 if
     *         they're
     *         equal, -1 if the song comes before
     */
    private int compareDate(GUIGlyph o1, GUIGlyph o2)
    {

        return o1.getSong().getDate().compareTo(o2.getSong().getDate());
    }
}
