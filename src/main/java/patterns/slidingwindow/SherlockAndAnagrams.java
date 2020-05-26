package patterns.slidingwindow;

import java.util.*;

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        //System.out.println("Substr : " + "kkkk".substring(0,1));
        System.out.println("Test >>> " + sherlockAndAnagrams("abcd"));
    }

    public static int sherlockAndAnagrams(String s) {
        long count = 0;
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i + 1);
            if (hs.add(subStr)) {
                count = count + getCount(findStringAnagrams(s, subStr));
            }

            if (i > 0) {
                subStr = s.substring(0, i + 1);
                count = count + getCount(findStringAnagrams(s, subStr));
            }
        }
        return (int) count;
    }

    private static long getCount(List<Integer> anagrams) {
        return (factorialUsingForLoop(anagrams.size()) / (factorialUsingForLoop(2) * factorialUsingForLoop(anagrams.size() - 2)));
    }

    private static long factorialUsingForLoop(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private static int getCount(long count, List<Integer> anagrams) {
        if (anagrams.size() > 1) {
            count = count + anagrams.size();
        }
        return (int) count;
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();

        int windowStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap();
        for (int i = 0; i < pattern.length(); i++) {
            charFrequencyMap.put(pattern.charAt(i), charFrequencyMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int matched = 0;
        int windowEnd;
        for (windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }
}
