package patterns.slidingwindow;

public class NoRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println("Result is: " + findLength("abccde"));
    }

    public static int findLength(String str) {
        int maxLength = 0;
        int length = 0;
        for (int head = 0; head < str.length(); head++) {
            if (head == 0) {
                length++;
            } else {
                char prevChar = str.charAt(head - 1);
                char currChar = str.charAt(head);
                if (prevChar == currChar) {
                    length = 1;
                } else {
                    length++;
                }
            }

            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
