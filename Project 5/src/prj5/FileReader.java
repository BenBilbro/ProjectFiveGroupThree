/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Ben Bilbro (benzb), Sean Seth (ssean7), Tej Patel (tej0126)
 *
 */
public class FileReader extends LinkedList<Person> {

    private LinkedList<Glyph> gList;
    private LinkedList<Person> pList;
    private Scanner pReader;
    private Scanner mReader;
    private int rLength;


    public FileReader(String filePeople, String fileSongs) {

        rLength = getRLength(fileSongs);
        new ProjectWindow(parseSongs(fileSongs, parsePeople(filePeople)));

    }


    public LinkedList<Person> parsePeople(String file) {
        pList = new LinkedList<Person>();
        // MAJOR, REGION, HOBBY, RESPONSES
        try {
            pReader = new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
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
        int id = 1;
        while (pReader.hasNextLine()) {
            strArr = pReader.nextLine().split(",");
            if (strArr.length % 2 == 0) {
                String[] temp = new String[strArr.length + 1];
                for (int y = 0; y < strArr.length; y++) {
                    temp[y] = strArr[y];
                }
                temp[strArr.length] = "";
                strArr = temp;
            }

            if (strArr.length > 5) {
                major = MajorEnum.getMajor(strArr[2]);
                region = RegionEnum.getRegion(strArr[3]);
                hobby = HobbyEnum.getHobby(strArr[4]);
                if (hobby == null || major == null || region == null) {
                    continue;
                }
                responses = new String[rLength];
                for (int x = 0; x < rLength; x++) {
                    responses[x] = " , ";
                }

                for (int i = 5; i < strArr.length - 1; i += 2) {

                    if (strArr[i].equals("")) {
                        heard = " ";
                    }
                    else {
                        heard = strArr[i];
                    }
                    if (strArr[i + 1].equals("")) {
                        liked = " ";
                    }
                    else {
                        liked = strArr[i + 1];
                    }
                    responses[(i - 5) / 2] = heard + "," + liked;
                }
                tempPerson = new Person(id, major, region, hobby, responses);
                id++;
                pList.add(tempPerson);
            }

        }
        new PersonList(pList);
        
        return pList;
    }


    public LinkedList<Glyph> parseSongs(String file, LinkedList<Person> pList) {
        gList = new LinkedList<Glyph>();

        try {
            mReader = new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
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
        while (mReader.hasNextLine()) {
            strArr = mReader.nextLine().split(",");
            for (int i = 0; i < strArr.length; i += 5) {
                title = strArr[i];
                artist = strArr[i + 1];
                date = strArr[i + 2];
                genre = strArr[i + 3];
                heardList = makeHeardList(id, pList);
                likedList = makeLikedList(id, pList);
            }
            Song tempSong = new Song(id, artist, genre, title, date, heardList,
                likedList);
            Glyph tempGlyph = new Glyph(tempSong);
            gList.add(tempGlyph);

            id++;
        }
//        Object[] temp = gList.toArray();
//        for (Object o : temp) {
// int[] arr = PersonList.getHobbyHTotal(((Glyph)o).getSong().id);
// int[][] arr2 = ((Glyph)o).getSong().sortByHobby();
// System.out.println(((Glyph)o).getSong().getTitle() + " "
// + ((Glyph)o).getSong().getHeardList().getLength() + " "
// + ((Glyph)o).getSong().getLikedList().length);
//
//        }

        return gList;
    }


    public LinkedList<Person> makeHeardList(int id, LinkedList<Person> pList) {
        LinkedList<Person> hList = new LinkedList<Person>();
        
        Iterator<Person> iter = pList.iterator();
        while (iter.hasNext()) {
            Person temp = iter.next();
            if (temp.getHeard(id).equals("Yes")) {
                hList.add(temp);
            }
        }
        return hList;
    }


    public LinkedList<Person> makeLikedList(int id, LinkedList<Person> pList) {
        LinkedList<Person> LList = new LinkedList<Person>();
        Iterator<Person> iter = pList.iterator();
        while (iter.hasNext()) {
            Person temp = iter.next();
            if (temp.getLiked(id).equals("Yes")) {
                LList.add(temp);
            }
        }
        return LList;
    }


    public int getRLength(String str) {
        Scanner length = null;
        try {
            length = new Scanner(new File(str));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = -1;
        while (length.hasNextLine()) {
            length.nextLine();
            count++;
        }

        return count;
    }
}
