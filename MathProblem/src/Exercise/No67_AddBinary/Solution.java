package Exercise.No67_AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int addBit = 0;
        String ans = "";
        while (i >= 0 || j >= 0 || addBit != 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            ans = (x + y + addBit) % 2 + ans;
            addBit = (x + y + addBit) / 2;
            i--;
            j--;
        }
        return ans;
    }
}
