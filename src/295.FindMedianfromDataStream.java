class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap to store the larger half of the numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap to store the smaller half of the numbers

    /** Initialize MedianFinder. */
    public MedianFinder() {
        // The constructor is kept empty as there's nothing to initialize outside the declarations.
    }

    /** Adds a number into the data structure. */
    public void addNum(int num) {
        minHeap.offer(num); // Add the number to the min-heap
        maxHeap.offer(minHeap.poll()); // Balance the heaps by moving the smallest number of min-heap to max-heap

        // Ensure max-heap has equal or one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move the maximum number of max-heap to min-heap
        }
    }

    /** Returns the median of current data stream. */
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            // If max-heap has more elements, the median is the top of the max-heap
            return maxHeap.peek();
        }
        // Otherwise, the median is the average of the tops of both heaps
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
