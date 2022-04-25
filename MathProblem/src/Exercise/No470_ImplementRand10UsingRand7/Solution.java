package Exercise.No470_ImplementRand10UsingRand7;

import java.util.Random;


public class Solution {
    public int rand7() {
        return 1;
    }
}

class Solution1 extends Solution {
    public int rand10() {
        int row;
        int col;
        int value;
        do {
            row = rand7();
            col = rand7();
            value = (row - 1) * 7 + col;
        } while (value > 40);
        return value % 10 == 0 ? 10 : value % 10;
    }

    public int rand1() {
        int first;
        int second;
        do {
            first = rand7();
        } while (first > 6);

        do {
            second = rand7();
        } while (second > 5);

        return first % 2 == 1 ? second : 5 + second;
    }
}
