/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public enum Region {
    NORTHEAST, SOUTHEAST, OTHER_US, OUTSIDE_US;

    public static Region getRegion(String str) {
        if (str.equalsIgnoreCase("Northeast")) {
            return NORTHEAST;
        }
        if (str.equalsIgnoreCase("Southeast")) {
            return SOUTHEAST;
        }
        if (str.equalsIgnoreCase(
            "United States (other than Southeast or Northwest)")) {
            return OTHER_US;
        }
        if (str.equalsIgnoreCase("Outside of United States")) {
            return OUTSIDE_US;
        }
        return null;
    }
}
