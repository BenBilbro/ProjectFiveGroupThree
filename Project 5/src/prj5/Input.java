/**
 * 
 */
package prj5;

/**
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * 
 * @version 4.11.17
 *
 */
public class Input {

    public static void main(String[] args) {
        if (args.length == 2) {
            new FileReader(args[0], args[1]);
        }
        else {
            new FileReader("MusicSurveyDataNoGenreRepeats.csv",
                "SongListNoGenreRepeats.csv");
        }
    }
}
