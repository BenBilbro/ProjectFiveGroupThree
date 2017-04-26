/**
 * 
 */
package prj5;

/**
 * This class is meant to assist with getting the specified region of each
 * Person object
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public enum RegionEnum {
    NORTHEAST, SOUTHEAST, OTHER_US, OUTSIDE_US, DEFAULT; // default for testing

    /**
     * Checks the string passed for the correct region enumeration
     * 
     * @param str
     *            The string that will be checked for a specified hobby
     * @return The region that is needed if the string is not empty, otherwise
     *         null
     */
    public static RegionEnum getRegion(String str) {
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
