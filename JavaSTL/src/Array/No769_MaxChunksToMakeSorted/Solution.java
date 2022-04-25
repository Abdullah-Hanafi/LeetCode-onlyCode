package Array.No769_MaxChunksToMakeSorted;

public class Solution {
    /**
     * 从左至右遍历数组，每当当前最大值等于数组的下标的时候计数器加一
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int currentMax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax = Math.max(currentMax, arr[i]);
            if (currentMax == i){
                count++;
            }
        }
        return count;
    }
}
