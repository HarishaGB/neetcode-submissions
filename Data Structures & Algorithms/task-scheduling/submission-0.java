class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count task frequencies
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Max Heap for available task frequencies
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        // Step 3: Queue stores [remaining frequency, available time]
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        // Step 4: Process tasks until everything is completed
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            time++;

            // Release a task if its cooldown has finished
            if (!cooldown.isEmpty()
                    && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }

            // Execute the most frequent available task
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;

                // If repetitions remain, put the task on cooldown
                if (remaining > 0) {
                    cooldown.offer(
                        new int[]{remaining, time + n + 1}
                    );
                }
            }
        }

        return time;
    }
}
