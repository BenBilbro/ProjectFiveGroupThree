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
    public static LinkedList<Person> heardList;
    public static LinkedList<Person> likedList;


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


    public static int[][] getResults(Class<?> enumClass) {
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


    public static int[][] sortByHobby() {
        int readH = 0;
        int artH = 0;
        int musicH = 0;
        int sportH = 0;
        int readL = 0;
        int artL = 0;
        int musicL = 0;
        int sportL = 0;
        int[][] hobbyArr = new int[2][4];

        Node<Person> curr = heardList.head;
        while (curr != null) {
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
            curr = curr.next;
        }
        curr = likedList.head;
        while (curr != null) {
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
            curr = curr.next;
        }

        hobbyArr[0][0] = readH;
        hobbyArr[0][1] = artH;
        hobbyArr[0][2] = musicH;
        hobbyArr[0][3] = sportH;
        hobbyArr[1][0] = readL;
        hobbyArr[1][1] = artL;
        hobbyArr[1][2] = musicL;
        hobbyArr[1][3] = sportL;

        return hobbyArr;
    }


    public static int[][] sortByRegion() {
        int northWH = 0;
        int southEH = 0;
        int otherH = 0;
        int outH = 0;
        int northWL = 0;
        int southEL = 0;
        int otherL = 0;
        int outL = 0;
        int[][] regionArr = new int[2][4];

        Node<Person> curr = heardList.head;
        while (curr != null) {
            switch (curr.getData().getRegion()) {
                case NORTHEAST:
                    northWH++;
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
            curr = curr.next;
        }
        curr = likedList.head;
        while (curr != null) {
            switch (curr.getData().getRegion()) {
                case NORTHEAST:
                    northWL++;
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
            curr = curr.next;
        }

        regionArr[0][0] = northWH;
        regionArr[0][1] = southEH;
        regionArr[0][2] = otherH;
        regionArr[0][3] = outH;
        regionArr[1][0] = northWL;
        regionArr[1][1] = southEL;
        regionArr[1][2] = otherL;
        regionArr[1][3] = outL;

        return regionArr;

    }


    public static int[][] sortByMajor() {
        int mathH = 0;
        int compSciH = 0;
        int otherEngeH = 0;
        int otherH = 0;
        int mathL = 0;
        int compSciL = 0;
        int otherEngeL = 0;
        int otherL = 0;
        int[][] majorArr = new int[2][4];

        Node<Person> curr = heardList.head;
        while (curr != null) {
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
            curr = curr.next;
        }
        curr = likedList.head;
        while (curr != null) {
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
            curr = curr.next;
        }

        majorArr[0][0] = mathH;
        majorArr[0][1] = compSciH;
        majorArr[0][2] = otherEngeH;
        majorArr[0][3] = otherH;
        majorArr[1][0] = mathL;
        majorArr[1][1] = compSciL;
        majorArr[1][2] = otherEngeL;
        majorArr[1][3] = otherL;

        return majorArr;
    }

}
