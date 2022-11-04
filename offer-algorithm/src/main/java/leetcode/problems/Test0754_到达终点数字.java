package leetcode.problems;

public class Test0754_到达终点数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().reachNumber(2));
        System.out.println(new Solution().reachNumber(3));
        System.out.println(new Solution().reachNumber(4));
    }

    static class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int sum = 0;
            int step = 0;
            // 1+2+... -k +...step = sum(1, step)-2*k = target
            // 所以要求sum(1, step)=2*k为偶数即可
            while (sum < target || (sum - target) % 2 == 1) {
                step++;
                sum += step;
            }
            return step;
        }
    }

}
