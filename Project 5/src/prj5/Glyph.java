/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 *
 */
public class Glyph {

    private static final int BAR_WIDTH = 100;

    private Song song;

    // actual glyph shapes
    private Shape purpleLBar;
    private Shape blueLBar;
    private Shape yellowLBar;
    private Shape greenLBar;
    private Shape purpleRBar;
    private Shape blueRBar;
    private Shape yellowRBar;
    private Shape greenRBar;
    private Shape blackBar;

    private TextShape title;
    // this textShape will change as sorted
    private TextShape variantText;


    public Glyph(Song song) {
        this.song = song;
    }


    public int[][] sortByHobby() {
        return song.getResults(HobbyEnum.class);
    }


    public int[][] sortByRegion() {
        return song.getResults(RegionEnum.class);
    }


    public int[][] sortByMajor() {
        return song.getResults(MajorEnum.class);
    }


    public Song getSong() {
        return song;
    }


    public Shape[] getMajorShapes() {
        int[][] majorArr = sortByMajor();
        int cmdaMathH = majorArr[0][0];
        int compSciH = majorArr[0][1];
        int otherEngeH = majorArr[0][2];
        int otherH = majorArr[0][3];
        int cmdaMathL = majorArr[1][0];
        int compSciL = majorArr[1][1];
        int otherEngeL = majorArr[1][2];
        int otherL = majorArr[1][3];
        purpleLBar = new Shape(0, 0, cmdaMathH * BAR_WIDTH, 10, Color.MAGENTA);
        blueLBar = new Shape(0, 0, compSciH * BAR_WIDTH, 10, Color.BLUE);
        yellowLBar = new Shape(0, 0, otherEngeH * BAR_WIDTH, 10, Color.YELLOW);
        greenLBar = new Shape(0, 0, otherH * BAR_WIDTH, 10, Color.GREEN);
        purpleRBar = new Shape(0, 0, cmdaMathL * BAR_WIDTH, 10, Color.MAGENTA);
        blueRBar = new Shape(0, 0, compSciL * BAR_WIDTH, 10, Color.BLUE);
        yellowRBar = new Shape(0, 0, otherEngeL * BAR_WIDTH, 10, Color.YELLOW);
        greenRBar = new Shape(0, 0, otherL * BAR_WIDTH, 10, Color.GREEN);
        blackBar = new Shape(0, 0, 10, 50);
        title = new TextShape(0, 0, song.getTitle());
        variantText = new TextShape(0, 0, song.getGenre());

        Shape[] majorShapes = new Shape[11];
        majorShapes[0] = purpleLBar;
        majorShapes[1] = blueLBar;
        majorShapes[2] = yellowLBar;
        majorShapes[3] = greenLBar;
        majorShapes[4] = purpleRBar;
        majorShapes[5] = blueRBar;
        majorShapes[6] = yellowRBar;
        majorShapes[7] = greenRBar;
        majorShapes[8] = blackBar;
        majorShapes[9] = title;
        majorShapes[10] = variantText;

        return majorShapes;
    }


    public Shape[] getRegionShapes() {
        
        int[][] regionArr = sortByRegion();
        int northH = regionArr[0][0];
        int southH = regionArr[0][1];
        int otherH = regionArr[0][2];
        int outH = regionArr[0][3];
        int northL = regionArr[1][0];
        int southL = regionArr[1][1];
        int otherL = regionArr[1][2];
        int outL = regionArr[1][3];
        purpleLBar = new Shape(0, 0, northH * BAR_WIDTH, 10, Color.MAGENTA);
        blueLBar = new Shape(0, 0, southH * BAR_WIDTH, 10, Color.BLUE);
        yellowLBar = new Shape(0, 0, otherH * BAR_WIDTH, 10, Color.YELLOW);
        greenLBar = new Shape(0, 0, outH * BAR_WIDTH, 10, Color.GREEN);
        purpleRBar = new Shape(0, 0, northL * BAR_WIDTH, 10, Color.MAGENTA);
        blueRBar = new Shape(0, 0, southL * BAR_WIDTH, 10, Color.BLUE);
        yellowRBar = new Shape(0, 0, otherL * BAR_WIDTH, 10, Color.YELLOW);
        greenRBar = new Shape(0, 0, outL * BAR_WIDTH, 10, Color.GREEN);
        blackBar = new Shape(0, 0, 10, 50);
        title = new TextShape(0, 0, song.getTitle());
        variantText = new TextShape(0, 0, song.getGenre());

        Shape[] regionShapes = new Shape[11];
        regionShapes[0] = purpleLBar;
        regionShapes[1] = blueLBar;
        regionShapes[2] = yellowLBar;
        regionShapes[3] = greenLBar;
        regionShapes[4] = purpleRBar;
        regionShapes[5] = blueRBar;
        regionShapes[6] = yellowRBar;
        regionShapes[7] = greenRBar;
        regionShapes[8] = blackBar;
        regionShapes[9] = title;
        regionShapes[10] = variantText;

        return regionShapes;
    }


    public Shape[] getHobbyShapes() {
        return new Shape[1];
    }

}
