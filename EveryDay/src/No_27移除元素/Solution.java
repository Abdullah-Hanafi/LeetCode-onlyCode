package No_27移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) return 0;
        int number = 0; //不等于val的元素的个数，
        //指针，指向与val不相等的数组的下一个位置（最开始子数组为空，所以number指向0）
        //初始时，假设与val不相等的元素个数为0
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) { //当前元素与val不相等时
                nums[number] = nums[i];
                number++; //计数器+1，指针右移
            }
        }
        return number;
    }
}
