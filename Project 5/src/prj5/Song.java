/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * Class that creates new song objects and has sort functions for the people
 * lists
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class Song {

    private int id;
    private String artist;
    private String genre;
    private String title;
    private String date;
    private LinkedList<Person> heardList;
    private LinkedList<Person> likedList;


    /**
     * Creates a new Song object
     * 
     * @param id
     *            The identification number for a song
     * @param a
     *            The artist of the song
     * @param g
     *            The genre of the song
     * @param t
     *            The title of the song
     * @param d
     *            The date that the song was released
     * @param hL
     *            The list of people who have heard the song
     * @param lL
     *            The list of people who have liked the song
     */
    public Song(
        int id,
        String a,
        String g,
        String t,
        String d,
        LinkedList<Person> hL,
        LinkedList<Person> lL) {

        this.id = id;
        artist = a;
        genre = g;
        title = t;
        date = d;
        heardList = hL;
        likedList = lL;

    }


    /**
     * Method that gets the artist of the song
     * 
     * @return String is the artist of the song
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Method that gets the title of the song
     * 
     * @return String is the title of the song
     */
    public String getTitle() {
        return title;
    }


    /**
     * Method that gets the genre of the song
     * 
     * @return String is the genre of the song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Method that gets the date of the song
     * 
     * @return String is the date of the song
     */
    public String getDate() {
        return date;
    }


    /**
     * Method that gets the heardList
     * 
     * @return LinkedList<Person> is the heardList
     */
    public LinkedList<Person> getHeardList() {
        return heardList;
    }


    /**
     * Method that gets the likedList
     * 
     * @return LinkedList<Person> is the likedList
     */
    public LinkedList<Person> getLikedList() {
        return likedList;
    }


    /**
     * Method that formats the song's information into String form
     * 
     * @return String is the String format of the song's information
     */
    public String toString() {
        return title + " by " + artist + ", " + genre + "; " + date;
    }


    /**
     * Method that uses the heard and liked lists of people and returns a 2D
     * array filled with the percentages of people with certain hobbies who have
     * heard and/or liked the song
     * 
     * @return int[][] is the 2D array filled with percentages of the people, of
     *         certain hobbies, who hear and/or liked the song out of all the
     *         people
     */
    public int[][] sortByHobby() {
        double readH = 0;
        double artH = 0;
        double musicH = 0;
        double sportH = 0;
        double readL = 0;
        double artL = 0;
        double musicL = 0;
        double sportL = 0;
        int[][] hobbyArr = new int[2][4];
        Iterator<Person> iter = heardList.iterator();

        // goes through the heardList and counts every person by hobby
        while (iter.hasNext()) {
            Person temp = iter.next();

            switch (temp.getHobby()) {
                case READING:
                    readH++;
                    break;
                case ART:
                    artH++;
                    break;
                case MUSIC:
                    musicH++;
                    break;
                case SPORTS:
                    sportH++;
                    break;
                default:
                    break;

            }

        }

        iter = likedList.iterator();

        // goes through the likedList and counts every person by hobby
        while (iter.hasNext()) {
            Person temp = iter.next();
            switch (temp.getHobby()) {
                case READING:
                    readL++;
                    break;
                case ART:
                    artL++;
                    break;
                case MUSIC:
                    musicL++;
                    break;
                case SPORTS:
                    sportL++;
                    break;
                default:
                    break;
            }

        }
        int[] hHTotal = PersonList.getHobbyHTotal(id); // total people who voted
                                                       // on heard by hobby
        int[] hLTotal = PersonList.getHobbyLTotal(id); // total people who voted
                                                       // on liked by hobby

        // computes the percentage of Yes responses to people who voted and puts
        // it into a 2D array with the first row being heard and second being
        // liked
        hobbyArr[0][0] = (int)((readH / hHTotal[0]) * 100);
        hobbyArr[0][1] = (int)((artH / hHTotal[1]) * 100);
        hobbyArr[0][2] = (int)((sportH / hHTotal[2]) * 100);
        hobbyArr[0][3] = (int)((musicH / hHTotal[3]) * 100);
        hobbyArr[1][0] = (int)((readL / hLTotal[0]) * 100);
        hobbyArr[1][1] = (int)((artL / hLTotal[1]) * 100);
        hobbyArr[1][2] = (int)((sportL / hLTotal[2]) * 100);
        hobbyArr[1][3] = (int)((musicL / hLTotal[3]) * 100);

        return hobbyArr;
    }


    /**
     * Method that uses the heard and liked lists of people and returns a 2D
     * array filled with the percentages of people with certain regions who have
     * heard and/or liked the song
     * 
     * @return int[][] is the 2D array filled with percentages of the people, of
     *         certain regions, who hear and/or liked the song out of all the
     *         people
     */
    public int[][] sortByRegion() {
        double northEH = 0;
        double southEH = 0;
        double otherH = 0;
        double outH = 0;
        double northEL = 0;
        double southEL = 0;
        double otherL = 0;
        double outL = 0;
        int[][] regionArr = new int[2][4];
        Iterator<Person> iter = heardList.iterator();

        // goes through the heardList and counts every person by region
        while (iter.hasNext()) {
            Person temp = iter.next();
            switch (temp.getRegion()) {
                case NORTHEAST:
                    northEH++;
                    break;
                case SOUTHEAST:
                    southEH++;
                    break;
                case OTHER_US:
                    otherH++;
                    break;
                case OUTSIDE_US:
                    outH++;
                    break;
                default:
                    break;
            }

        }

        iter = likedList.iterator();

        // goes through the likedList and counts every person by hobby
        while (iter.hasNext()) {
            Person temp = iter.next();
            switch (temp.getRegion()) {
                case NORTHEAST:
                    northEL++;
                    break;
                case SOUTHEAST:
                    southEL++;
                    break;
                case OTHER_US:
                    otherL++;
                    break;
                case OUTSIDE_US:
                    outL++;
                    break;
                default:
                    break;
            }

        }

        // total people who voted
        // on heard and liked by region

        int[] rHTotal = PersonList.getRegionHTotal(id);
        int[] rLTotal = PersonList.getRegionLTotal(id);

        // computes the percentage of Yes responses to people who voted and puts
        // it into a 2D array with the first row being heard and second being
        // liked
        regionArr[0][0] = (int)((northEH / rHTotal[0]) * 100);
        regionArr[0][1] = (int)((southEH / rHTotal[1]) * 100);
        regionArr[0][2] = (int)((otherH / rHTotal[2]) * 100);
        regionArr[0][3] = (int)((outH / rHTotal[3]) * 100);
        regionArr[1][0] = (int)((northEL / rLTotal[0]) * 100);
        regionArr[1][1] = (int)((southEL / rLTotal[1]) * 100);
        regionArr[1][2] = (int)((otherL / rLTotal[2]) * 100);
        regionArr[1][3] = (int)((outL / rLTotal[3]) * 100);

        return regionArr;

    }


    /**
     * Method that uses the heard and liked lists of people and returns a 2D
     * array filled with the percentages of people with certain majors who have
     * heard and/or liked the song
     * 
     * @return int[][] is the 2D array filled with percentages of the people, of
     *         certain majors, who hear and/or liked the song out of all the
     *         people
     */
    public int[][] sortByMajor() {
        double mathH = 0;
        double compSciH = 0;
        double otherEngeH = 0;
        double otherH = 0;
        double mathL = 0;
        double compSciL = 0;
        double otherEngeL = 0;
        double otherL = 0;
        int[][] majorArr = new int[2][4];

        Iterator<Person> iter = heardList.iterator();

        // goes through the heardList and counts every person by major
        while (iter.hasNext()) {
            Person temp = iter.next();

            switch (temp.getMajor()) {
                case MATH_CMDA:
                    mathH++;
                    break;
                case COMP_SCI:
                    compSciH++;
                    break;
                case OTHER_ENGE:
                    otherEngeH++;
                    break;
                case OTHER:
                    otherH++;
                    break;
                default:
                    break;
            }

        }

        iter = likedList.iterator();

        // goes through the likedList and counts every person by hobby
        while (iter.hasNext())

        {
            Person temp = iter.next();

            switch (temp.getMajor()) {
                case MATH_CMDA:
                    mathL++;
                    break;
                case COMP_SCI:
                    compSciL++;
                    break;
                case OTHER_ENGE:
                    otherEngeL++;
                    break;
                case OTHER:
                    otherL++;
                    break;
                default:
                    break;
            }

        }

        // total people who voted
        // on heard and liked by major
        int[] mHTotal = PersonList.getMajorHTotal(id);
        int[] mLTotal = PersonList.getMajorLTotal(id);

        // computes the percentage of Yes responses to people who voted and puts
        // it into a 2D array with the first row being heard and second being
        // liked
        majorArr[0][0] = (int)((mathH / mHTotal[0]) * 100);
        majorArr[0][1] = (int)((compSciH / mHTotal[1]) * 100);
        majorArr[0][2] = (int)((otherEngeH / mHTotal[2]) * 100);
        majorArr[0][3] = (int)((otherH / mHTotal[3]) * 100);
        majorArr[1][0] = (int)((mathL / mLTotal[0]) * 100);
        majorArr[1][1] = (int)((compSciL / mLTotal[1]) * 100);
        majorArr[1][2] = (int)((otherEngeL / mLTotal[2]) * 100);
        majorArr[1][3] = (int)((otherL / mLTotal[3]) * 100);

        return majorArr;
    }

}
