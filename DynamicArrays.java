// A simple class to demonstrate dynamic behavior with arrays. Objects of this
// class store strings in an array that grows to match the demand for storage.

// The class is based on an underlying string array. Objects can be initialized
// to any size; otherwise they'll be initialized to the default size. For
// example,

// DynamicArray da1 = new DynamicArray(10);

// will have initially room for 10 strings, while

// DynamicArray da2 = new DynamicArray();

// will have initially room for 4 strings.

public class DynamicArrays {

    // Default size for underlying array */
    private static final int DEFAULT_SIZE = 4;

    // The underlying array for this class */
    private final String[] foundation;

    // How many positions in the foundation array are used? */
    private final int occupancy;


    // Full constructor.
    // Initializes the underlying array to the specified size. If the size is <= 0,
    // the default size is used instead. This ensures we always have a valid array
    // with positive size.

    public DynamicArrays(int size) {
        // If size <= 0 use default -- demonstrates the use of a ternary operator.
        size = (size > 0) ? size : DEFAULT_SIZE;
        this.foundation = new String[size];
        this.occupancy = 0;  // Initially, no elements are in use.
    }


    // Array-based constructor -- initializes the foundation array with a given array.
    // The occupancy is set to the length of the provided array if it's non-null.
    // This constructor is useful for testing or initializing from an existing array.

    public DynamicArrays(String[] data) {
        this.foundation = data;  // Directly assign the provided array.
        this.occupancy = (data != null) ? data.length : 0;  // Occupancy is set based on the length of the array.
    }

    // Default constructor.
    // Uses the default size for the foundation array when no size is provided.
    public DynamicArrays() {
        this(DEFAULT_SIZE);
    }


    // Check if the foundation array or the target string is null.
    // Initializes a variable to track if the target is found
    // Checks if the foundation array or target is null
    // Loops through the used part of the array
    // Check if the current element matches the target string
    // Sets found to true if a match is found
    // Return the result of the search

    public boolean contains(String target) {
        boolean found = false;

        if (foundation != null && target != null) {
            for (int i = 0; i < occupancy && !found; i++) {
                if (foundation[i] != null && foundation[i].equals(target)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }


    // Retrieves the string from the foundation array at the specified index.
    // Initializes a variable to hold the result
    // Checks if the foundation array is not null and the index is valid
    // Assigns the value at the given index to the result variable
    // Returns the result, which is either null or the string at the index
    public String get(int index) {
        String result = null;

        if (foundation != null && index >= 0 && index < occupancy) {
            result = foundation[index];
        }

        return result;
    }


    // Driver/test code.
    // Runs basic tests to check the functionality of the contains and get methods.
    public static void main(String[] args) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        final String NON_EXISTING = "COBOL";

        // Test data - sample strings to test the DynamicArray.
        String[] testData = {"Java", "Python", "C", "C++", "Fortran"};

        // Creating DynamicArray objects for testing.
        DynamicArrays test = new DynamicArrays(testData);  // Using test data.
        DynamicArrays tset = new DynamicArrays(null);  // Null array test.

        // Simple test cases for the contains and get methods.
        // Testing for 'null' in contains (should return false).
        String testContainsNullTarget = (!test.contains(null)) ? PASS : FAIL;

        // Testing contains on an empty/null foundation array.
        String testContainsEmptyData = (!tset.contains("Java")) ? PASS : FAIL;

        // Testing contains for an existing element (should return true).
        String testContainsExisting = (test.contains(testData[1])) ? PASS : FAIL;

        // Testing contains for a non-existing element (should return false).
        String testContainsNonExisting = (!test.contains(NON_EXISTING)) ? PASS : FAIL;

        // Testing get with an invalid (negative) index (should return null).
        String testGetNegative = (test.get(-1) == null) ? PASS : FAIL;

        // Testing get with a valid index (should return the correct element).
        String testGet = (test.get(0).equals(testData[0])) ? PASS : FAIL;

        // Testing get with an out-of-bounds index (should return null).
        String testGetOutOfBounds = (test.get(testData.length + 1) == null) ? PASS : FAIL;

        // Print results of the test cases.
        System.out.printf("\nTest for contains(null): ............... %s", testContainsNullTarget);
        System.out.printf("\nTest for contains on null foundation: .. %s", testContainsEmptyData);
        System.out.printf("\nTest for contains (existing): .......... %s", testContainsExisting);
        System.out.printf("\nTest for contains (non existing): ...... %s", testContainsNonExisting);
        System.out.printf("\nTest for get(-1): ...................... %s", testGetNegative);
        System.out.printf("\nTest for get(0): ....................... %s", testGet);
        System.out.printf("\nTest for get(out of bounds): ........... %s\n\n", testGetOutOfBounds);
    }
}
