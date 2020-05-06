package patterns.slidingwindow;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;

/**
 * Time complexity O(n)
 * Space Complexity
 */
public class MaximumSumSubArrayK {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1, 5};
        int k = 2;
        System.out.println("The result is :" + Arrays.toString(getMaximumSumSubArrayK(k, arr)));
    }

    static int[] getMaximumSumSubArrayK(int k, int[] arr) {
        int[] result = new int[k];
        int sum = 0;
        int resultSum = 0;
        for (int i = 0; i < arr.length - (k - 1); i++) {
            if (i > 0) {
                sum -= arr[i - 1];
                sum += arr[i + (k-1)];
                if ((sum - arr[i - 1] + arr[i + (k-1)]) > resultSum) {
                    resultSum = sum;
                    int j = i;
                    int l = 0;
                    while (l < k) {
                        result[l++] = arr[j++];
                    }
                }
            }else{
                int j = i;
                int l = 0;
                while (l < k) {
                    sum += arr[j];
                    result[l++] = arr[j++];
                }
                resultSum = sum;
            }

        }
        return result;
    }

}
