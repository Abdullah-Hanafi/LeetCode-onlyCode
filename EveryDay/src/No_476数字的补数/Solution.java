package No_476数字的补数;

public class Solution {
    public int findComplement(int num) {
        //初始化num的最高位为最低位
        int highest = 0;

        //更新num的最高位，31位为符号位不用判断
        for (int i = 1; i <= 30; i++) {
            if (num >= (1 << i)) {
                highest = i;
            } else {
                break;
            }
        }

        int mask = (highest == 30 ? 0x7fffffff : (1 << (highest + 1)) - 1);
        return mask ^ num;
    }
}
