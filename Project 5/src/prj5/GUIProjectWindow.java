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
public class GUIProjectWindow
{

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
    public GUIProjectWindow(GlyphList GUIGlyphList)
    {

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
     */
    private void initializeGUIGlyphs(Class<?> Class)
    {
        if (Class != null)
        {
            removeAllGlyphs();
            int offsetX = 235;
            int offsetY = 100;
            int refX = 150;
            int refY = 50;
            for (int j = 1; j <= 9; j++)
            {
                if (iter.hasNext())
                {
                    GUIGlyph glyph = iter.next();
                    iteratorIndex++;
                    Shape[] shapes;

                    if (Class.equals(MajorEnum.class))
                    {
                        shapes = glyph.getMajorShapes(currSort);
                    }
                    else if (Class.equals(RegionEnum.class))
                    {
                        shapes = glyph.getRegionShapes(currSort);
                    }
                    else
                    {
                        shapes = glyph.getHobbyShapes(currSort);
                    }

                    Shape blackBar = shapes[8];
                    blackBar.setX(refX);
                    blackBar.setY(refY);
                    window.addShape(blackBar);

                    int height = 0;
                    // positions left bars
                    for (int i = 0; i < 4; i++)
                    {
                        shapes[i].setX(refX - shapes[i].getWidth());
                        shapes[i].setY(refY + height);
                        window.addShape(shapes[i]);
                        height += 10;
                    }
                    height = 0;
                    // positions right bars
                    for (int i = 4; i < 8; i++)
                    {
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

                if (j % 3 == 0)
                {
                    refX = 150;
                    refY += offsetY;
                }
                else
                {
                    refX += offsetX;
                }

            }
        }
        prev.enable();
        next.enable();
        if (iteratorIndex == numSongs)
        {
            next.disable();
        }
        else if (iteratorIndex == glyphsPerPage)
        {
            prev.disable();
        }
    }


    public void clickedSortArtist(Button button)
    {
        gList.sortGlyph("Artist");

        currSort = "Artist";

        iter = gList.iterator();
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    public void clickedSortTitle(Button button)
    {
        gList.sortGlyph("Title");
        currSort = "Artist";

        iter = gList.iterator();
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    public void clickedSortDate(Button button)
    {
        gList.sortGlyph("Date");
        currSort = "Date";

        iter = gList.iterator();
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    public void clickedSortGenre(Button button)
    {
        gList.sortGlyph("Genre");
        currSort = "Genre";

        iter = gList.iterator();
        iteratorIndex = 0;

        initializeGUIGlyphs(currentEnum);
    }


    public void clickedNext(Button button)
    {
        if (iteratorIndex != 0)
        {
            initializeGUIGlyphs(currentEnum);
        }
    }


    public void clickedPrevious(Button button)
    {
        if (iteratorIndex == numSongs)
        {
            iteratorIndex -= ((numSongs % glyphsPerPage) + glyphsPerPage);
        }
        else
        {
            iteratorIndex -= glyphsPerPage * 2;
        }

        iter = gList.iteratorIndex(iteratorIndex);
        initializeGUIGlyphs(currentEnum);
    }


    public void clickedRepresentMajor(Button button)
    {
        currentEnum = MajorEnum.class;
        updateLegend();
        if (iteratorIndex == 0)
        {
            initializeGUIGlyphs(currentEnum);
        }
        else
        {
            if (iteratorIndex == numSongs)
            {
                iteratorIndex -= (numSongs % glyphsPerPage);
            }
            else
            {
                iteratorIndex -= glyphsPerPage;
            }

            iter = gList.iteratorIndex(iteratorIndex);
            initializeGUIGlyphs(currentEnum);
        }
    }


    public void clickedRepresentHobby(Button button)
    {
        currentEnum = HobbyEnum.class;
        updateLegend();
        if (iteratorIndex == 0)
        {
            initializeGUIGlyphs(currentEnum);
        }
        else
        {
            if (iteratorIndex == numSongs)
            {
                iteratorIndex -= (numSongs % glyphsPerPage);
            }
            else
            {
                iteratorIndex -= glyphsPerPage;
            }

            iter = gList.iteratorIndex(iteratorIndex);
            initializeGUIGlyphs(currentEnum);
        }
    }


    public void clickedRepresentRegion(Button button)
    {
        currentEnum = RegionEnum.class;
        updateLegend();
        if (iteratorIndex == 0)
        {
            initializeGUIGlyphs(currentEnum);
        }
        else
        {
            if (iteratorIndex == numSongs)
            {
                iteratorIndex -= (numSongs % glyphsPerPage);
            }
            else
            {
                iteratorIndex -= glyphsPerPage;
            }

            iter = gList.iteratorIndex(iteratorIndex);
            initializeGUIGlyphs(currentEnum);
        }
    }


    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    public void removeAllGlyphs()
    {
        window.removeAllShapes();
        updateLegend();
    }


    public void updateLegend()
    {
        initializeLegend();
        if (currentEnum.equals(HobbyEnum.class))
        {
            firstAttribute = new TextShape(780, 185, "Read", Color.MAGENTA);
            secondAttribute = new TextShape(780, 200, "Art", Color.BLUE);
            thirdAttribute = new TextShape(780, 215, "Sports", Color.ORANGE);
            fourthAttribute = new TextShape(780, 230, "Music", Color.GREEN);

            legendTitle = new TextShape(780, 165, "Hobby Legend", Color.BLACK);
            window.addShape(legendTitle);
            window.moveToFront(legendTitle);
            legendTitle.setBackgroundColor(Color.WHITE);
        }
        else if (currentEnum.equals(MajorEnum.class))
        {
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
        else
        {
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

        firstAttribute.setBackgroundColor(Color.WHITE);
        secondAttribute.setBackgroundColor(Color.WHITE);
        thirdAttribute.setBackgroundColor(Color.WHITE);
        fourthAttribute.setBackgroundColor(Color.WHITE);

        window.addShape(firstAttribute);
        window.addShape(secondAttribute);
        window.addShape(thirdAttribute);
        window.addShape(fourthAttribute);
        window.moveToFront(firstAttribute);
        window.moveToFront(secondAttribute);
        window.moveToFront(thirdAttribute);
        window.moveToFront(fourthAttribute);
    }


    public void initializeLegend()
    {
        TextShape legendSongTitle = new TextShape(795, 245, "Song Title",
            Color.BLACK);
        legendSongTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendSongTitle);
        window.moveToFront(legendSongTitle);

        TextShape legendHeard = new TextShape(790, 275, "Heard", Color.BLACK);
        legendHeard.setBackgroundColor(Color.WHITE);
        window.addShape(legendHeard);
        window.moveToFront(legendHeard);

        TextShape legendLiked = new TextShape(840, 275, "Likes", Color.BLACK);
        legendLiked.setBackgroundColor(Color.WHITE);
        window.addShape(legendLiked);
        window.moveToFront(legendLiked);

        Shape blackBar = new Shape(835, 265, 5, 40, Color.BLACK);
        window.addShape(blackBar);
        window.moveToFront(blackBar);

        Shape outline = new Shape(775, 160, 115, 155, Color.BLACK);
        outline.setBackgroundColor(Color.WHITE);
        window.addShape(outline);

    }


    /**
     * Initializes the buttons and displays them
     */
    private void initializeButtons()
    {
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
