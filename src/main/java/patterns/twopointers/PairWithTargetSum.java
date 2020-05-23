package patterns.twopointers;

public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] result = search(new int[]{2, 5, 9, 11}, 11);
    }

    public static int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here

        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] == targetSum) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (arr[left] + arr[right] < targetSum) {
                left++;
            } else if (arr[left] + arr[right] > targetSum) {
                right--;
            }

            if (left == right - 1 && !(arr[left] + arr[right] == targetSum)) {
                break;
            }
        }
        return result;
    }
}
