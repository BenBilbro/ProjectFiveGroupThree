/**
 * 
 */
package prj5;

/**
 * @author Ben Bilbro
 *
 */
public class Song extends LinkedList<Person> {

    public int id;
    private String artist;
    private String genre;
    private String title;
    private String date;
    private LinkedList<Person> heardList;
    private LinkedList<Person> likedList;


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


    public int[][] getResults(Class<?> enumClass) {
        if (enumClass.equals(Hobby.class)) {
            return sortByHobby();
        }
        else if (enumClass.equals(Region.class)) {
            return sortByRegion();
        }
        else if (enumClass.equals(Major.class)) {
            return sortByMajor();
        }

        return null;
    }


    public String getArtist() {
        return artist;
    }


    public String getTitle() {
        return title;
    }


    public String getGenre() {
        return genre;
    }


    public String getDate() {
        return date;
    }


    public LinkedList<Person> getHeardList() {
        return heardList;
    }


    public LinkedList<Person> getLikedList() {
        return likedList;
    }


    public String toString() {
        return title + " by " + artist + ", " + genre + "; " + date;
    }


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

        Node<Person> curr = heardList.getHead();
        while (curr != null) {
            if (curr.getData().getHobby() != null) {
                switch (curr.getData().getHobby()) {
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
            curr = curr.getNext();
        }
        curr = likedList.getHead();
        while (curr != null) {
            if (curr.getData().getHobby() != null) {
                switch (curr.getData().getHobby()) {
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
            curr = curr.getNext();
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

        Node<Person> curr = heardList.getHead();
        while (curr != null) {
            if (curr.getData().getRegion() != null) {
                switch (curr.getData().getRegion()) {
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
            curr = curr.getNext();
        }
        curr = likedList.getHead();
        while (curr != null) {
            if (curr.getData().getRegion() != null) {
                switch (curr.getData().getRegion()) {
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
            curr = curr.getNext();
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

        Node<Person> curr = heardList.getHead();
        while (curr != null) {
            if (curr.getData().getMajor() != null) {
                switch (curr.getData().getMajor()) {
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
            curr = curr.getNext();
        }
        curr = likedList.getHead();
        while (curr != null) {
            if (curr.getData().getMajor() != null) {
                switch (curr.getData().getMajor()) {
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
            curr = curr.getNext();
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
