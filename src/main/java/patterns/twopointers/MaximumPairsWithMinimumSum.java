/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */
package patterns.twopointers;

import java.io.*;
import java.util.*;

public class MaximumPairsWithMinimumSum {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        while (n > 0) {
            int match = 0;
            String[] s = scan(reader);

            n = Integer.parseInt(s[0]);
            NavigableMap<Integer, Integer> teamGFrequency = new TreeMap<>();
            String[] teamG = s[1].split(" ");
            String[] oppn = s[2].split(" ");

            for (String str : teamG) {
                teamGFrequency.put(Integer.valueOf(str), teamGFrequency.getOrDefault(Integer.valueOf(str), 0) + 1);
            }

            for (int i = 0; i < oppn.length; i++) {
                Map.Entry<Integer, Integer> le = teamGFrequency.higherEntry(Integer.valueOf(oppn[i]));

                while (le != null && le.getValue() <= 0) {
                    teamGFrequency.remove(le.getKey());
                    le = teamGFrequency.higherEntry(Integer.valueOf(oppn[i]));
                }

                int minSum = Integer.MAX_VALUE;
                if (le != null) {
                    if (le.getValue() > 0) {
                        int sum = le.getKey() - Integer.valueOf(oppn[i]);
                        if (sum < minSum && sum > 0) {
                            match++;
                            teamGFrequency.put(le.getKey(), teamGFrequency.get(le.getKey()) - 1);
                        }
                    } else {
                        teamGFrequency.remove(le.getKey());
                    }
                }
            }

            n--;
            System.out.println(match);
        }
        reader.close();
    }

    private static String[] scan(BufferedReader reader) {
        try {
            String[] s = new String[4];
            int i = 0;
            while (i < 3) {
                s[i++] = reader.readLine();
            }
            return s;

        } catch (Exception e) {

        }
        return null;
    }
}
