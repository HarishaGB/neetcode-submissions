class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // If s1 is bigger, permutation cannot exist
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count characters in s1
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        int windowSize = s1.length();

        // Create sliding window in s2
        for (int i = 0; i < s2.length(); i++) {
            // Add current character
            freq2[s2.charAt(i) - 'a']++;

            // Remove character outside the window
            if (i >= windowSize) {
                freq2[s2.charAt(i - windowSize) - 'a']--;
            }

            // Compare frequencies
            if (i >= windowSize - 1) {
                if (matches(freq1, freq2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matches(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
}
