class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();

        // Step 1: Store the last index of each character
        int[] last = new int[26];

        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Build the partitions greedily
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Extend the current partition if necessary
            end = Math.max(end, last[ch - 'a']);

            // We have reached the end of this partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
