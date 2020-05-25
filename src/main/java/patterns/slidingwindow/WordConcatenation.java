package patterns.slidingwindow;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class WordConcatenation {
    public static void main(String[] args) {
        System.out.println("Find Word Concatenation : " + findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
    }

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<String, Integer> wordCount = new HashMap<>();
        int left = 0;
        int right = 0;
        for (String s : words) {
            wordCount.put(s, 0);
        }
        int count = 0;
        while (left < str.length() && right < str.length()) {
            String substr = str.substring(right, right + 3);

            if (wordCount.get(substr) == 0) {
                wordCount.put(substr, 1);
                count++;
            } else {
                left = left + 3;
            }

            if (count == wordCount.size()) {
                resultIndices.add(left);
                String leftStr = str.substring(left, left + 3);
                wordCount.put(leftStr, wordCount.get(leftStr) - 1);
                left = left + 3;
                count--;
            }

            right = right + 3;
        }


        return resultIndices;
    }
}
