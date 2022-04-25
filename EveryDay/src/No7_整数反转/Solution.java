package No7_整数反转;

//(int)取的是高位，低位直接忽略

public class Solution {
    public int reverse(int x) {
        long number = 0;
        while (x != 0) {
            number = number * 10 + x % 10;
            x /= 10;
        }
        return (int) number == number ? (int) number : 0;
    }
}
