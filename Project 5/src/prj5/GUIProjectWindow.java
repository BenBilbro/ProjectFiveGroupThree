/**
 * 
 */
package prj5;

import java.awt.Color;
import java.util.Iterator;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Has the display where the user will interact with the buttons to view the
 * information
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version April 19, 2017
 *
 */
public class GUIProjectWindow {

    private final int glyphsPerPage = 9;
    private GlyphList gList;
    private Window window;
    private Button prev;
    private Button sortArtist;
    private Button sortTitle;
    private Button sortDate;
    private Button sortGenre;
    private Button next;
    private Button repHobby;
    private Button repMajor;
    private Button repRegion;
    private Button quit;
    private Iterator<GUIGlyph> iter;
    private int iteratorIndex;
    private Class<?> currentEnum = null;
    private final int numSongs = DataProcessor.numSongs;
    private String currSort;
    private TextShape firstAttribute;
    private TextShape secondAttribute;
    private TextShape thirdAttribute;
    private TextShape fourthAttribute;
    private TextShape legendTitle;


    /**
     * Constructor that initializes all the instance data
     * 
     * @param GUIGlyphList
     *            is the list of GUIGlyphs that will be displayed
     */
    public GUIProjectWindow(GlyphList GUIGlyphList) {

        this.gList = GUIGlyphList;
        iter = gList.iterator();
        iteratorIndex = 0;

        // instantiates a window
        window = new Window("Project 5");
        window.setSize(920, 450);

        // initializes buttons and glyphs
        initializeButtons();
    }


    /**
     * Helper method that initializes the GUIGlyphs and displays them
     * 
     * @param Class
     *            being the current Enum based sort (hobby region major)
     */
    private void initializeGUIGlyphs(Class<?> Class) {
        if (Class != null) {
            // clears the screen of glyphs
            removeAllGlyphs();
            int offsetX = 235;
            int offsetY = 100;
            int refX = 150;
            int refY = 50;
            // iterates one page of glyphs at a time if the iterator has next
            for (int j = 1; j <= glyphsPerPage; j++) {
                if (iter.hasNext()) {
                    GUIGlyph glyph = iter.next();
                    iteratorIndex++;
                    Shape[] shapes;

                    // Calls the glyphs .getEnumShapes which returns all
                    // neccessary bars and shapes in a glyph
                    if (Class.equals(MajorEnum.class)) {
                        shapes = glyph.getMajorShapes(currSort);
                    }
                    else if (Class.equals(RegionEnum.class)) {
                        shapes = glyph.getRegionShapes(currSort);
                    }
                    else {
                        shapes = glyph.getHobbyShapes(currSort);
                    }

                    Shape blackBar = shapes[8];
                    blackBar.setX(refX);
                    blackBar.setY(refY);
                    window.addShape(blackBar);

                    int height = 0;
                    // positions left bars
                    for (int i = 0; i < 4; i++) {
                        shapes[i].setX(refX - shapes[i].getWidth());
                        shapes[i].setY(refY + height);
                        window.addShape(shapes[i]);
                        height += 10;
                    }
                    height = 0;
                    // positions right bars
                    for (int i = 4; i < 8; i++) {
                        shapes[i].setX(refX + blackBar.getWidth());
                        shapes[i].setY(refY + height);
                        window.addShape(shapes[i]);
                        height += 10;
                    }

                    // sets coordinates

                    shapes[9].setX(refX - shapes[9].getWidth() / 2);
                    shapes[9].setY(refY - 40);
                    shapes[9].setBackgroundColor(Color.WHITE);
                    window.addShape(shapes[9]);
                    window.moveToFront(shapes[9]);

                    shapes[10].setX(refX - shapes[10].getWidth() / 2);
                    shapes[10].setY(refY - 20);
                    shapes[10].setBackgroundColor(Color.WHITE);
                    window.addShape(shapes[10]);
                }

                // depending on which object the iterator is on, its coordinates
                // are offset
                if (j % 3 == 0) {
                    // j % 3 is when the iter is at the end of the row
                    refX = 150;
                    refY += offsetY;
                }
                else {
                    refX += offsetX;
                }

            }
        }

        // disables next if on the last page else enables
        if (iteratorIndex == numSongs) {
            next.disable();
        }
        else {
            next.enable();
        }
        // disables prev if on the first page else enables
        if (iteratorIndex == glyphsPerPage) {
            prev.disable();
        }
        else {
            prev.enable();
        }
    }


