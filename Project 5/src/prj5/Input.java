/**
 * 
 */
package prj5;

/**
 * @author Ben Bilbro
 * 
 * @version 4.11.17
 *
 */
public class Input {

    public static void main(String[] args) {
        if (args.length == 2) {
            FileReader fr = new FileReader(args[0], args[1]);
        }
        else {
            FileReader fr = new FileReader("MusicSurveyDataNoGenreRepeats.csv",
                "SongListNoGenreRepeats.csv");
        }
    }
}
