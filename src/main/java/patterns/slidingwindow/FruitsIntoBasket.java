package patterns.slidingwindow;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        System.out.println(findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

    public static int findLength(char[] arr) {
        int right = 0;
        int resultLength = Integer.MIN_VALUE;
        int maxLength = 0;
        char char1 = 'a';
        char char2 = 'a';
        while (right < arr.length) {
            if (char1 == 'a' && arr[right] != char2) {
                char1 = arr[right++];
                maxLength++;
                continue;
            }
            if (char2 == 'a' && arr[right] != char1) {
                char2 = arr[right++];
                maxLength++;
                continue;
            }

            if (arr[right] == char1 || arr[right] == char2) {
                maxLength++;
            } else {
                if (maxLength > resultLength) {
                    resultLength = maxLength;
                }
                maxLength = 0;
                char1 = 'a';
                char2 = 'a';
                right = right - 2;
            }
            right++;
        }

        return maxLength;
    }
}
