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
 * @version 4.11.17
 */
public class Person {

    private String[] responses;
    private Major major;
    private Hobby hobby;
    private Region region;


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
    public Person(Major major, Hobby hobby, Region region, String[] responses) {
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
    public Major getMajor() {
        return this.major;
    }


    /**
     * Getter method for hobby
     * 
     * @return Hobby enum of the persons hobby
     */
    public Hobby getHobby() {
        return this.hobby;
    }


    /**
     * Getter method for region
     * 
     * @return Region enum of the persons region
     */
    public Region getRegion() {
        return this.region;
    }


    /**
     * Getter method for responses
     * 
     * @return String[] array of responses to songs
     */
    public String[] getResponses() {
        return this.responses;
    }

}
