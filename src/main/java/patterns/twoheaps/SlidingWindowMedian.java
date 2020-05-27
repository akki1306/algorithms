package patterns.twoheaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");

    }

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        int windowSize = 0;
        int j = 0;
        int i = 0;
        while(i < nums.length){

            while (windowSize < k) {
                int num = nums[i];
                if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }

                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
                i++;
                windowSize++;
            }

            if (windowSize == k) {
                if (maxHeap.size() == minHeap.size()) {
                    result[j++] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[j++] = maxHeap.peek();
                }
                windowSize--;

                if (!maxHeap.remove(nums[i - k])) {
                    minHeap.remove(nums[i - k]);
                }
            }
        }

        return result;
    }
}
