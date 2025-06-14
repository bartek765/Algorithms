public class MyCalendarTwo {
  
    // Use TreeMap to automatically keep the keys sorted
    private Map<Integer, Integer> timeMap = new TreeMap<>();

    // Default constructor (not explicitly needed unless more constructors are provided)
    public MyCalendarTwo() {
    }

    // Function to book a new event from start to end time
    public boolean book(int start, int end) {
        // Increase the counter at the start time
        timeMap.put(start, timeMap.getOrDefault(start, 0) + 1);

        // Decrease the counter at the end time
        timeMap.put(end, timeMap.getOrDefault(end, 0) - 1);

        int activeEvents = 0; // This will track the number of ongoing events

        // Iterate through the values in TreeMap
        for (int eventsCount : timeMap.values()) {
            // Increment the count of active events
            activeEvents += eventsCount;

            // If at any point there are more than 2 active events, this booking overlaps with two other events
            if (activeEvents > 2) {
                // The booking is not possible, so revert the changes
                timeMap.put(start, timeMap.get(start) - 1);
                timeMap.put(end, timeMap.get(end) + 1);

                // Return false as the booking overlaps and cannot be accepted
                return false;
            }
        }
        // The booking does not overlap with two or more events, so return true
        return true;
    }
}
