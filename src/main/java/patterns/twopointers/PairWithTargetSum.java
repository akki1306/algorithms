package patterns.twopointers;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] result = search(new int[]{2, 5, 9, 11}, 11);
    }

    public static int[] search(int[] arr, int targetSum) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right--;
            }

        }
        return result;
    }
}
