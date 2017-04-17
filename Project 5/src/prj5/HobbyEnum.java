/**
 * 
 */
package prj5;

/**
 * This class is meant to assist with getting the specified hobby of each Person
 * object
 * 
 * @author Ben Bilbro (benzb) Sean Seth (ssean7)
 *
 */
public enum HobbyEnum
{
    READING, SPORTS, MUSIC, ART;

    /**
     * Checks the string passed for the correct hobby enumeration
     * 
     * @param str
     *            The string that will be checked for a specified hobby
     * @return The hobby that is needed if the string is not empty, otherwise
     *         null
     */
    public static HobbyEnum getHobby(String str)
    {
        if (str.equalsIgnoreCase("reading"))
        {
            return READING;
        }
        if (str.equalsIgnoreCase("sports"))
        {
            return SPORTS;
        }
        if (str.equalsIgnoreCase("music"))
        {
            return MUSIC;
        }
        if (str.equalsIgnoreCase("art"))
        {
            return ART;
        }
        return null;
    }
}
