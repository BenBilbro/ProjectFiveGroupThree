/**
 * 
 */
package prj5;

/**
 * This class initializes a new File Reader object with user defined files for
 * the music survey data and song list
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * 
 * @version 04.19.17
 *
 */
public class Input
{
    /**
     * Initializes a new File Reader to parse the given input data
     * 
     * @param args
     *            the string that will hold the file name for the data
     */
    public static void main(String[] args)
    {
        if (args.length == 2)
        {
            new FileReader(args[0], args[1]);
        }
        else
        {
            new FileReader("MusicSurveyDataNoGenreRepeats.csv",
                "SongListNoGenreRepeats.csv");
        }
    }
}
