class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        var target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        var res = new ArrayList<Integer>();
        var count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(target, count)) res.add(0);

        for(int i = 1; i + p.length() <= s.length(); i++) {
            count[s.charAt(i - 1) - 'a']--;
            count[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(target, count)) res.add(i);
        }

        return res;
    }
}