/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public class Glyph {

    private Song song;


    public Glyph(Song song) {
        this.song = song;
        int[][] test = song.sortByHobby();
        System.out.println(song.heardList.length);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println();
        }
    }

}
