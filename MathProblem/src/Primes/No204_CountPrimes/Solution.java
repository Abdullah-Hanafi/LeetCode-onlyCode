package Primes.No204_CountPrimes;

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        int count = n - 2;
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
