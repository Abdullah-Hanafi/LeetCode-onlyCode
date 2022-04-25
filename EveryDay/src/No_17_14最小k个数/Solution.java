package No_17_14最小k个数;

import java.util.PriorityQueue;

public class Solution {
    /**
     * 方法一：堆排列
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> (o2.compareTo(o1)));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            heap.add(arr[k]);
            heap.remove();
        }

        for (int i = 0; i < k; i++) {
            ans[i] = heap.remove();
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = -1234;
        assert x >= 0 : x + "不是非负数";
        System.out.println(x);
    }

}
