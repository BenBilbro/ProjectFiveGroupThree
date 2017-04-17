/**
 * 
 */
package prj5;

/**
 * @author benzb
 *
 */
public enum Major {
    MATH_CMDA, COMP_SCI, OTHER_ENGE, OTHER;

    public static Major getMajor(String str) {
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
