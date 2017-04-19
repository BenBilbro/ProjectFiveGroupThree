/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * This class contains the implementation using a list of people to calculate
 * the number of people who have heard and liked a song for each attribute
 * 
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public class PersonList
{

    private static LinkedList<Person> pList;


    /**
     * Creates a new PersonList
     * 
     * @param personList
     *            A list of all of the valid people in the parsed data
     */
    public PersonList(LinkedList<Person> personList)
    {
        pList = personList;
    }


    /**
     * Calculates the number of people in each hobby that have heard a certain
     * song
     * 
     * @param id
     *            A specified song's identification number
     * @return an array of four integers that contains the totals for the number
     *         of people who have heard the specified song for each hobby
     */
    public static int[] getHobbyHTotal(int id)
    {
        int read = 0;
        int art = 0;
        int music = 0;
        int sport = 0;
        int[] hobbyTotal = new int[4];
        Iterator<Person> iter = pList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (!temp.getHeard(id).equals(" "))
            {
                if (temp.getHobby() != null)
                {
                    switch (temp.getHobby())
                    {
                        case READING:
                            read++;
                            break;
                        case ART:
                            art++;
                            break;
                        case MUSIC:
                            music++;
                            break;
                        case SPORTS:
                            sport++;
                            break;
                    }
                }
            }
        }
        hobbyTotal[0] = read;
        hobbyTotal[1] = art;
        hobbyTotal[2] = sport;
        hobbyTotal[3] = music;
        return hobbyTotal;
    }


    /**
     * Calculates the number of people in each hobby that have liked a certain
     * song
     * 
     * @param id
     *            A specified song's identification number
     * @return an array of four integers that contains the totals for the number
     *         of people who have liked the specified song for each hobby
     */
    public static int[] getHobbyLTotal(int id)
    {
        int read = 0;
        int art = 0;
        int music = 0;
        int sport = 0;
        int[] hobbyTotal = new int[4];

        Iterator<Person> iter = pList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (!temp.getLiked(id).equals(" "))
            {
                if (temp.getHobby() != null)
                {
                    switch (temp.getHobby())
                    {
                        case READING:
                            read++;
                            break;
                        case ART:
                            art++;
                            break;
                        case MUSIC:
                            music++;
                            break;
                        case SPORTS:
                            sport++;
                            break;
                    }
                }
            }
        }
        hobbyTotal[0] = read;
        hobbyTotal[1] = art;
        hobbyTotal[2] = sport;
        hobbyTotal[3] = music;

        return hobbyTotal;
    }


    /**
     * Calculates the number of people in each major that have heard a certain
     * song
     * 
     * @param id
     *            A specified song's identification number
     * @return an array of four integers that contains the totals for the number
     *         of people who have heard the specified song for each major
     */
    public static int[] getMajorHTotal(int id)
    {
        int math = 0;
        int compSci = 0;
        int otherEnge = 0;
        int other = 0;
        int[] majorTotal = new int[4];
        Iterator<Person> iter = pList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (!temp.getHeard(id).equals(" "))
            {
                if (temp.getMajor() != null)
                {
                    switch (temp.getMajor())
                    {
                        case MATH_CMDA:
                            math++;
                            break;
                        case COMP_SCI:
                            compSci++;
                            break;
                        case OTHER_ENGE:
                            otherEnge++;
                            break;
                        case OTHER:
                            other++;
                            break;
                    }
                }
            }
        }

        majorTotal[0] = math;
        majorTotal[1] = compSci;
        majorTotal[2] = otherEnge;
        majorTotal[3] = other;

        return majorTotal;
    }


    /**
     * Calculates the number of people in each major that have liked a certain
     * song
     * 
     * @param id
     *            A specified song's identification number
     * @return an array of four integers that contains the totals for the number
     *         of people who have liked the specified song for each major
     */
    public static int[] getMajorLTotal(int id)
    {
        int math = 0;
        int compSci = 0;
        int otherEnge = 0;
        int other = 0;
        int[] majorTotal = new int[4];

        Iterator<Person> iter = pList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (!temp.getLiked(id).equals(" "))
            {
                if (temp.getMajor() != null)
                {
                    switch (temp.getMajor())
                    {
                        case MATH_CMDA:
                            math++;
                            break;
                        case COMP_SCI:
                            compSci++;
                            break;
                        case OTHER_ENGE:
                            otherEnge++;
                            break;
                        case OTHER:
                            other++;
                            break;
                    }
                }
            }
        }
        majorTotal[0] = math;
        majorTotal[1] = compSci;
        majorTotal[2] = otherEnge;
        majorTotal[3] = other;

        return majorTotal;
    }


    /**
     * Calculates the number of people in each region that have heard a certain
     * song
     * 
     * @param id
     *            A specified song's identification number
     * @return an array of four integers that contains the totals for the number
     *         of people who have heard the specified song for each region
     */
    public static int[] getRegionHTotal(int id)
    {
        int northW = 0;
        int southE = 0;
        int other = 0;
        int out = 0;
        int[] regionTotal = new int[4];
        Iterator<Person> iter = pList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (!temp.getHeard(id).equals(" "))
            {
                if (temp.getRegion() != null)
                {
                    switch (temp.getRegion())
                    {
                        case NORTHEAST:
                            northW++;
                            break;
                        case SOUTHEAST:
                            southE++;
                            break;
                        case OTHER_US:
                            other++;
                            break;
                        case OUTSIDE_US:
                            out++;
                            break;
                    }
                }
            }
        }
        regionTotal[0] = northW;
        regionTotal[1] = southE;
        regionTotal[2] = other;
        regionTotal[3] = out;

        return regionTotal;
    }


    /**
     * Calculates the number of people in each region that have liked a certain
     * song
     * 
     * @param id
     *            A specified song's identification number
     * @return an array of four integers that contains the totals for the number
     *         of people who have liked the specified song for each region
     */
    public static int[] getRegionLTotal(int id)
    {
        int northW = 0;
        int southE = 0;
        int other = 0;
        int out = 0;
        int[] regionTotal = new int[4];

        Iterator<Person> iter = pList.iterator();

        while (iter.hasNext())
        {
            Person temp = iter.next();
            if (!temp.getLiked(id).equals(" "))
            {
                if (temp.getRegion() != null)
                {
                    switch (temp.getRegion())
                    {
                        case NORTHEAST:
                            northW++;
                            break;
                        case SOUTHEAST:
                            southE++;
                            break;
                        case OTHER_US:
                            other++;
                            break;
                        case OUTSIDE_US:
                            out++;
                            break;
                    }
                }
            }
        }
        regionTotal[0] = northW;
        regionTotal[1] = southE;
        regionTotal[2] = other;
        regionTotal[3] = out;

        return regionTotal;
    }
}
