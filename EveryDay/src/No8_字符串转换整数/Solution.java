package No8_字符串转换整数;

public class Solution {
    public int myAtoi(String str) {
        //先处理前导空格
        String string = str.trim();
        if (string.length() == 0) return 0;

        //处理第一个字符，符号位
        char[] chars = string.toCharArray();
        boolean flag = false; //符号位为+
        int index = 0;
        if (chars[index] == '-') {
            flag = true;
            index++;
        } else if (chars[index] == '+') {
            flag = false;
            index++;
        } else if (!Character.isDigit(string.charAt(0))) {
            return 0;
        }

        //处理数字
        int answer = 0;
        while (index < string.length() && Character.isDigit(chars[index])) {
            int digit = string.charAt(index) - '0';
            //answer = answer*10 + digit 中 *10 和 +digit都有可能越界，故而越界判定条件为answer > (Integer.MAX_VALUE - digit) / 10
            if (answer > (Integer.MAX_VALUE - digit) / 10) {
                //越界根据符号位，进行相应的输出
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            answer = answer * 10 + digit;
            index++;
        }

        return flag ? -answer : answer;
    }
}
