package Interfaces;


import java.util.Random;

public class Person implements Comparable<Person>, SillyActions {

    private static final String DEFAULT_LAST_NAME = "LNU";
    private static final String DEFAULT_FIRST_NAME = "FNU";
    private static final int DEFAULT_YEAR_BORN = 1800;

    private String firstName;
    private String lastName;
    private int yearBorn;

    public Person(String firstName, String lastName, int yearBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBorn = yearBorn;
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /**
     * Default constructor
     */
    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_YEAR_BORN);
    }

    /**
     * Implements the Comparable interface to determine the relative order of two
     * persons based on their age.
     */
    public int compareTo(Person other) {
        return other.getYearBorn() - this.yearBorn;
    } // method compareTo

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn + "]";
    } // method toString

    //------------------- AUTO GENERATED METHODS ------------------------------

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getYearBorn() {
        return this.yearBorn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    // ------------------- SillyActions Methods -------------------------

    /**
     * Make a random sound by selecting a word from PoemWords.words.
     */

    public void makeRandomSound() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(PoemWords.words.length);
        System.out.println("Random sound: " + PoemWords.words[randomIndex]);
    }

    /**
     * Perform a silly dance by describing random steps.
     */

    public void performSillyDance() {
        System.out.println("Silly dance steps: Step left, step right, spin around, jump!");
    }

    /**
     * Recite the alphabet backwards, skipping a random letter.
     */

    public String reciteAlphabetBackwards() {
        String alphabet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        Random rand = new Random();
        int skipIndex = rand.nextInt(alphabet.length());
        return alphabet.substring(0, skipIndex) + alphabet.substring(skipIndex + 1);
    }

    /**
     * Count to ten in a quirky way by skipping some numbers.
     */

    public void countToTenWeirdly() {
        System.out.println("1, 2, 4, 5, 7, 8, 10! (Skipped some numbers!)");
    }

    /**
     * Create a whimsical poem using random words from PoemWords.words.
     */

    public String createWhimsicalPoem(String topic) {
        Random rand = new Random();
        StringBuilder poem = new StringBuilder("Ode to " + topic + ",\n");
        for (int i = 0; i < 5; i++) {
            poem.append(PoemWords.words[rand.nextInt(PoemWords.words.length)]).append(" ");
        }
        poem.append("\nSuch is life.");
        return poem.toString();
    }

    /**
     * Generate six random lottery numbers between 1 and 50.
     */

    public void winStateLottery() {
        Random rand = new Random();
        System.out.print("Lottery numbers: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(rand.nextInt(50) + 1 + " ");
        }
        System.out.println();
    }
}
