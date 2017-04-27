/**
 * 
 */
package prj5;

/**
 * Tests to see if the DataProcessor correctly parses and loads data
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.26.17
 */
public class DataProcessorTest extends student.TestCase {
    private DataProcessor dp;


    /**
     * Sets up the test class
     */
    public void setUp() {
        dp = new DataProcessor("MusicSurveyData.csv", "SongList.csv");
        dp = new DataProcessor("MusicSurveyDataTest1.csv", "SongListTest1.csv");
        dp = new DataProcessor("MusicSurveyDataTest2.csv", "SongListTest2.csv");
        dp = new DataProcessor("MusicSurveyDataTest2_NULL.csv",
            "SongListTest2.csv");

        dp = new DataProcessor("MusicSurveyDataNoGenreRepeats.csv",
            "SongListNoGenreRepeats.csv");

    }


    /**
     * Tests if the correct number of songs are received
     */
    public void testNumSongs() {
        assertEquals(17, DataProcessor.numSongs);
    }


    /**
     * Tests if the correct number of people were added
     */
    public void testGetPersonList() {
        assertEquals(205, dp.getPersonList().getLength());
    }


    /**
     * Tests if the number of glyphs are correct
     */
    public void testGetGlyphList() {
        assertEquals(17, dp.getGlyphList().getLength());
    }

}
