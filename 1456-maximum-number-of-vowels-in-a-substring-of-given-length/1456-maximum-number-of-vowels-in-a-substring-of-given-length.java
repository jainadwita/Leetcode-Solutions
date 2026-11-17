class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;

        // first window
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        max = count;

        // slide the window
        for (int i = k; i < s.length(); i++) {
            char in = s.charAt(i);        // entering
            char out = s.charAt(i - k);   // leaving

            if (in == 'a' || in == 'e' || in == 'i' || in == 'o' || in == 'u') {
                count++;
            }
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}