
public class SearchBenchmark{
    public static void main(String[] args) {
        int[] nums = new int[5_000_000];

        for(int i = 0; i < nums.length; i++){
            nums[i] = i * 2;
        }

        long start = System.nanoTime();
        int resultIndex = SearchLib.linearSearch(nums, 10_000_000);
        long end = System.nanoTime();

        long searchTime = end - start;
        System.out.printf("Linear Search -> Index: %d, time: %d %n", resultIndex, searchTime);

        start = System.nanoTime();
        resultIndex = SearchLib.binarySearch(nums, 10_000_000);
        end = System.nanoTime();

        searchTime = end - start;
        System.out.printf("Binary Search -> Index: %d, time: %d %n", resultIndex, searchTime);
    }
}