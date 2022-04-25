package No_38外观数列;

public class Solution {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("最怕空气突然安静");
    }

    public String countAndSay(int n) {
        String ans = "1";

        for (int i = 1; i < n; i++) {
            String newAns = "";
            char newChar = ans.charAt(0);
            int count = 0;

            for (int j = 0; j < ans.length(); j++) {
                if (newChar == ans.charAt(j)) {
                    count++;
                } else {
                    newAns = newAns + count + newChar;
                    newChar = ans.charAt(j);
                    count = 1;
                }
            }
            newAns = newAns + count + newChar;
            ans = newAns;
        }
        return ans;
    }
}
