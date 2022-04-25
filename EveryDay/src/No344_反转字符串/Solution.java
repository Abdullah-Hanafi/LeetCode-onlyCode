package No344_·´×ª×Ö·û´®;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/1 9:25
 */
public class Solution {
    public void reverseString(char[] s) {
        if (s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
