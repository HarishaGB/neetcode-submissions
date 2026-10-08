class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Total cards must be divisible by group size
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count frequency of every card
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        // Sort cards so we always process the smallest card first
        Arrays.sort(hand);

        // Process cards from smallest to largest
        for (int card : hand) {

            // This card has already been used
            if (count.get(card) == 0) {
                continue;
            }

            // Try to create a group:
            // card, card+1, card+2, ...
            for (int value = card;
                 value < card + groupSize;
                 value++) {

                // Required card doesn't exist
                if (count.getOrDefault(value, 0) == 0) {
                    return false;
                }

                // Use this card
                count.put(value, count.get(value) - 1);
            }
        }

        return true;
    }
}
