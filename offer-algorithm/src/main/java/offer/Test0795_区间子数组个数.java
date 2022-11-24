package offer;

public class Test0795_区间子数组个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarrayBoundedMax(
                new int[]{2, 1, 4, 3}, 2, 3
        ));
        System.out.println(new Solution().numSubarrayBoundedMax(
                new int[]{2, 9, 2, 5, 6}, 2, 8
        ));
        System.out.println(new Solution().numSubarrayBoundedMax(
                new int[]{2, 1, 1, 3}, 2, 3
        ));
        System.out.println(new Solution().numSubarrayBoundedMax(
                new int[]{2, 1, 1, 3, 1}, 2, 3
        ));
    }

    static class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int res = 0;
            int size = 0;
            int small = 0;
            // 对于每个数，计算与前面范围内的数结合时能产生的答案数
            // 1. 若当前数在范围内，窗口长度加一，最后的小数个数清0
            // 2. 若当前数小于left，窗口长度加一，最后的小数个数加一
            // 3. 若当前数大于right，窗口清0，最后的小数个数清0
            // 与前面范围内的数结合时能产生的答案数 = 窗口长度 - 最后的小数个数
            for (int num : nums) {
                if (left <= num && num <= right) {
                    size++;
                    small = 0;
                } else if (num < left) {
                    size++;
                    small++;
                } else {
                    size = 0;
                    small = 0;
                }
                res += size - small;
            }
            return res;
        }
    }

}
