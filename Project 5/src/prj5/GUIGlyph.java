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
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class GUIGlyph {

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
    private TextShape variableText;


    /**
     * Creates a new Glyph object with a song passed to its
     * 
     * @param song
     *            the song associated to the data that will be displayed
     * 
     */
    public GUIGlyph(Song song) {
        this.song = song;
    }


    /**
     * Returns the song associated to this glyph
     * 
     * @return the song with the glyph
     */
    public Song getSong() {
        return song;
    }


    /**
     * Returns the shapes associated to the current glyph's calculated data for
     * every person in a certain major
     * 
     * @param str
     *            The correct subtitle for the specified sort
     * @return An array of all of the needed shapes for the glyph
     */
    public Shape[] getMajorShapes(String str) {
        // creates a 2D array layed out as follows :

        // HEARD ROW [Major 1] [Major 2] [Major 3] [Major 4]
        //
        // LIKED ROW [Major 1] [Major 2] [Major 3] [Major 4]
        //
        // each value is the total number of people who have heard or liked this
        // song categorized by major

        int[][] majorArr = song.sortByMajor();
        int cmdaMathH = majorArr[0][0];
        int compSciH = majorArr[0][1];
        int otherEngeH = majorArr[0][2];
        int otherH = majorArr[0][3];
        int cmdaMathL = majorArr[1][0];
        int compSciL = majorArr[1][1];
        int otherEngeL = majorArr[1][2];
        int otherL = majorArr[1][3];

        // creates the shapes at the corresponding length to the data
        purpleLBar = new Shape(0, 0, cmdaMathH * BAR_WIDTH / 100, 10,
            Color.MAGENTA);
        blueLBar = new Shape(0, 0, compSciH * BAR_WIDTH / 100, 10, Color.BLUE);
        orangeLBar = new Shape(0, 0, otherEngeH * BAR_WIDTH / 100, 10,
            Color.ORANGE);
        greenLBar = new Shape(0, 0, otherH * BAR_WIDTH / 100, 10, Color.GREEN);
        purpleRBar = new Shape(0, 0, cmdaMathL * BAR_WIDTH / 100, 10,
            Color.MAGENTA);
        blueRBar = new Shape(0, 0, compSciL * BAR_WIDTH / 100, 10, Color.BLUE);
        orangeRBar = new Shape(0, 0, otherEngeL * BAR_WIDTH / 100, 10,
            Color.ORANGE);
        greenRBar = new Shape(0, 0, otherL * BAR_WIDTH / 100, 10, Color.GREEN);
        blackBar = new Shape(0, 0, 5, 40, Color.BLACK);
        title = new TextShape(0, 0, song.getTitle());
        // displays the correct sort of the glyphs depending on the str passed
        if (str != null) {
            if (str.equals("Date")) {
                variableText = new TextShape(0, 0, "year: " + song.getDate());
            }
            else if (str.equals("Genre")) {
                variableText = new TextShape(0, 0, "genre: " + song.getGenre());
            }
            else {
                variableText = new TextShape(0, 0, "By: " + song.getArtist());
            }
        }
        else {
            variableText = new TextShape(0, 0, "By: " + song.getArtist());
        }
        // populates the Shape[] to return to the window
        Shape[] majorShapes = new Shape[11];
        majorShapes[0] = purpleLBar;
        majorShapes[1] = blueLBar;
        majorShapes[2] = orangeLBar;
        majorShapes[3] = greenLBar;
        majorShapes[4] = purpleRBar;
        majorShapes[5] = blueRBar;
        majorShapes[6] = orangeRBar;
        majorShapes[7] = greenRBar;
        majorShapes[8] = blackBar;
        majorShapes[9] = title;
        majorShapes[10] = variableText;

        return majorShapes;
    }


    /**
     * Returns the shapes associated to the current glyph's calculated data for
     * every person in a certain region
     * 
     * @param str
     *            The correct subtitle for the specified sort
     * @return An array of all of the needed shapes for the glyph
     */
    public Shape[] getRegionShapes(String str) {
        // creates a 2D array layed out as follows :

        // HEARD ROW [Region 1] [Region 2] [Region 3] [Region 4]
        //
        // LIKED ROW [Region 1] [Region 2] [Region 3] [Region 4]
        //
        // each value is the total number of people who have heard or liked this
        // song categorized by region

        int[][] regionArr = song.sortByRegion();

        int northH = regionArr[0][0];
        int southH = regionArr[0][1];
        int otherH = regionArr[0][2];
        int outH = regionArr[0][3];
        int northL = regionArr[1][0];
        int southL = regionArr[1][1];
        int otherL = regionArr[1][2];
        int outL = regionArr[1][3];

        // creates the shapes at the corresponding length to the data
        purpleLBar = new Shape(0, 0, northH * BAR_WIDTH / 100, 10,
            Color.MAGENTA);
        blueLBar = new Shape(0, 0, southH * BAR_WIDTH / 100, 10, Color.BLUE);
        orangeLBar = new Shape(0, 0, otherH * BAR_WIDTH / 100, 10,
            Color.ORANGE);
        greenLBar = new Shape(0, 0, outH * BAR_WIDTH / 100, 10, Color.GREEN);
        purpleRBar = new Shape(0, 0, northL * BAR_WIDTH / 100, 10,
            Color.MAGENTA);
        blueRBar = new Shape(0, 0, southL * BAR_WIDTH / 100, 10, Color.BLUE);
        orangeRBar = new Shape(0, 0, otherL * BAR_WIDTH / 100, 10,
            Color.ORANGE);
        greenRBar = new Shape(0, 0, outL * BAR_WIDTH / 100, 10, Color.GREEN);
        blackBar = new Shape(0, 0, 5, 40, Color.BLACK);
        title = new TextShape(0, 0, song.getTitle());

        // displays the correct glyph sort depending on the str passed in
        if (str != null) {
            if (str.equals("Date")) {
                variableText = new TextShape(0, 0, "year: " + song.getDate());
            }
            else if (str.equals("Genre")) {
                variableText = new TextShape(0, 0, "genre: " + song.getGenre());
            }
            else {
                variableText = new TextShape(0, 0, "By: " + song.getArtist());
            }
        }
        else {
            variableText = new TextShape(0, 0, "By: " + song.getArtist());
        }

        // populates the Shape[] array with the correct shapes to be returned
        Shape[] regionShapes = new Shape[11];
        regionShapes[0] = purpleLBar;
        regionShapes[1] = blueLBar;
        regionShapes[2] = orangeLBar;
        regionShapes[3] = greenLBar;
        regionShapes[4] = purpleRBar;
        regionShapes[5] = blueRBar;
        regionShapes[6] = orangeRBar;
        regionShapes[7] = greenRBar;
        regionShapes[8] = blackBar;
        regionShapes[9] = title;
        regionShapes[10] = variableText;

        return regionShapes;
    }


    /**
     * Returns the shapes associated to the current glyph's calculated data for
     * every person in a certain hobby
     * 
     * @param str
     *            The correct subtitle for the specified sort
     * @return An array of all of the needed shapes for the glyph
     */
    public Shape[] getHobbyShapes(String str) {

        // creates a 2D array layed out as follows :

        // HEARD ROW [Hobby 1] [Hobby 2] [Hobby 3] [Hobby 4]
        //
        // LIKED ROW [Hobby 1] [Hobby 2] [Hobby 3] [Hobby 4]
        //
        // each value is the total number of people who have heard or liked this
        // song categorized by hobby
        int[][] hobbyArr = song.sortByHobby();

        int readH = hobbyArr[0][0];
        int artH = hobbyArr[0][1];
        int musicH = hobbyArr[0][2];
        int sportH = hobbyArr[0][3];
        int readL = hobbyArr[1][0];
        int artL = hobbyArr[1][1];
        int musicL = hobbyArr[1][2];
        int sportL = hobbyArr[1][3];

        // creates the shapes at the corresponding length to the data
        purpleLBar = new Shape(0, 0, readH * BAR_WIDTH / 100, 10,
            Color.MAGENTA);
        blueLBar = new Shape(0, 0, artH * BAR_WIDTH / 100, 10, Color.BLUE);
        orangeLBar = new Shape(0, 0, musicH * BAR_WIDTH / 100, 10,
            Color.ORANGE);
        greenLBar = new Shape(0, 0, sportH * BAR_WIDTH / 100, 10, Color.GREEN);
        purpleRBar = new Shape(0, 0, readL * BAR_WIDTH / 100, 10,
            Color.MAGENTA);
        blueRBar = new Shape(0, 0, artL * BAR_WIDTH / 100, 10, Color.BLUE);
        orangeRBar = new Shape(0, 0, musicL * BAR_WIDTH / 100, 10,
            Color.ORANGE);
        greenRBar = new Shape(0, 0, sportL * BAR_WIDTH / 100, 10, Color.GREEN);
        blackBar = new Shape(0, 0, 5, 40, Color.BLACK);
        title = new TextShape(0, 0, song.getTitle());

        // displays the correct glyph sort depending on the str passed in
        if (str != null) {
            if (str.equals("Date")) {
                variableText = new TextShape(0, 0, "year: " + song.getDate());
            }
            else if (str.equals("Genre")) {
                variableText = new TextShape(0, 0, "genre: " + song.getGenre());
            }
            else {
                variableText = new TextShape(0, 0, "By: " + song.getArtist());
            }
        }
        else {
            variableText = new TextShape(0, 0, "By: " + song.getArtist());
        }

        // populates the Shape[] array with the correct shapes to be returned
        Shape[] hobbyShapes = new Shape[11];
        hobbyShapes[0] = purpleLBar;
        hobbyShapes[1] = blueLBar;
        hobbyShapes[2] = orangeLBar;
        hobbyShapes[3] = greenLBar;
        hobbyShapes[4] = purpleRBar;
        hobbyShapes[5] = blueRBar;
        hobbyShapes[6] = orangeRBar;
        hobbyShapes[7] = greenRBar;
        hobbyShapes[8] = blackBar;
        hobbyShapes[9] = title;
        hobbyShapes[10] = variableText;

        return hobbyShapes;
    }

}
