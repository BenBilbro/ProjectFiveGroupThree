/**
 * 
 */
package prj5;

/**
 * This class initializes a new File Reader object with user defined files for
 * the music survey data and song list
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * 
 * @version 04.19.17
 *
 */
public class Input {
    /**
     * Initializes a new File Reader to parse the given input data
     * 
     * @param args
     *            the string that will hold the file name for the data
     */
    public static void main(String[] args) {
        // uses command line arguments
        if (args.length == 2) {
            new DataProcessor(args[0], args[1]);
        }
        // default files ran
        else {
            new DataProcessor("MusicSurveyData2017S.csv", "SongList2017S.csv");
        }
    }
}
