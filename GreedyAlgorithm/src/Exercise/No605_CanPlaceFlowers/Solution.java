package Exercise.No605_CanPlaceFlowers;

public class Solution {

    /**
     * 方法一：跳格子
     * 从左往右进行遍历即可。
     * 第一种情况：如果当前位置是1，说明当前位置已经种了花，下一个位置不能种花，所以直接跳两格进行判断。
     * 第二种情况：如果当前位置是0，我们只需要判断下一个格是否为0即可。由于每次碰到1都会跳两格，因此前一个格必定是0。
     *      如果下一个位置是0，则此格子可以种花，n--，然后将此格子当作有花处理，直接跳两格。
     *      如果下一个位置是1，则此格子不能种花，且它后面的两个格子都不能种花，直接跳3个格子。
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        for (int i = 0; i < length && n > 0; ) {
            if (flowerbed[i] == 1) { //当前位置已经种花了，所以下一个位置不可能种花，直接跳两格进行判断
                i += 2;
            } else if (i == length - 1 || flowerbed[i + 1] == 0) {  //当前位置是最后一个位置，或者说下一个位置没有种花
                n--;
                i += 2;
            } else {    //下一个位置种花了，直接跳三格
                i += 3;
            }
        }
        return n <= 0;
    }

    /**
     * 方法二：连续0的个数
     * 情境一：
     * 对于两头是1中间是0的连续0区间：
     * 1-2个0，如1 0 0 1，种0朵花
     * 3-4个0，如1 0 0 0 0 1，种1朵花
     * 5-6个0，如1 0 0 0 0 0 1，种2朵花
     * ......
     * count个0，种（count - 1）/2朵花
     *
     * 情境二：
     * 对于两头是0的连续0区间，显然计算方法与情境一不同
     * 为了统一代码，我们可以认为花床左右两端没有种花，即-1处是0，length处也是0。这样遍历时遇到1就是区间的结尾。也就将情境二和情境一结合了起来
     */
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int countZero = 1;  //-1处有个0
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                countZero++;    //连续0的个数+1
            } else if (flowerbed[i] == 1) {     //遇到1结算上一段区间可种花的数量
                count += (countZero - 1) / 2;
                countZero = 0;  //连续0的个数归零
            }
        }
        //最后一段区间尚未结算
        countZero++;    //length处有个0
        count += (countZero - 1) / 2;   //遍历完成哦，需要继续统计花的数量

        return count >= n;
    }
}
