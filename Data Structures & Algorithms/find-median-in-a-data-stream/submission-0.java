class MedianFinder {
    // Max Heap: stores smaller half
    PriorityQueue<Integer> small;

    // Min Heap: stores larger half
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());

        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add number to the correct heap
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        // Step 2: Balance the heaps

        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        }

        else if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // Odd number of elements
        if (small.size() > large.size()) {
            return small.peek();
        }

        if (large.size() > small.size()) {
            return large.peek();
        }

        // Even number of elements
        return (small.peek() + large.peek()) / 2.0;
    }
}
