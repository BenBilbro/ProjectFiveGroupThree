/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public enum Hobby {
    READING, SPORTS, MUSIC, ART;

    public static Hobby getHobby(String str) {
        if (str.equalsIgnoreCase("reading")) {
            return READING;
        }
        if (str.equalsIgnoreCase("sports")) {
            return SPORTS;
        }
        if (str.equalsIgnoreCase("music")) {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("art")) {
            return ART;
        }
        return null;
    }
}
