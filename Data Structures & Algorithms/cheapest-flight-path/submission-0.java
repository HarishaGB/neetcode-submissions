class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];

        // Step 1: Initially, all airports have infinite cost
        Arrays.fill(prices, Integer.MAX_VALUE);

        // Starting airport has cost 0
        prices[src] = 0;

        // Step 2: Relax flights at most k + 1 times
        for (int i = 0; i <= k; i++) {
            // Important: Take a copy of previous prices
            int[] temp = prices.clone();

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // Check whether source airport is reachable
                if (prices[from] != Integer.MAX_VALUE) {
                    int newPrice = prices[from] + price;

                    // Update if we find a cheaper price
                    temp[to] = Math.min(temp[to], newPrice);
                }
            }

            // Save updated prices for the next iteration
            prices = temp;
        }

        // Step 3: Return destination price
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
