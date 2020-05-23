package patterns.twopointers;

public class SquaringSortedArray {
    public static void main(String[] args) {
        int[] result = makeSquares(new int[]{-3, -1, 0, 1, 2});
        System.out.println("111");
    }

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int squareIndex = arr.length - 1;

        int left = 0;
        int right = arr.length - 1;

        while(left < right && left < arr.length && right >= 0){
            int squareLeft = arr[left] * arr[left];
            int squareRight = arr[right] * arr[right];

            if(squareLeft > squareRight){
                squares[squareIndex--] = squareLeft;
                left++;
            }else{
                squares[squareIndex--] = squareRight;
                right--;
            }
        }
        return squares;
    }

}
