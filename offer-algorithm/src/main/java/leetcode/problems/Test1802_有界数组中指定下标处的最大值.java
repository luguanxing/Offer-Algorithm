package leetcode.problems;

public class Test1802_有界数组中指定下标处的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(4, 2, 6));
        System.out.println(new Solution().maxValue(6, 1, 10));
        System.out.println(new Solution().maxValue(8, 7, 14));
        System.out.println(new Solution().maxValue(3, 2, 18));
        System.out.println(new Solution().maxValue(4, 0, 4));
        System.out.println(new Solution().maxValue(4, 3, 4));
        System.out.println(new Solution().maxValue(5, 0, 28));
    }

    static class Solution {
        public int maxValue(int n, int index, int maxSum) {
            // 使用二分试出能满足和小于maxSum的最大x
            int max = Integer.MAX_VALUE;
            int min = 0;
            while (min < max) {
                int mid = (max + min) / 2;
                long sum = getSum(n, index, mid);
                if (sum <= maxSum) {
                    // 满足条件，尝试增大x
                    min = mid + 1;
                } else {
                    // 不满足条件，尝试减小x
                    max = mid;
                }
            }
            return max - 1;
        }

        public long getSum(int n, int index, int x) {
            // index上的数为x，左右递减直到1，求出数组该和
            long sum = x;
            // 左侧求和
            if (index >= x) {
                sum += (long) (x - 1 + 0) * x / 2;
                sum += index - x + 1;
            } else {
                sum += (long) (x - 1 + x - 1 - (index - 1)) * index / 2;
            }
            // 右侧求和
            if (n - index - 1 >= x) {
                sum += (long) (x - 1 + 0) * x / 2;
                sum += n - index - x;
            } else {
                sum += (long) (x - 1 + (x - (n - index - 1))) * (n - index - 1) / 2;
            }
            return sum;
        }
    }

}
