package Day1.No374_GuessNumberHigherOrLower;

/**
 * @author Cheng Shuaihu
 * @version 1.0
 * @date 2022/4/8 11:22
 */
public class Solution {
    public static void main(String[] args) {
        int answer = guessNumber(2,2);
        System.out.println(answer);
    }

    public static int guessNumber(int n, int pick) {
        int left = 1;
        int right = n;
        int answer = 0;
        while (left <= right) {
            int num = left + (right - left + 1) / 2;
            if (guess(pick, num) == 0) {
                answer = num;
            } else if (guess(pick, num) > 0) {
                left = num + 1;
            } else {
                right = num - 1;
            }
            if (guess(pick,num) == 0){
                break;
            }
        }
        return answer;
    }


    public static int guess(int pick, int num) {
        if (pick < num) {
            return -1;
        } else if (pick == num) {
            return 0;
        } else {
            return 1;
        }
    }
}
