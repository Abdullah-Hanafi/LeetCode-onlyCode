package Exercise.No665_NonDecreasingArray;

public class Solution {

    /**
     * 方法一：贪心
     * 一些例子：4 2 3/ -1 4 2 3/ 2 3 3 2 4
     * 我们通过上述的三个例子可以发现。出现递减子序列的时候，有的时候需要修改前面的数字，有的时候需要修改后面的数字。
     * 比如4 2 3出现递减子序列4 2.那么我们可以修改4，将4修改成2，而不是将2修改成4。即尽可能的让大数字变成小数字，让小数字变成大数字的话后面会很难维持非递减特性
     * 比如2 3 3 2 4出现递减子序列3 2，显然我们应该将2修改成3
     * 因此我们在遍历的时候要将nums[i]、nums[i - 1]、nums[i - 2]都进行比较以确定要修改的数字
     * 因为要瞻前顾后，所以可以先预处理前两个数字，然后再进行遍历
     * 2 5 1/ 2 5 2/ 2 5 3
     * nums[2] = 1 < nums[0] = 2;显然nums[i] = nums[i - 1]
     * nums[2] = 2 = nums[0] = 2;显然nums[i- 1] = nums[i]更易使后面的数组维持非递减特性
     * nums[2] = 3 > nums[0] = 2;显然nums[i - 1] = nums[i]
     * 因此分两种情况nums[i] >= nums[i - 2]和nums[i] < nums[i - 2]
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int length = nums.length;
        int count = 0;

        if (nums[0] > nums[1]) {
            count++;
            nums[0] = nums[1];  //尽量让大的数字变小，而不是小的数字变大，如果nums[1]被赋值为大数nums[0]则后面更难维持非递减特性
        }

        for (int i = 2; i < length && count < 2; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (nums[i - 2] < nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }

    /**
     * 方法二：贪心
     * 将nums[0] > nums[1] 和nums[i] >= nums[i - 2]归于一类优化代码
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int length = nums.length;
        int count = 0;
        for (int i = 1; i < length && count <= 1; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
            count++;
        }

        return count <= 1;
    }

}
