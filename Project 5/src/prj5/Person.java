/**
 * 
 */
package prj5;

/**
 * Class for a person. Each person holds data on themselves and their responses
 * to all of the songs
 * 
 * @author Ben Bilbro
 *
 * @version 04.19.17
 */
public class Person
{

    private String[] responses;
    private MajorEnum major;
    private HobbyEnum hobby;
    private RegionEnum region;


    /**
     * Constructor for person that initializes all field variables
     * 
     * @param major
     *            enum passed in to represent the persons major
     * @param hobby
     *            enum passed in to represent the persons hobby
     * @param region
     *            enum passed in to represent the persons region
     * @param responses
     *            array of strings of the persons responses to songs
     */
    public Person(
        MajorEnum major,
        RegionEnum region,
        HobbyEnum hobby,
        String[] responses)
    {
        this.major = major;
        this.hobby = hobby;
        this.region = region;
        this.responses = responses;
    }


    /**
     * Getter method for major
     * 
     * @return Major enum of the persons major
     */
    public MajorEnum getMajor()
    {
        return this.major;
    }


    /**
     * Getter method for hobby
     * 
     * @return Hobby enum of the persons hobby
     */
    public HobbyEnum getHobby()
    {
        return this.hobby;
    }


    /**
     * Getter method for region
     * 
     * @return Region enum of the persons region
     */
    public RegionEnum getRegion()
    {
        return this.region;
    }


    /**
     * Getter method for responses
     * 
     * @return String[] array of responses to songs
     */
    public String[] getResponses()
    {
        return this.responses;
    }


    /**
     * Helper method for FileRead to determine if a person has heard song
     * 
     * @param id
     *            song Id to check for heard
     * @return boolean true or false
     */
    public String getHeard(int id)
    {
        if (responses.length > id)
        {
            String[] strArr = responses[id].split(",");
            return strArr[0];
        }
        return "";
    }


    /**
     * helper method for FileReader to determine if a person has liked song
     * 
     * @param id
     *            song ID to check for liked
     * @return boolean true or false
     */
    public String getLiked(int id)
    {
        if (responses.length > id)
        {
            String[] strArr = responses[id].split(",");
            return strArr[1];
        }
        return "";
    }

}
