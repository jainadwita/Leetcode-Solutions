class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray())
                freq[c - 'a']++;

            // Build key like "2#0#1#..." for each letter count
            StringBuilder sb = new StringBuilder();
            for (int count : freq)
                sb.append(count).append('#');
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}