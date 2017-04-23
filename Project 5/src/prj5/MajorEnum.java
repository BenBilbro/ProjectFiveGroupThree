/**
 * 
 */
package prj5;

/**
 * This class is meant to assist with getting the specified major of each Person
 * object
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 *
 */
public enum MajorEnum {
    MATH_CMDA, COMP_SCI, OTHER_ENGE, OTHER, DEFAULT; // default for testing

    /**
     * Checks the string passed for the correct major enumeration
     * 
     * @param str
     *            The string that will be checked for a specified hobby
     * @return The major that is needed if the string is not empty, otherwise
     *         null
     */
    public static MajorEnum getMajor(String str) {
        if (str.equalsIgnoreCase("Math or CMDA")) {
            return MATH_CMDA;
        }
        if (str.equals("Computer Science")) {
            return COMP_SCI;
        }
        if (str.equals("Other Engineering")) {
            return OTHER_ENGE;
        }
        if (str.equals("Other")) {
            return OTHER;
        }
        return null;
    }
}
