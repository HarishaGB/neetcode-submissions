class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store {position, speed}
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            int pos = car[0];
            int spd = car[1];

            // Time required to reach target
            double time = (double) (target - pos) / spd;

            // If current car cannot catch the fleet ahead
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

            // Otherwise it joins the fleet ahead
        }

        return stack.size();
    }
}
