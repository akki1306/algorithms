package patterns.slidingwindow;

import java.util.Arrays;

public class SmallestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 2, 3, 2};
        int S = 8;
        int m = getSmallestSubArrayWithGivenSum(S, arr);
    }

    public static int getSmallestSubArrayWithGivenSum(int S, int[] arr) {
        int numberOfElements;
        int resultNumberOfElements = Integer.MAX_VALUE;
        int sum = arr[0];
        int windowStart = 0;
        int windowEnd = 0;

        while (windowStart < arr.length  && windowEnd < arr.length ) {
            if (sum >= S) {
                numberOfElements = (windowEnd - windowStart) + 1;
                    if(windowStart == windowEnd) {
                        windowStart++;
                        windowEnd++;
                        if (windowEnd  < arr.length) {
                            sum += arr[windowEnd];
                        }
                    }else if(windowStart < windowEnd){
                        if (windowStart < arr.length) {
                            sum -= arr[windowStart];
                        }
                        windowStart++;
                    }

                if(numberOfElements < resultNumberOfElements){
                    resultNumberOfElements = numberOfElements;
                }
            } else if (sum < S) {
                windowEnd++;
                if (windowEnd < arr.length) {
                    sum += arr[windowEnd];
                }
            }

        }
        return resultNumberOfElements;
    }

}
