package leetcode.contest.week401;

public class Test100325_找出K秒后拿着球的孩子 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfChild(3, 5));
        System.out.println(new Solution().numberOfChild(5, 6));
        System.out.println(new Solution().numberOfChild(4, 2));
    }

    static class Solution {
        public int numberOfChild(int n, int k) {
            boolean isRight = true;
            int current = 0;
            for (int i = 0; i < k; i++) {
                if (isRight) {
                    current++;
                    if (current == n - 1) {
                        isRight = false;
                    }
                } else {
                    current--;
                    if (current == 0) {
                        isRight = true;
                    }
                }
            }
            return current;
        }
    }

}
