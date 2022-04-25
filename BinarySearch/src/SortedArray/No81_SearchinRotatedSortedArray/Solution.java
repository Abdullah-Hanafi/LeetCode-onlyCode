package SortedArray.No81_SearchinRotatedSortedArray;

public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return true;
            }

            //���м�ֵ�����ֵ��ͬʱ�������޷��ж����ȫ����ͬ�����Ҳ�ȫ����ͬ
            if (nums[mid] == nums[left]) {
                left++;
            } else if (nums[left] <= nums[mid]) {
                //������������������
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //�ұ��������������ұ�
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}