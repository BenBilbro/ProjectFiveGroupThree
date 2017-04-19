/**
 * 
 */
package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Has the display where the user will interact with the buttons to view the
 * information
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version April 19, 2017
 *
 */
public class ProjectWindow
{

    private LinkedList<Glyph> gList;
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


    /**
     * Constructor that initializes all the instance data
     * 
     * @param glyphList
     *            is the list of glyphs that will be displayed
     */
    public ProjectWindow(LinkedList<Glyph> glyphList)
    {
        this.gList = glyphList;

        sortGlyphGenre(gList);
        sortHobby(gList);
        sortGlyphTitle(gList);
        sortHobby(gList);

        window = new Window();
        window.setSize(850, 450);

        initializeButtons();
        initializeGlyphs();

    }


    /**
     * Helper method that initializes the glyphs and displays them
     */
    private void initializeGlyphs()
    {
        Glyph glyph = new Glyph();

        Shape[] shapes = glyph.defaultGlyph();
        int height = 0;
        for (int i = 0; i < 4; i++)
        {
            shapes[i].setX(20);
            shapes[i].setY(50 + height);
            window.addShape(shapes[i]);
            height += 10;
        }
        height = 0;
        for (int i = 4; i < 8; i++)
        {
            shapes[i].setX(130);
            shapes[i].setY(50 + height);
            window.addShape(shapes[i]);
            height += 10;
        }

        shapes[8].setX(120);
        shapes[8].setY(50);
        window.addShape(shapes[8]);

        shapes[9].setX(90);
        shapes[9].setY(10);
        shapes[9].setBackgroundColor(Color.WHITE);
        window.addShape(shapes[9]);

        shapes[10].setX(90);
        shapes[10].setY(30);
        shapes[10].setBackgroundColor(Color.WHITE);
        window.addShape(shapes[10]);
    }


