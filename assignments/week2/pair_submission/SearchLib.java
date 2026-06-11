public class SearchLib{
    public static int linearSearch(int[] sorted, int target){
        int index = -1;
        for(int i = 0; i < sorted.length; i++){
            int num = sorted[i];
            if(num == target){
                index = i;
            }
        }
        return index;
    }
    public static int binarySearch(int[] sorted, int target){
        int left = 0;
        int right = sorted.length - 1;

        return binarySearchHelper(left, right, sorted, target);
    }
    private static int binarySearchHelper(int left, int right, int[] sorted, int target){
        if(left <= right){
            int mid = (left + right) / 2;
            int num = sorted[mid];
            if(num == target){
                return mid;
            }
            if(num < target){
                return binarySearchHelper(mid + 1, right, sorted, target);
            }else{
                return binarySearchHelper(left, mid - 1, sorted, target);
            }
        }
        return -1;
    }
}