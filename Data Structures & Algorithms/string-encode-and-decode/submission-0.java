class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String encoded) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < encoded.length()) {
            // Find '#'
            int j = i;

            while (encoded.charAt(j) != '#') {
                j++;
            }

            // Get length
            int length = Integer.parseInt(encoded.substring(i, j));

            // Start of actual string
            int start = j + 1;

            // Extract string
            String str = encoded.substring(start, start + length);

            result.add(str);

            // Move to next encoded string
            i = start + length;
        }

        return result;
    }
}
