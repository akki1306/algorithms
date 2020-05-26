package patterns.twoheaps;

import java.util.PriorityQueue;

public class MedianOfStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) {
        MedianOfStream medianOfStream = new MedianOfStream();
        medianOfStream.insertNum(3);
        medianOfStream.insertNum(1);
        System.out.println("The median is: " + medianOfStream.findMedian());
        medianOfStream.insertNum(5);
        System.out.println("The median is: " + medianOfStream.findMedian());
        medianOfStream.insertNum(4);
        System.out.println("The median is: " + medianOfStream.findMedian());
    }

    public void insertNum(int num) {
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
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }

        return maxHeap != null ? maxHeap.peek() : 0.0d;
    }
}
