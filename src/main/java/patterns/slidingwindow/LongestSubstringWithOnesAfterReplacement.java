package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithOnesAfterReplacement {

    public static void main(String[] args) {
        int[] arr= new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println("Result is : " + findLength(arr, 3));
    }

    public static int findLength(int[] arr, int k) {
        int onesCount = 0;
        int maxlen = 0;
        int windowStart = 0;
        for(int windowEnd=0;windowEnd < arr.length; windowEnd++){
           if(arr[windowEnd] == 1){
               onesCount++;
           }


           if(windowEnd - windowStart + 1 - onesCount > k){
               if(arr[windowStart] == 1){
                   onesCount--;
               }
               windowStart++;
           }

           maxlen = Math.max(maxlen, windowEnd - windowStart + 1);
        }

        return maxlen;
    }
}
