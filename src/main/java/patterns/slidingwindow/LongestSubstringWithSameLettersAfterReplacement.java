package patterns.slidingwindow;

public class LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        System.out.println("Result is >> " + findLength("abccde", 1));
    }

    public static int findLength(String str, int k) {
        int counter = 0;
        char currChar;
        int length = 0;
        int maxlen = 0;
        while (counter < str.length()) {
            length = 1;
            currChar = str.charAt(counter);
            int newCounter = counter + 1;
            int i = 1;
            while (newCounter < str.length()) {

                if (str.charAt(newCounter) == currChar) {
                    length++;
                } else {
                    while(i <= k) {
                        length++;
                        i++;
                    }
                }

                newCounter++;
            }
            if (length > maxlen) {
                maxlen = length;
            }


            counter++;
        }

        return maxlen;
    }
}