    /**
     * Sorts the gList by artist alphabetically
     * 
     * @param button
     *            that is pressed
     */
    public void clickedSortArtist(Button button) {
        gList.sortGlyph("Artist");
        currSort = "Artist"; // updates currSort

        iter = gList.iterator();
        // resets the iterator to start at beginning
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    /**
     * Sorts the gList by Title alphabetically
     * 
     * @param button
     *            being pressed
     */
    public void clickedSortTitle(Button button) {
        gList.sortGlyph("Title");
        currSort = "Artist"; // updates currSort

        iter = gList.iterator();
        // resets the iterator to start at beginning
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    /**
     * Sorts the gList by dates from earliest to latest
     * 
     * @param button
     *            being pressed
     */
    public void clickedSortDate(Button button) {
        gList.sortGlyph("Date");
        currSort = "Date"; // updates currSort

        iter = gList.iterator();
        // resets the iterator to start at beginning
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    /**
     * Sorts the gList by Genre alphabetically
     * 
     * @param button
     *            being pressed
     */
    public void clickedSortGenre(Button button) {
        gList.sortGlyph("Genre");
        currSort = "Genre"; // updates currSort

        iter = gList.iterator();
        // resets the iterator to start at beginning
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    /**
     * Goes to the next page of glyphs
     * 
     * @param button
     *            being pressed
     */
    public void clickedNext(Button button) {
        initializeGUIGlyphs(currentEnum);
    }


    /**
     * Goes back a page of glyphs and accounts for being on the last page by
     * using modulus to subtract the correct number of Glyphs
     * 
     * @param button
     *            being pressed
     */
    public void clickedPrevious(Button button) {
        // uses modulus to only subtract the correct number of glyphs from the
        // last page
        if (iteratorIndex == numSongs) {
            iteratorIndex -= ((numSongs % glyphsPerPage) + glyphsPerPage);
        }
        // has to go back 18 glyphs in order to reload the previous page
        else if (iteratorIndex != 0) {
            iteratorIndex -= glyphsPerPage * 2;
        }

        iter = gList.iteratorIndex(iteratorIndex);
        initializeGUIGlyphs(currentEnum);
    }


    /**
     * Initializes the glyphs to display data represented by major
     * 
     * @param button
     *            being pressed
     */
    public void clickedRepresentMajor(Button button) {
        // updates which Enum we are sorting by
        currentEnum = MajorEnum.class;
        updateLegend();
        if (iteratorIndex == 0) {
            // enables all buttons during first click (initialization)
            sortArtist.enable();
            sortDate.enable();
            sortGenre.enable();
            sortTitle.enable();
            initializeGUIGlyphs(currentEnum);
        }
        // any time after the first button has been pressed
        // must only go backwards through the iterator enough to reload the
        // current page
        else {
            // if on the last page only subtract the correct number of glyphs
            if (iteratorIndex == numSongs) {
                iteratorIndex -= (numSongs % glyphsPerPage);
            }
            // else subtract normally
            else {
                iteratorIndex -= glyphsPerPage;
            }

            iter = gList.iteratorIndex(iteratorIndex);
            initializeGUIGlyphs(currentEnum);
        }
    }


    /**
     * Initializes the glyphs to display data represented by hobby
     * 
     * @param button
     *            being pressed
     */
    public void clickedRepresentHobby(Button button) {
        currentEnum = HobbyEnum.class;
        updateLegend();
        if (iteratorIndex == 0) {
            // enables all buttons during first click (initialization)
            sortArtist.enable();
            sortDate.enable();
            sortGenre.enable();
            sortTitle.enable();
            initializeGUIGlyphs(currentEnum);
        }
        // any time after the first button has been pressed
        // must only go backwards through the iterator enough to reload the
        // current page
        else {
            // if on the last page only subtract the correct number of glyphs
            if (iteratorIndex == numSongs) {
                iteratorIndex -= (numSongs % glyphsPerPage);
            }
            // else subtract normally
            else {
                iteratorIndex -= glyphsPerPage;
            }

            iter = gList.iteratorIndex(iteratorIndex);
            initializeGUIGlyphs(currentEnum);
        }
    }


    /**
     * Initializes the glyphs to display data represented by region
     * 
     * @param button
     *            being pressed
     */
    public void clickedRepresentRegion(Button button) {
        currentEnum = RegionEnum.class;
        updateLegend();
        if (iteratorIndex == 0) {
            // enables all buttons during first click (initialization)
            sortArtist.enable();
            sortDate.enable();
            sortGenre.enable();
            sortTitle.enable();
            initializeGUIGlyphs(currentEnum);
        }
        // any time after the first button has been pressed
        // must only go backwards through the iterator enough to reload the
        // current page
        else {
            // if on the last page only subtract the correct number of glyphs
            if (iteratorIndex == numSongs) {
                iteratorIndex -= (numSongs % glyphsPerPage);
            }
            // else subtract normally
            else {
                iteratorIndex -= glyphsPerPage;
            }

            iter = gList.iteratorIndex(iteratorIndex);
            initializeGUIGlyphs(currentEnum);
        }
    }


    /**
     * Exits the program
     * 
     * @param button
     *            being pressed
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * removes all the glyphs on the window and updates the legend
     */
    public void removeAllGlyphs() {
        window.removeAllShapes();
        updateLegend();
    }


    /**
     * updates the legend depending on the current Enum sort
     */
    public void updateLegend() {
        initializeLegend();
        // changes legend to represent hobby
        if (currentEnum.equals(HobbyEnum.class)) {
            firstAttribute = new TextShape(780, 185, "Read", Color.MAGENTA);
            secondAttribute = new TextShape(780, 200, "Art", Color.BLUE);
            thirdAttribute = new TextShape(780, 215, "Sports", Color.ORANGE);
            fourthAttribute = new TextShape(780, 230, "Music", Color.GREEN);

            legendTitle = new TextShape(780, 165, "Hobby Legend", Color.BLACK);
            window.addShape(legendTitle);
            window.moveToFront(legendTitle);
            legendTitle.setBackgroundColor(Color.WHITE);
        }
        // changes legend to represent major
        else if (currentEnum.equals(MajorEnum.class)) {
            firstAttribute = new TextShape(780, 185, "Comp Sci", Color.MAGENTA);
            secondAttribute = new TextShape(780, 200, "Other Eng", Color.BLUE);
            thirdAttribute = new TextShape(780, 215, "Math / CMDA",
                Color.ORANGE);
            fourthAttribute = new TextShape(780, 230, "Other", Color.GREEN);

            legendTitle = new TextShape(780, 165, "Major Legend", Color.BLACK);
            window.addShape(legendTitle);
            window.moveToFront(legendTitle);
            legendTitle.setBackgroundColor(Color.WHITE);
        }
        // changes legend to represent region
        else {
            firstAttribute = new TextShape(780, 185, "Northeast",
                Color.MAGENTA);
            secondAttribute = new TextShape(780, 200, "Southeast", Color.BLUE);
            thirdAttribute = new TextShape(780, 215, "Other US", Color.ORANGE);
            fourthAttribute = new TextShape(780, 230, "Outside US",
                Color.GREEN);

            legendTitle = new TextShape(780, 165, "Region Legend", Color.BLACK);
            window.addShape(legendTitle);
            window.moveToFront(legendTitle);
            legendTitle.setBackgroundColor(Color.WHITE);
        }

        // correctly sets the colors
        firstAttribute.setBackgroundColor(Color.WHITE);
        secondAttribute.setBackgroundColor(Color.WHITE);
        thirdAttribute.setBackgroundColor(Color.WHITE);
        fourthAttribute.setBackgroundColor(Color.WHITE);

        // adds the shapes and moves the to the front
        window.addShape(firstAttribute);
        window.addShape(secondAttribute);
        window.addShape(thirdAttribute);
        window.addShape(fourthAttribute);
        window.moveToFront(firstAttribute);
        window.moveToFront(secondAttribute);
        window.moveToFront(thirdAttribute);
        window.moveToFront(fourthAttribute);
    }


    /**
     * Initializes the legend except for the Enum dependent text shapes
     */
    public void initializeLegend() {
        // creates sample song title
        TextShape legendSongTitle = new TextShape(795, 245, "Song Title",
            Color.BLACK);
        legendSongTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendSongTitle);
        window.moveToFront(legendSongTitle);

        // creates sample heard text
        TextShape legendHeard = new TextShape(790, 275, "Heard", Color.BLACK);
        legendHeard.setBackgroundColor(Color.WHITE);
        window.addShape(legendHeard);
        window.moveToFront(legendHeard);

        // creates sample liked text
        TextShape legendLiked = new TextShape(840, 275, "Likes", Color.BLACK);
        legendLiked.setBackgroundColor(Color.WHITE);
        window.addShape(legendLiked);
        window.moveToFront(legendLiked);

        // creates sample bar to represent a glyph
        Shape blackBar = new Shape(835, 265, 5, 40, Color.BLACK);
        window.addShape(blackBar);
        window.moveToFront(blackBar);

        // the box surrounding the legend
        Shape outline = new Shape(775, 160, 115, 155, Color.BLACK);
        outline.setBackgroundColor(Color.WHITE);
        window.addShape(outline);

    }


    /**
     * Initializes the buttons and displays them
     */
    private void initializeButtons() {
        // creates all buttons
        prev = new Button("<-- Prev");
        sortArtist = new Button("Sort by Artist Name");
        sortTitle = new Button("Sort by Song Title");
        sortDate = new Button("Sort by Release Year");
        sortGenre = new Button("Sort by Genre");
        next = new Button("Next -->");
        repHobby = new Button("Represent Hobby");
        repMajor = new Button("Represent Major");
        repRegion = new Button("Represent Region");
        quit = new Button("Quit");

        // sets the onClick method for each button
        prev.onClick(this, "clickedPrevious");
        sortArtist.onClick(this, "clickedSortArtist");
        sortTitle.onClick(this, "clickedSortTitle");
        sortDate.onClick(this, "clickedSortDate");
        sortGenre.onClick(this, "clickedSortGenre");
        next.onClick(this, "clickedNext");
        repHobby.onClick(this, "clickedRepresentHobby");
        repMajor.onClick(this, "clickedRepresentMajor");
        repRegion.onClick(this, "clickedRepresentRegion");
        quit.onClick(this, "clickedQuit");

        // disables certain buttons before first click
        sortArtist.disable();
        sortDate.disable();
        sortGenre.disable();
        sortTitle.disable();
        prev.disable();
        next.disable();

        // adds all buttons
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortArtist, WindowSide.NORTH);
        window.addButton(sortTitle, WindowSide.NORTH);
        window.addButton(sortDate, WindowSide.NORTH);
        window.addButton(sortGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(repHobby, WindowSide.SOUTH);
        window.addButton(repMajor, WindowSide.SOUTH);
        window.addButton(repRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
    }
}
