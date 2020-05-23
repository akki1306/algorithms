package patterns.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 2, 2, 11}));
    }

    public static int remove(int[] arr) {
        int pointer = 1;
        int prevPointer = 0;
        int counter = 0;
        while(pointer < arr.length){
            if(arr[prevPointer]!=arr[pointer]){
                counter++;
            }else{
                arr[pointer] = -1;
            }
            prevPointer = pointer;
            pointer++;
        }
        return counter;
    }
}
