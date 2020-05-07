package patterns.slidingwindow;

import java.util.*;

public class BearAndSteadyGene {
    public static void main(String[] args) {
        int i = bearAndSteadyGeneSmallestSubstringToReplace("TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC");
        System.out.println("Output is : " + i);
    }

    //ACTGAAAG
    public static int bearAndSteadyGeneSmallestSubstringToReplace(String gene) {
        Map<Character, Integer> map = new HashMap();

        int geneCount = gene.length() / 4;
        for (int i = 0; i < gene.length(); i++) {
            char c = gene.charAt(i);
            if (map.putIfAbsent(c, 1) != null) {
                Integer value = map.get(c);
                map.put(c, ++value);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            map.put(entry.getKey(), Math.max(0, entry.getValue() - geneCount));
        }

        if (!map.containsKey('A')) {
            map.put('A', 0);
        }
        if (!map.containsKey('C')) {
            map.put('C', 0);
        }
        if (!map.containsKey('T')) {
            map.put('T', 0);
        }
        if (!map.containsKey('G')) {
            map.put('G', 0);
        }

        int head = 0;
        int tail = 0;
        int minlen = gene.length();
        Map<Character, Integer> itr = new HashMap<>();
        itr.put('A',0);
        itr.put('C',0);
        itr.put('T',0);
        itr.put('G',0);

        while (head != gene.length()) {
            char key = gene.charAt(head);
            if (itr.putIfAbsent(key, 1) != null) {
                itr.put(key, itr.get(key) + 1);
            }
            if (itr.get('A') >= map.get('A')
                    && itr.get('C') >= map.get('C')
                    && itr.get('T') >= map.get('T')
                    && itr.get('G') >= map.get('G')) {
                minlen = Math.min(minlen, (head - tail) + 1);
                char tailKey = gene.charAt(tail);
                while (itr.get(tailKey) > map.get(tailKey)) {
                    itr.put(tailKey, itr.get(tailKey) - 1);
                    tail++;
                    if(tail < gene.length()) {
                        tailKey = gene.charAt(tail);
                    }
                    minlen = Math.min(minlen, (head - tail) + 1);
                }
            }
            head++;
        }
        return minlen;
    }
}
