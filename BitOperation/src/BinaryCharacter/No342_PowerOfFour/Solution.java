package BinaryCharacter.No342_PowerOfFour;

public class Solution {
    /**
     * (n & (n -1)) == 0 说明是2的幂，即00000。。1.。0000形式，其中1出现在奇数位（最低位为第0位）
     * 在是2次幂的基础上，如果是4次幂，即000000..1...000000形式，其中1出现在偶数位
     * 10101010101010101010101010101010 & n == 0;即说明n的偶数位有1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

}
