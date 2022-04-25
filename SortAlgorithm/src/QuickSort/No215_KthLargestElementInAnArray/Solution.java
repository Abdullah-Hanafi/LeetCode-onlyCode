package QuickSort.No215_KthLargestElementInAnArray;

import HeapSort.Heap;

import java.util.*;

public class Solution {

    /**
     * 方法一：排序API+索引
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 方法二：基于快速排序的选择方法
     *
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest1(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return nums[left];
    }

    public static int partition(int[] nums, int first, int last) {
        int pivot = nums[first];
        int low = first + 1;
        int high = last;

        while (low < high) {
            while (low <= high && nums[low] <= pivot)
                low++;
            while (low <= high && nums[high] > pivot)
                high--;

            if (high > low) {
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
            }
        }
        while (high >= first && nums[high] > pivot)
            high--;

        if (pivot > nums[high]) {
            nums[first] = nums[high];
            nums[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    /**
     * 方法三：基于小根堆的选择方法（Java自带API）
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }
        int ans = 0;
        while (heap.size() > 0) {
            if (heap.size() == k) {
                ans = heap.remove();
                break;
            }
            heap.remove();
        }
        return ans;
    }

    /**
     * 方法四：基于大根堆的选择方法（Java自带API）
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((Integer o1, Integer o2) -> (o2.compareTo(o1)));
        for (int num : nums) {
            heap.add(num);
        }
        int ans = 0;
        while (k > 0) {
            ans = heap.remove();
            k--;
        }
        return ans;
    }


    /**
     * 方法五：基于大根堆的选择方法（自己实现）
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest4(int[] nums, int k) {
        Heap<Integer> heap = new Heap<Integer>();
        for (int num : nums) {
            heap.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = heap.remove();
        }
        return nums[k - 1];
    }

}
