public class TrainLine {

    /**
     * The name of the trainline
     */
    private String name;
    /**
     * Points to the first station in the trainline
     */
    private TrainStation head;
    /**
     * Points to the last station in the trainline
     */
    private TrainStation tail;
    /**
     * Keeps a running tally of train stations in the trainline
     */
    private int numberOfStations;

    /**
     * Full constructor
     */
    public TrainLine(String name, TrainStation head) {
        this.name = name;
        this.head = head;
        this.numberOfStations = 0;
        if (this.head != null) {
            // If head is not null, there is one station in the line
            this.numberOfStations = 1;
        }
        // At initialization head and tail point to the same station even if null
        this.tail = null;
    } // full constructor

    /**
     * Basic constructor
     */
    public TrainLine(String name) {
        this(name, null);
    } // basic constructor

    /**
     * Creates a new station with the given name and adds it to the end of the line.
     */
    public void add(String name) {
        // Create the new station to add
        TrainStation newStation = new TrainStation(name);
        // Determine where to place the new station
        if (this.head == null) {
            // Trainline is empty, make new station the head of the line
            this.head = newStation;
        } else {
            // When there is a head station already, add the new station after the last
            // station in the line.
            this.tail.setNext(newStation);
        }
        // The new station becomes the tail station of the line
        this.tail = newStation;
        // Update station count
        this.numberOfStations++;
    } // method add

    /**
     * Returns the number of stations in the line >= 0
     */
    public int getNumberOfStations() {
        return numberOfStations;
    } // method getNumberOfStations

    public TrainStation remove(int position) {
        TrainStation removedStation = null;
        if (position >= 1 && position <= this.numberOfStations) {
            // Commence safe operations
            if (position == 1) {
                // Remove head
                removedStation = this.head;
                this.head = this.head.getNext();
            } else {
                // Find the station prior to the one to be removed
                TrainStation cursor = this.head;
                for (int i = 1; i < position - 1; i++) {
                    cursor = cursor.getNext();
                }
                // cursor should be at the prior station
                if (cursor.getNext() == this.tail) {
                    this.tail = cursor;
                }
                removedStation = cursor.getNext();
                cursor.setNext(cursor.getNext().getNext());
            }
            this.numberOfStations--;
            removedStation.setNext(null);
        }
        return removedStation;
    }

    public void insert(String name, int position) {
        // Create new station to be inserted
        TrainStation newStation = new TrainStation(name);

        // Handle insertion at the head
        if (position == 1) {
            newStation.setNext(this.head);
            this.head = newStation;
        } else {
            // Traverse the list to find the station prior to the insert point.
            TrainStation current = this.head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            // Insert the new station and adjust the next pointers
            newStation.setNext(current.getNext());
            current.setNext(newStation);

            // If inserted at the end, update the tail
            if (newStation.getNext() == null) {
                this.tail = newStation;
            }
        }
        // Upadate the station count
        this.numberOfStations++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Hold Final Output
        StringBuilder line1 = new StringBuilder(); // Main Line
        StringBuilder line2 = new StringBuilder(); // Second line and arrows
        // Start at the head of the train station
        TrainStation current = this.head;
        boolean movingRight = true;
        int characterCount = 0;
        // Loop through all stations
        while (current != null) {
            String stationName = current.getName();

            // Check if adding the station exceeds 80 characters
            if (characterCount + stationName.length() + 5 > 80) { // +5 for " --> " or " <-- "
                // Switch direction and go to the next line
                if (movingRight) {
                    line1.append("--+\\\n");
                    // Create spaces based on the length of the last line
                    int spaceCount = line1.length() - 5; // -5 for "--+\\"
                } else {
                    line1.append("--+\n");
                    int spaceCount = line1.length(); // Align with the last line
                    line2.append(" ".repeat(spaceCount)).append("+-- ");
                }
                characterCount = 0; // Reset count for new line
                movingRight = !movingRight; // Toggle direction
            }

            // Append the station name and arrow based on direction
            if (movingRight) {
                line1.append(stationName).append(" --> ");
            } else {
                line1.append(stationName).append(" <-- ");
            }
            characterCount += stationName.length() + 5;

            current = current.getNext();
        }

        // Remove the last arrow and add the final line end
        if (line1.length() > 0) {
            line1.setLength(line1.length() - 5); // Remove the last arrow
        }

        sb.append("         1         2         3         4         5         6         7         8\n");
        sb.append("12345678901234567890123456789012345678901234567890123456789012345678901234567890\n");
        sb.append(line1).append("--+\n");

        // Ensure the vertical line appears immediately after line1
        sb.append(line2);

        return sb.toString();
    }


    public static void main(String[] args) {
        // A few station names
        String[] stationNames = {"Howard", "Jarvis", "Morse", "Loyola", "Granville", "Thorndale"};
        // A populated trainline
        TrainLine redLineSB = new TrainLine("Red Line SB");
        for (String station : stationNames) {
            redLineSB.add(station);
        }
        // An empty trainline
        TrainLine brownLineSB = new TrainLine("Brown Line SB");
        // A random station name
        String randomName = "Oak Park";

        // Print the line before adding stations
        System.out.println(redLineSB);

        // Add a Branch to the line
        redLineSB.insert("Bryn Mawr", 7);
        redLineSB.insert("Argyle", 8);
        redLineSB.insert("Wilson", 9);
        redLineSB.insert("Sheradian", 10);
        redLineSB.insert("Addison", 11);

        // Print the new line with the added stations
        System.out.println(redLineSB.toString());
    } // method main
} // class TrainLine