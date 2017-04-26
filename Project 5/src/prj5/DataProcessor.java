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
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class DataProcessor {
    private GlyphList gList;
    private LinkedList<Person> pList;
    private Scanner pReader;
    private Scanner mReader;
    public static int numSongs;


    /**
     * Creates a new FileReader object
     * 
     * @param filePeople
     *            the information about the people and their responses
     * @param fileSongs
     *            the information about the songs
     */
    public DataProcessor(String filePeople, String fileSongs) {
        // number of songs in the file of songs
        numSongs = getNumSongs(fileSongs);
        // passes the survey data to get parsed into people
        parsePeople(filePeople);
        // starts a GUIProjectWindow by passing a list of glyphs
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
    private void parsePeople(String file) {
        pList = new LinkedList<Person>();
        // MAJOR, REGION, HOBBY, RESPONSES
        try {
            pReader = new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] strArr; // contains each line of the scanner
        Person tempPerson; // temp person for parsing
        String[] responses; // each persons responses
        MajorEnum major;
        RegionEnum region;
        HobbyEnum hobby;
        String heard;
        String liked;
        while (pReader.hasNextLine()) {
            // creates an array with each response of the scanner separated from
            // commas
            strArr = pReader.nextLine().split(",");

            // if the string array is less than it should be, an extra response
            // is added to the end. Covers the case where the last response is a
            // comma and the scanner goes to a new line
            if (strArr.length < 5 + (numSongs * 2)) {
                String[] temp = new String[strArr.length + 1];
                for (int y = 0; y < strArr.length; y++) {
                    temp[y] = strArr[y];
                }
                temp[strArr.length] = ""; // adds blank entry the scanner
                                          // skipped
                strArr = temp;
            }

            // makes sure the strArr has all necessary people fields
            if (strArr.length > 5) {
                major = MajorEnum.getMajor(strArr[2]);
                region = RegionEnum.getRegion(strArr[3]);
                hobby = HobbyEnum.getHobby(strArr[4]);
                if (hobby == null || major == null || region == null) {
                    continue; // exits the current iteration through the while
                              // loop if any person field is null
                }
                responses = new String[numSongs]; // each index has liked and
                                                  // heard response for one song

                // necessary to fill array with blank responses in case it is
                // not
                // completely filled after parsing
                for (int x = 0; x < numSongs; x++) {
                    responses[x] = " , ";
                }

                // starting at the first response and going to the end of array
                for (int i = 5; i < strArr.length - 1; i += 2) {

                    // changes all blank responses to a space for statistics
                    // later
                    if (strArr[i].equals("")) {
                        heard = " ";
                    }
                    else {
                        heard = strArr[i];
                    }
                    // changes all blank responses to a space for statistics
                    // later
                    if (strArr[i + 1].equals("")) {
                        liked = " ";
                    }
                    else {
                        liked = strArr[i + 1];
                    }
                    // files the responses array from 0 to numSongs with heard
                    // and liked response per person
                    responses[(i - 5) / 2] = heard + "," + liked;
                }
                tempPerson = new Person(major, region, hobby, responses);
                pList.add(tempPerson);
            }

        }
        // list of all people used to calculate percentages
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
    private GlyphList parseSongs(String file) {
        gList = new GlyphList();

        try {
            mReader = new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] strArr; // contains each line of the scanner
        int id = 0; // each song has an ID based on order from file
        String artist = null;
        String genre = null;
        String title = null;
        String date = null;
        LinkedList<Person> heardList = null;
        LinkedList<Person> likedList = null;
        mReader.nextLine(); // skips the column headers
        while (mReader.hasNextLine()) {
            // creates an array with each response of the scanner separated from
            // commas
            strArr = mReader.nextLine().split(",");

            // goes through each song, incrementing by 5
            for (int i = 0; i < strArr.length; i += 5) {
                title = strArr[i];
                artist = strArr[i + 1];
                date = strArr[i + 2];
                genre = strArr[i + 3];
                heardList = makeHeardList(id); // helper methods called that
                                               // passes in ID
                likedList = makeLikedList(id);
            }
            Song tempSong = new Song(id, artist, genre, title, date, heardList,
                likedList);
            // every glyph contains a song
            GUIGlyph tempGUIGlyph = new GUIGlyph(tempSong);
            gList.add(tempGUIGlyph);

            id++; // increments id
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
    private LinkedList<Person> makeHeardList(int id) {
        LinkedList<Person> hList = new LinkedList<Person>();
        Iterator<Person> iter = pList.iterator();

        // iterating through all the people from the survey
        while (iter.hasNext()) {
            Person temp = iter.next();
            // calls the persons getHeard method that returns the response to
            // that specific song
            if (temp.getHeard(id).equals("Yes")) {
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
    private LinkedList<Person> makeLikedList(int id) {
        LinkedList<Person> LList = new LinkedList<Person>();
        Iterator<Person> iter = pList.iterator();

        // iterating through all the people from the survey
        while (iter.hasNext()) {
            Person temp = iter.next();
            // calls the persons getHeard method that returns the response to
            // that specific song
            if (temp.getLiked(id).equals("Yes")) {
                LList.add(temp);
            }
        }
        return LList;
    }


    /**
     * Returns the correct number of songs from the file
     * 
     * @param str
     *            the survey data
     * @return the number of songs
     */
    private int getNumSongs(String str) {
        Scanner length = null;
        try {
            length = new Scanner(new File(str));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = -1; // accounts for column headers
        while (length.hasNextLine()) {
            length.nextLine();
            count++;
        }

        return count;
    }
}
