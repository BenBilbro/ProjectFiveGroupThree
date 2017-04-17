/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 *
 */
public class Song
{

    public int id;
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
        LinkedList<Person> lL)
    {

        this.id = id;
        artist = a;
        genre = g;
        title = t;
        date = d;
        heardList = hL;
        likedList = lL;

    }


    /**
     * 
     * @param enumClass
     * @return
     */
    public int[][] getResults(Class<?> enumClass)
    {
        if (enumClass.equals(HobbyEnum.class))
        {
            return sortByHobby();
        }
        else if (enumClass.equals(RegionEnum.class))
        {
            return sortByRegion();
        }
        else if (enumClass.equals(MajorEnum.class))
        {
            return sortByMajor();
        }
        else
        {
            return null;
        }
    }


    public String getArtist()
    {
        return artist;
    }


    public String getTitle()
    {
        return title;
    }


    public String getGenre()
    {
        return genre;
    }


    public String getDate()
    {
        return date;
    }


    public LinkedList<Person> getHeardList()
    {
        return heardList;
    }


    public LinkedList<Person> getLikedList()
    {
        return likedList;
    }


    public String toString()
    {
        return title + " by " + artist + ", " + genre + "; " + date;
    }


    public int[][] sortByHobby()
    {
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

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getHobby() != null)
            {
                switch (temp.getHobby())
                {
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
                }
            }
        }

        iter = likedList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getHobby() != null)
            {
                switch (temp.getHobby())
                {
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
                }

            }
        }
        int[] hHTotal = PersonList.getHobbyHTotal(id);
        int[] hLTotal = PersonList.getHobbyLTotal(id);

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


    public int[][] sortByRegion()
    {
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

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getRegion() != null)
            {
                switch (temp.getRegion())
                {
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
                }

            }
        }

        iter = likedList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getRegion() != null)
            {
                switch (temp.getRegion())
                {
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
                }

            }
        }

        int[] rHTotal = PersonList.getRegionHTotal(id);
        int[] rLTotal = PersonList.getRegionLTotal(id);

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


    public int[][] sortByMajor()
    {
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

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getMajor() != null)
            {
                switch (temp.getMajor())
                {
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
                }

            }
        }

        iter = likedList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (temp.getMajor() != null)
            {
                switch (temp.getMajor())
                {
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
                }

            }
        }

        int[] mHTotal = PersonList.getMajorHTotal(id);
        int[] mLTotal = PersonList.getMajorLTotal(id);

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
