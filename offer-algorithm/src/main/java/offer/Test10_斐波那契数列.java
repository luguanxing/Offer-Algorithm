package offer;

public class Test10_斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(new Solution().Fibonacci(3));
    }

    static class Solution {
        public int Fibonacci(int n) {
            int[] fibs = new int[40];
            fibs[0] = 0;
            fibs[1] = 1;
            for (int i = 2; i <= 39; i++) {
                fibs[i] = fibs[i-1] + fibs[i-2];
            }
            return fibs[n];
        }
    }

}
