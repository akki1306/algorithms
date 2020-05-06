package patterns.slidingwindow;

import java.util.*;

public class LongestSubstringKCharacters {

    public static void main(String[] args) {
        String s = "araaci";
        int i = longestSubstringKCharacters(s, 3);
        System.out.println("Value >>> " + i);
    }

    private static int longestSubstringKCharacters(String s, int k) {
        int length = 0;
        int resultLength = 0;
        int maxCharacters = 0;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap(s.length());

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char key = s.charAt(windowEnd);
            length = windowEnd - windowStart + 1;
            if (map.putIfAbsent(key, 1) != null) {
                map.put(key, (map.get(key) + 1));
            }
            maxCharacters = map.keySet().size();

            if (maxCharacters > k) {
                while (maxCharacters > k) {
                    char c = s.charAt(windowStart);
                    Integer value = map.get(c);
                    if (value == 1) {
                        map.remove(c);
                    } else {
                        map.put(c, value - 1);
                    }
                    windowStart++;
                    maxCharacters = map.keySet().size();
                }
            }else{
                if (length > resultLength) {
                    resultLength = length;
                }
            }
        }

        return resultLength;
    }
}
