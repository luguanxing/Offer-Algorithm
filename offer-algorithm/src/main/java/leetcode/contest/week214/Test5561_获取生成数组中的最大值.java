package leetcode.contest.week214;

import java.util.Arrays;

public class Test5561_获取生成数组中的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumGenerated(7));
        System.out.println(new Solution().getMaximumGenerated(2));
        System.out.println(new Solution().getMaximumGenerated(3));
        System.out.println(new Solution().getMaximumGenerated(0));
        System.out.println(new Solution().getMaximumGenerated(2));
    }

    static class Solution {
        public int getMaximumGenerated(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            int[] res = new int[n + 1];
            res[0] = 0;
            res[1] = 1;
            for (int i = 2; i <= n; i++) {
                if (i % 2 == 0) {
                    res[i] = res[i / 2];
                } else {
                    int index = (i - 1) / 2;
                    res[i] = res[index] + res[index + 1];
                }
            }
            return Arrays.stream(res).max().orElse(0);
        }
    }

}
