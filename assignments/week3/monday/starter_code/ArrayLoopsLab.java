/**
 * Lab 1 — Arrays & loops. Implement the bodies.
 * See ../README.md
 */
public class ArrayLoopsLab {

    /** Reverse array in place. */
    public static void reverse(int[] data) {
        int leftPtr = 0;
        int rightPtr = data.length - 1;

        while (leftPtr < rightPtr) {
            int temp = data[leftPtr];
            data[leftPtr] = data[rightPtr];
            data[rightPtr] = temp;
            leftPtr++;
            rightPtr--;
        }
    }

    /** Smallest element; illegal if null or empty. */
    public static int min(int[] data) {
        if(data == null || data.length == 0){
            throw new IllegalArgumentException();
        }
        int smallest = data[0];

        for(int i = 1; i < data.length; i++){
            int currentNum = data[i];
            if(currentNum < smallest){
                smallest = currentNum;
            }
        }
        return smallest;
    }

    /** Largest element; illegal if null or empty. */
    public static int max(int[] data) {
        if(data == null || data.length == 0){
            throw new IllegalArgumentException();
        }
        int largest = data[0];

        for(int i = 1; i < data.length; i++){
            int currentNum = data[i];
            if(currentNum > largest){
                largest = currentNum;
            }
        }
        return largest;
    }

    /** In-place ascending sort using nested loops only (no Arrays.sort). */
    public static void sortAscending(int[] data) {
        for(int i = 0; i < data.length; i++){
            for(int j = 1; j < data.length - i; j++){
                int curr = data[j-1];
                int adj = data[j];
                
                if(curr > adj){
                    data[j-1] = adj;
                    data[j] = curr;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 0, -2, -6, 7};
        System.out.println(min(arr));
        System.out.println(max(arr));
        sortAscending((arr));

        for(int num : arr){
            System.out.printf(num + " ");
        }
    }
}