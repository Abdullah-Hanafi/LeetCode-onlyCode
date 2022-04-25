package No241_DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        int len = expression.length();
        int start = 0;
        for (start = 0; start < len; start++) {
            if (Character.isDigit(expression.charAt(start))) continue;
            else break;
        }

        if (start == len) list.add(Integer.parseInt(expression));
        return null;
    }
}
