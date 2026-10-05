import java.util.ArrayList;
import java.util.List;

class PatternMatch {
    public PatternMatch(){}

    //TODO: Add Z-Algorithm, Rabin-Karp, something else?

    public static List<Integer> findKMP(String str, String pattern) {
        var lps = calculateLPS(pattern);
        var match = 0;
        var result = new ArrayList<Integer>();
        if (pattern.isEmpty()) return result;


        for(int i = 0; i < str.length(); i++) {
            while(match > 0 && pattern.charAt(match) != str.charAt(i)) {
                match = lps[match - 1];
            }
            if (pattern.charAt(match) == str.charAt(i)) match++;
            if (match == pattern.length()) {
                result.add(i + 1 - pattern.length());
                match = lps[match - 1];
            }
        }

        return result;
    }

    public static int[] calculateLPS(String str) {
        int matchLen = 0;
        var res = new int[str.length()];

        for(int i = 1; i < str.length(); i++) {
            while (matchLen > 0 && str.charAt(matchLen) != str.charAt(i)) {
                matchLen = res[matchLen - 1];
            }
            if (str.charAt(matchLen) == str.charAt(i)) res[i] = ++matchLen;
        }

        return res;
    }
}


/*
 * KMP / Z-FUNCTION PRACTICE PROBLEMS (applications, not the plain algorithm)
 *
 * Core tricks to watch for:
 *   - pattern + "#" + text            → search via one LPS/Z array
 *   - s + s                           → rotations
 *   - s + "#" + reverse(s)            → palindromic prefixes
 *   - n - lps[n-1]                    → smallest period of a string
 *   - convert arrays to "diff/compare" sequences, then match the shape
 *
 * EASY / WARM-UP
 *   LC 28   Find the Index of the First Occurrence in a String (sanity check)
 *   LC 796  Rotate String                       (search goal in s + s)
 *   LC 1392 Longest Happy Prefix                (answer = lps[n-1] directly)
 *
 * MEDIUM
 *   LC 459  Repeated Substring Pattern          (period trick: n % (n - lps[n-1]) == 0)
 *   LC 686  Repeated String Match               (repeat a, then search b)
 *   LC 1764 Form Array by Concatenating Subarrays of Another Array (KMP on int arrays)
 *   LC 1367 Linked List in Binary Tree          (KMP along tree paths)
 *   LC 3036 Number of Subarrays That Match a Pattern II (match a compare-sequence)
 *
 * HARD
 *   LC 214  Shortest Palindrome                 (s + "#" + reverse(s))
 *   LC 2223 Sum of Scores of Built Strings      (Z-function, sum of z values)
 *   LC 3008 Find Beautiful Indices in the Given Array II (all occurrences + two pointers)
 *   LC 3031 Minimum Time to Revert Word to Initial State II (Z-function on suffixes)
 *   LC 1397 Find All Good Strings               (KMP automaton + digit DP, very hard)
 *
 * CODEFORCES CLASSICS
 *   CF 126B Password                    (prefix = suffix = also appears in the middle)
 *   CF 432D Prefixes and Suffixes       (count occurrences of each border)
 *
 * THEORY EXERCISES (cp-algorithms.com, "Prefix function" and "Z-function" pages)
 *   - Count occurrences of every prefix of s in s
 *   - Number of distinct substrings in O(n^2)
 *   - String compression: shortest t such that s = t + t + ... + t
 */