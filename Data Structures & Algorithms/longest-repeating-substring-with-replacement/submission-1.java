class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Maximum frequency in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Number of characters we need to replace
            int windowLength = right - left + 1;
            int replacements = windowLength - maxFreq;

            // If replacements > k, shrink window
            while (replacements > k) {

                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;

                left++;

                windowLength = right - left + 1;
                replacements = windowLength - maxFreq;
            }

            // Store largest valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        
    }
}
