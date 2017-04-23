package prj5;

/**
 * class that tests getRegion
 * 
 * @author Ben Bilbro (benb16), Sean Seth (ssean7), Tej Patel (tej0126)
 * @version 04.19.17
 */
public class RegionEnumTest extends student.TestCase {
    /**
     * tests to make sure that the correct RegionEnums are returned per calls to
     * getRegion()
     */
    public void testGetRegion() {
        assertEquals(RegionEnum.NORTHEAST, RegionEnum.getRegion("Northeast"));
        assertEquals(RegionEnum.SOUTHEAST, RegionEnum.getRegion("Southeast"));
        assertEquals(RegionEnum.OTHER_US, RegionEnum.getRegion(
            "United States (other than Southeast or Northwest)"));
        assertEquals(RegionEnum.OUTSIDE_US, RegionEnum.getRegion(
            "Outside of United States"));
        assertNull(RegionEnum.getRegion("yolo"));
    }
}
