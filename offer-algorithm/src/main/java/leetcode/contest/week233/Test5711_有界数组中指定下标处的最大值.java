package leetcode.contest.week233;

public class Test5711_有界数组中指定下标处的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(4, 2, 6));
        System.out.println(new Solution().maxValue(6, 1, 10));
        System.out.println(new Solution().maxValue(3, 2, 18));
    }

    static class Solution {
        public int maxValue(int n, int index, int maxSum) {
            if (maxSum <= n) {
                return 1;
            }
            // 每位先设置1，剩下从1,2,3堆积到maxSum
            maxSum -= n;
            int max = 0;
            for (int i = 1; i <= 10005; i++) {
                if (i * (i + 1) / 2 >= maxSum) {
                    max = i;
                    break;
                }
            }
            int delta = max * (max + 1) / 2 - maxSum;
            if (delta == 0) {
                return  Math.max(max, index) + 1;
            } else {
                return Math.max(max, index);
            }
        }
    }

}
