/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * This class contains the implementation for all of the shapes associated to
 * creating a visual representation of each song's data according to a specific
 * attribute (major, region, hobby)
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class GUIGlyph
{

    private static final int BAR_WIDTH = 100;
    private Song song;

    private Shape purpleLBar;
    private Shape blueLBar;
    private Shape orangeLBar;
    private Shape greenLBar;
    private Shape purpleRBar;
    private Shape blueRBar;
    private Shape orangeRBar;
    private Shape greenRBar;
    private Shape blackBar;

    private TextShape title;
    private TextShape artist;


    /**
     * Creates a default glyph object (temporary for submission)
     */
    public GUIGlyph()
    {
        // default Glyph
    }


    /**
     * Creates a new Glyph object with a song passed to its
     * 
     * @param song
     *            the song associated to the data that will be displayed
     * 
     */
    public GUIGlyph(Song song)
    {
        this.song = song;
    }

    /**
     * Returns the song associated to this glyph
     * 
     * @return the song with the glyph
     */
    public Song getSong()
    {
        return song;
    }


    /**
     * Creates a default glyph with constant bar values
     * 
     * @return an array of shapes that will be used in the ProjectWindow to
     *         place all of the shapes together to create a visualized glyph
     */
    public Shape[] defaultGlyph()
    {
        purpleLBar = new Shape(0, 0, BAR_WIDTH, 10, Color.MAGENTA);
        blueLBar = new Shape(0, 0, BAR_WIDTH, 10, Color.BLUE);
        orangeLBar = new Shape(0, 0, BAR_WIDTH, 10, Color.ORANGE);
        greenLBar = new Shape(0, 0, BAR_WIDTH, 10, Color.GREEN);
        purpleRBar = new Shape(0, 0, BAR_WIDTH, 10, Color.MAGENTA);
        blueRBar = new Shape(0, 0, BAR_WIDTH, 10, Color.BLUE);
        orangeRBar = new Shape(0, 0, BAR_WIDTH, 10, Color.ORANGE);
        greenRBar = new Shape(0, 0, BAR_WIDTH, 10, Color.GREEN);
        blackBar = new Shape(0, 0, 10, 40, Color.BLACK);
        title = new TextShape(0, 0, "Song Title");
        artist = new TextShape(0, 0, "By: Artist Name");

        Shape[] defaultShapes = new Shape[11];
        defaultShapes[0] = purpleLBar;
        defaultShapes[1] = blueLBar;
        defaultShapes[2] = orangeLBar;
        defaultShapes[3] = greenLBar;
        defaultShapes[4] = purpleRBar;
        defaultShapes[5] = blueRBar;
        defaultShapes[6] = orangeRBar;
        defaultShapes[7] = greenRBar;
        defaultShapes[8] = blackBar;
        defaultShapes[9] = title;
        defaultShapes[10] = artist;

        return defaultShapes;
    }

}
