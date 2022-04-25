package No_1769移动所有球到每个盒子所需的最小操作数;

class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        int left = 0;
        int right = 0;
        int total = 0;
        if(boxes.charAt(0) == '1') left++;

        for(int i = 1; i < boxes.length(); i++){
            if(boxes.charAt(i) == '1'){
                right++;
                total += i;
            }
        }
        answer[0] = total;

        for(int i = 1; i < boxes.length(); i++){
            total = total + left - right;
            if(boxes.charAt(i) == '1'){
                left++;
                right--;
            }
            answer[i] = total;
        }

        return answer;

    }
}
