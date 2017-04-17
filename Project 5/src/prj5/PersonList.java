/**
 * 
 */
package prj5;

import prj5.LinkedList.Node;

/**
 * @author benzb
 *
 */
public class PersonList extends LinkedList<Person> {

    private static LinkedList<Person> pList;


    public PersonList(LinkedList<Person> pList) {
        this.pList = pList;
    }


    public static int[] getHobbyHTotal(int id) {
        int read = 0;
        int art = 0;
        int music = 0;
        int sport = 0;
        int[] hobbyTotal = new int[4];

        Node<Person> curr = pList.getHead();
        while (curr != null) {
            if (!curr.getData().getHeard(id).equals(" ")) {
                if (curr.getData().getHobby() != null) {
                    switch (curr.getData().getHobby()) {
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
            curr = curr.getNext();
        }
        hobbyTotal[0] = read;
        hobbyTotal[1] = art;
        hobbyTotal[2] = sport;
        hobbyTotal[3] = music;
        return hobbyTotal;
    }


    public static int[] getHobbyLTotal(int id) {
        int read = 0;
        int art = 0;
        int music = 0;
        int sport = 0;
        int[] hobbyTotal = new int[4];

        Node<Person> curr = pList.getHead();
        while (curr != null) {
            if (!curr.getData().getLiked(id).equals(" ")) {
                if (curr.getData().getHobby() != null) {
                    switch (curr.getData().getHobby()) {
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
            curr = curr.getNext();
        }
        hobbyTotal[0] = read;
        hobbyTotal[1] = art;
        hobbyTotal[2] = sport;
        hobbyTotal[3] = music;

        return hobbyTotal;
    }


    public static int[] getMajorHTotal(int id) {
        int math = 0;
        int compSci = 0;
        int otherEnge = 0;
        int other = 0;
        int[] majorTotal = new int[4];

        Node<Person> curr = pList.getHead();
        while (curr != null) {
            if (!curr.getData().getHeard(id).equals(" ")) {
                if (curr.getData().getMajor() != null) {
                    switch (curr.getData().getMajor()) {
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
            curr = curr.getNext();
        }
        majorTotal[0] = math;
        majorTotal[1] = compSci;
        majorTotal[2] = otherEnge;
        majorTotal[3] = other;

        return majorTotal;
    }


    public static int[] getMajorLTotal(int id) {
        int math = 0;
        int compSci = 0;
        int otherEnge = 0;
        int other = 0;
        int[] majorTotal = new int[4];

        Node<Person> curr = pList.getHead();
        while (curr != null) {
            if (!curr.getData().getLiked(id).equals(" ")) {
                if (curr.getData().getMajor() != null) {
                    switch (curr.getData().getMajor()) {
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
            curr = curr.getNext();
        }
        majorTotal[0] = math;
        majorTotal[1] = compSci;
        majorTotal[2] = otherEnge;
        majorTotal[3] = other;

        return majorTotal;
    }


    public static int[] getRegionHTotal(int id) {
        int northW = 0;
        int southE = 0;
        int other = 0;
        int out = 0;
        int[] regionTotal = new int[4];

        Node<Person> curr = pList.getHead();
        while (curr != null) {
            if (!curr.getData().getHeard(id).equals(" ")) {
                if (curr.getData().getRegion() != null) {
                    switch (curr.getData().getRegion()) {
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
            curr = curr.getNext();
        }
        regionTotal[0] = northW;
        regionTotal[1] = southE;
        regionTotal[2] = other;
        regionTotal[3] = out;

        return regionTotal;
    }


    public static int[] getRegionLTotal(int id) {
        int northW = 0;
        int southE = 0;
        int other = 0;
        int out = 0;
        int[] regionTotal = new int[4];

        Node<Person> curr = pList.getHead();
        while (curr != null) {
            if (!curr.getData().getLiked(id).equals(" ")) {
                if (curr.getData().getRegion() != null) {
                    switch (curr.getData().getRegion()) {
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
            curr = curr.getNext();
        }
        regionTotal[0] = northW;
        regionTotal[1] = southE;
        regionTotal[2] = other;
        regionTotal[3] = out;

        return regionTotal;
    }
}
