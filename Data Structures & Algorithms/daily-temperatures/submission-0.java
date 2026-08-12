class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();

                result[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return result;
    }
}