    /**
     * Initializes the buttons and displays them
     */
    private void initializeButtons()
    {
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


    /**
     * Displays each glyph's information to the console per Hobby
     * 
     * @param gList
     *            is the list of glyphs used to display the information
     */
    public void sortHobby(LinkedList<Glyph> gList)
    {
        Object[] output = gList.toArray();
        for (int i = 0; i < output.length; i++)
        {
            System.out.println("Song Title: " + ((Glyph)output[i]).getSong()
                .getTitle());
            System.out.println("Song Artist: " + ((Glyph)output[i]).getSong()
                .getArtist());
            System.out.println("Song Genre: " + ((Glyph)output[i]).getSong()
                .getGenre());
            System.out.println("Song Year: " + ((Glyph)output[i]).getSong()
                .getDate());
            int[][] responses = ((Glyph)output[i]).sortByHobby();
            for (int x = 0; x < responses.length; x++)
            {
                for (int y = 0; y < responses[0].length; y += 4)
                {
                    if (x == 0)
                    {
                        System.out.println("Heard");
                    }
                    else
                    {
                        System.out.println("Likes");
                    }
                    System.out.print("reading:" + responses[x][y] + " ");
                    System.out.print("art:" + responses[x][y + 1] + " ");
                    System.out.print("sports:" + responses[x][y + 2] + " ");
                    System.out.print("music:" + responses[x][y + 3]);
                    System.out.println();
                }
            }
            System.out.println();
        }
    }


    /**
     * Prints the glyph's information to the console per Major
     * 
     * @param gList
     *            is the list of glyphs used to display the information
     */
    public void sortMajor(LinkedList<Glyph> gList)
    {
        Object[] output = gList.toArray();
        for (int i = 0; i < output.length; i++)
        {
            System.out.println("Song Title: " + ((Glyph)output[i]).getSong()
                .getTitle());
            System.out.println("Song Artist: " + ((Glyph)output[i]).getSong()
                .getArtist());
            System.out.println("Song Genre: " + ((Glyph)output[i]).getSong()
                .getGenre());
            System.out.println("Song Year: " + ((Glyph)output[i]).getSong()
                .getDate());
            int[][] responses = ((Glyph)output[i]).sortByMajor();
            for (int x = 0; x < responses.length; x++)
            {
                for (int y = 0; y < responses[0].length; y += 4)
                {
                    if (x == 0)
                    {
                        System.out.println("Heard");
                    }
                    else
                    {
                        System.out.println("Likes");
                    }
                    System.out.print("Math or CMDA:" + responses[x][y] + " ");
                    System.out.print("Computer Science:" + responses[x][y + 1]
                        + " ");
                    System.out.print("Other Engineering:" + responses[x][y + 2]
                        + " ");
                    System.out.print("Other:" + responses[x][y + 3]);
                    System.out.println();
                }
            }
        }
        System.out.println();
    }


    /**
     * Prints the glyph's information to the console per Region
     * 
     * @param gList
     *            is the list of glyphs used to display the information
     */
    public void sortRegion(LinkedList<Glyph> gList)
    {
        Object[] output = gList.toArray();
        for (int i = 0; i < output.length; i++)
        {
            System.out.println("Song Title: " + ((Glyph)output[i]).getSong()
                .getTitle());
            System.out.println("Song Artist: " + ((Glyph)output[i]).getSong()
                .getArtist());
            System.out.println("Song Genre: " + ((Glyph)output[i]).getSong()
                .getGenre());
            System.out.println("Song Year: " + ((Glyph)output[i]).getSong()
                .getDate());
            int[][] responses = ((Glyph)output[i]).sortByRegion();
            for (int x = 0; x < responses.length; x++)
            {
                for (int y = 0; y < responses[0].length; y += 4)
                {
                    if (x == 0)
                    {
                        System.out.println("Heard");
                    }
                    else
                    {
                        System.out.println("Likes");
                    }
                    System.out.print("Northeast:" + responses[x][y] + " ");
                    System.out.print("Southeast:" + responses[x][y + 1] + " ");
                    System.out.print("United States:" + responses[x][y + 2]
                        + " ");
                    System.out.print("Other:" + responses[x][y + 3]);
                    System.out.println();
                    System.out.println();
                }
            }
        }
        System.out.println();
    }


    /**
     * Sorts the glyphs by genre
     * 
     * @param glyphList
     *            is the list of glyphs to be sorted
     */
    public void sortGlyphGenre(LinkedList<Glyph> glyphList)
    {
        Object[] arr = glyphList.toArray();
        int i, j, first;
        Glyph temp;
        for (i = arr.length - 1; i > 0; i--)
        {
            first = 0; // initialize to subscript of first element
            for (j = 1; j <= i; j++) // locate smallest element between
                                     // positions 1 and i.
            {
                if (((Glyph)arr[j]).getSong().getGenre().compareTo(
                    ((Glyph)arr[first]).getSong().getGenre()) < 0)
                    first = j;
            }
            temp = ((Glyph)arr[first]); // swap smallest found with element in
                                        // position
            // i.
            arr[first] = arr[i];
            arr[i] = temp;
        }
        gList.clear();
        for (int z = arr.length - 1; z >= 0; z--)
        {
            gList.add(((Glyph)arr[z]));
        }

    }


    /**
     * Sorts the glyphs by title
     * 
     * @param glyphList
     *            is the list of glyphs to be sorted
     */
    public void sortGlyphTitle(LinkedList<Glyph> glyphList)
    {
        Object[] arr = glyphList.toArray();
        int i, j, first;
        Glyph temp;
        for (i = arr.length - 1; i > 0; i--)
        {
            first = 0; // initialize to subscript of first element
            for (j = 1; j <= i; j++) // locate smallest element between
                                     // positions 1 and i.
            {
                if (((Glyph)arr[j]).getSong().getTitle().compareToIgnoreCase(
                    ((Glyph)arr[first]).getSong().getTitle()) < 0)
                    first = j;
            }
            temp = ((Glyph)arr[first]); // swap smallest found with element in
                                        // position
            // i.
            arr[first] = arr[i];
            arr[i] = temp;
        }
        gList.clear();
        for (int z = arr.length - 1; z >= 0; z--)
        {
            gList.add(((Glyph)arr[z]));
        }

    }
}
