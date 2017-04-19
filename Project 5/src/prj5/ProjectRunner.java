/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The purpose of this class is to parse the given survey data, going through
 * people's responses and the different songs. From that data, a list of valid
 * people and GUIGlyphs is created
 * of
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class ProjectRunner
{
    private LinkedList<GUIGlyph> gList;
    private LinkedList<Person> pList;
    private Scanner pReader;
    private Scanner mReader;
    private int rLength;


    /**
     * Creates a new FileReader object
     * 
     * @param filePeople
     *            the information about the people and their responses
     * @param fileSongs
     *            the information about the songs
     */
    public ProjectRunner(String filePeople, String fileSongs)
    {
        rLength = getRLength(fileSongs);
        parsePeople(filePeople);
        new GUIProjectWindow(parseSongs(fileSongs));

    }


    /**
     * Allocates all of the information given from each person's response in the
     * data for each song
     * 
     * @param file
     *            the information about the people and their responses for each
     *            song
     */
    public void parsePeople(String file)
    {
        pList = new LinkedList<Person>();
        // MAJOR, REGION, HOBBY, RESPONSES
        try
        {
            pReader = new Scanner(new File(file));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        String[] strArr;
        Person tempPerson;
        String[] responses;
        MajorEnum major;
        RegionEnum region;
        HobbyEnum hobby;
        String heard;
        String liked;
        pReader.nextLine();
        while (pReader.hasNextLine())
        {
            strArr = pReader.nextLine().split(",");
            if (strArr.length % 2 == 0)
            {
                String[] temp = new String[strArr.length + 1];
                for (int y = 0; y < strArr.length; y++)
                {
                    temp[y] = strArr[y];
                }
                temp[strArr.length] = "";
                strArr = temp;
            }

            if (strArr.length > 5)
            {
                major = MajorEnum.getMajor(strArr[2]);
                region = RegionEnum.getRegion(strArr[3]);
                hobby = HobbyEnum.getHobby(strArr[4]);
                if (hobby == null || major == null || region == null)
                {
                    continue;
                }
                responses = new String[rLength];
                for (int x = 0; x < rLength; x++)
                {
                    responses[x] = " , ";
                }

                for (int i = 5; i < strArr.length - 1; i += 2)
                {

                    if (strArr[i].equals(""))
                    {
                        heard = " ";
                    }
                    else
                    {
                        heard = strArr[i];
                    }
                    if (strArr[i + 1].equals(""))
                    {
                        liked = " ";
                    }
                    else
                    {
                        liked = strArr[i + 1];
                    }
                    responses[(i - 5) / 2] = heard + "," + liked;
                }
                tempPerson = new Person(major, region, hobby, responses);
                pList.add(tempPerson);
            }

        }
        new PersonList(pList);
    }


    /**
     * Gets all of the information about the songs, makes a heard and liked list
     * for each song, and associates a GUIGlyph to it
     * 
     * @param file
     *            the information about each song
     * @return a list of GUIGlyphs that will be used for visual implementation
     */
    public LinkedList<GUIGlyph> parseSongs(String file)
    {
        gList = new LinkedList<GUIGlyph>();

        try
        {
            mReader = new Scanner(new File(file));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        String[] strArr;
        int id = 0;
        String artist = null;
        String genre = null;
        String title = null;
        String date = null;
        LinkedList<Person> heardList = null;
        LinkedList<Person> likedList = null;
        mReader.nextLine();
        while (mReader.hasNextLine())
        {
            strArr = mReader.nextLine().split(",");
            for (int i = 0; i < strArr.length; i += 5)
            {
                title = strArr[i];
                artist = strArr[i + 1];
                date = strArr[i + 2];
                genre = strArr[i + 3];
                heardList = makeHeardList(id);
                likedList = makeLikedList(id);
            }
            Song tempSong = new Song(id, artist, genre, title, date, heardList,
                likedList);
            GUIGlyph tempGUIGlyph = new GUIGlyph(tempSong);
            gList.add(tempGUIGlyph);

            id++;
        }

        return gList;
    }


    /**
     * Creates a list of people who have heard a song
     * 
     * @param id
     *            the identifier for the specific song
     * @return a list a people who have heard the song associated to the id
     */
    public LinkedList<Person> makeHeardList(int id)
    {
        LinkedList<Person> hList = new LinkedList<Person>();

        Iterator<Person> iter = pList.iterator();
        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getHeard(id).equals("Yes"))
            {
                hList.add(temp);
            }
        }
        return hList;
    }


    /**
     * * Creates a list of people who have liked a song
     * 
     * @param id
     *            the identifier for the specific song
     * @return a list a people who have liked the song associated to the id
     */
    public LinkedList<Person> makeLikedList(int id)
    {
        LinkedList<Person> LList = new LinkedList<Person>();
        Iterator<Person> iter = pList.iterator();
        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getLiked(id).equals("Yes"))
            {
                LList.add(temp);
            }
        }
        return LList;
    }


    /**
     * Returns the correct length of the data from the survey
     * 
     * @param str
     *            the survey data
     * @return the length of th edata
     */
    private int getRLength(String str)
    {
        Scanner length = null;
        try
        {
            length = new Scanner(new File(str));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        int count = -1;
        while (length.hasNextLine())
        {
            length.nextLine();
            count++;
        }

        return count;
    }
}
