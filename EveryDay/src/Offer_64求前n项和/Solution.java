package Offer_64求前n项和;

class Solution {
    int[] test=new int[]{0};
    public int sumNums(int n) {
        try{
            return test[n];
        }catch(Exception e){
            return n+sumNums(n-1);
        }
    }
}

/*
class Solution {
    int[] test=new int[]{0};
    public int sumNums(int n) {
        boolean flag = n > 0 && (n + sumNums(n - 1))>0;
        return n;
    }
}
 */