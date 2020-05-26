package patterns.twopointers;

public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    public static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                swap(arr, low, i);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, high, i);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
