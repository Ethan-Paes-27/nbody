/**
 * Tests the Planet constructor.
 */
public class TestPlanetConstructor {

    /**
     * Tests the Planet constructor to make sure it's working correctly.
     */
    public static void main(String[] args) {
        checkPlanetConstructor();
    }

    /**
     * Checks whether or not two Doubles are equal and prints the result.
     *
     * @param expected Expected double
     * @param actual   Double received
     * @param label    Label for the 'test' case
     */
    private static void checkEquals(double expected, double actual, String label) {
        if (expected == actual) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     * Checks whether or not two Strings are equal and prints the result.
     *
     * @param expected Expected String
     * @param actual   String received
     * @param label    Label for the 'test' case
     */
    private static void checkStringEquals(String expected, String actual, String label) {
        if (expected.equals(actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     * Checks Planet constructors to make sure they are setting instance
     * variables correctly.
     */
    private static void checkPlanetConstructor() {
        System.out.println("Checking Planet constructor...");
    }
}
