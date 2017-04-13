/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public class ProjectWindow {

    private LinkedList<Glyph> gList;


    public ProjectWindow(LinkedList<Glyph> gList) {
        this.gList = gList;
        System.out.println(gList.length);
    }
}
