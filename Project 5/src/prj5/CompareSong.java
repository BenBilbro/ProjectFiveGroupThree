/**
 * 
 */
package prj5;

/**
 * This class is used to compare the attributes of the songs
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class CompareSong {

    /**
     * This method compares two glyphs based on the specified attribute
     * 
     * @param str
     *            The attribute that is to be compared
     * @param o1
     *            The glyph that will compare
     * @param o2
     *            The glyph that will be compared
     * @return the respective location of the attribute based on alphabetical
     *         /ascending numeric sorting
     */
    public int compare(String str, GUIGlyph o1, GUIGlyph o2) {
        // str determines the type of comparison between songs
        int compareVal = 0;
        if (str.equalsIgnoreCase("Artist")) {
            compareVal = compareArtist(o1, o2);
        }
        else if (str.equalsIgnoreCase("Date")) {
            compareVal = compareDate(o1, o2);
        }
        else if (str.equalsIgnoreCase("Genre")) {
            compareVal = compareGenre(o1, o2);
        }
        else if (str.equalsIgnoreCase("Title")) {
            compareVal = compareTitle(o1, o2);
        }
        else {
            throw new IllegalArgumentException();
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
    private int compareArtist(GUIGlyph o1, GUIGlyph o2) {
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
    private int compareGenre(GUIGlyph o1, GUIGlyph o2) {

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
    private int compareTitle(GUIGlyph o1, GUIGlyph o2) {
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
    private int compareDate(GUIGlyph o1, GUIGlyph o2) {

        return o1.getSong().getDate().compareTo(o2.getSong().getDate());
    }
}
