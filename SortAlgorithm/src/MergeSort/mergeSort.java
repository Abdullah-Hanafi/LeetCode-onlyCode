package MergeSort;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

public class mergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 8, 3, 7, 3, 5, 8, 2, 6, 9, 10};
        merge(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void merge(int[] nums) {
        merge(nums, 0, nums.length - 1);
    }

    public static void merge(int[] nums,int left,int right){
        int mid = left + (right - left) / 2;
        if(left < right){
            merge(nums,left,mid);
            merge(nums,mid+1,right);
            mergeSortMethod(nums,left,mid,right);
        }
    }

    private static void mergeSortMethod(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index1 = left;
        int index2 = mid + 1;
        int index = 0;
        while(index1 <= mid && index2 <= right){
            if(nums[index1] <= nums[index2]){
                temp[index++] = nums[index1++];
            }else{
                temp[index++] = nums[index2++];

            }
        }

        while(index1 <= mid){
            temp[index++] = nums[index1++];
        }

        while(index2 <= right){
            temp[index++] = nums[index2++];
        }

        for(int i = 0; i < temp.length; i++){
            nums[left++] = temp[i];
        }
    }


}
