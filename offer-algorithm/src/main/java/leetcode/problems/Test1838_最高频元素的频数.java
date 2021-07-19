package leetcode.problems;

import java.util.Arrays;

public class Test1838_最高频元素的频数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxFrequency(
                new int[]{1, 2, 4}, 5
        ));
        System.out.println(new Solution().maxFrequency(
                new int[]{1, 4, 8, 13}, 5
        ));
        System.out.println(new Solution().maxFrequency(
                new int[]{3, 9, 6}, 2
        ));
        System.out.println(new Solution().maxFrequency(
                new int[]{9926, 9960, 10000, 9992, 9917, 9986, 9934, 9985, 9977, 9950, 9922, 9913, 9971, 9978, 9984, 9959, 9934, 9948, 9918, 9916, 9967, 9965, 9985, 9977, 9988, 9983, 9900, 9945, 9913, 9966, 9968, 9986, 9939, 9914, 9980, 9957, 9921, 9927, 9917, 9972, 9974, 9953, 9984, 9912, 9975, 9920, 9966, 9932, 9921, 9904, 9928, 9959, 9993, 9937, 9934, 9974, 9937, 9964, 9922, 9963, 9991, 9930, 9944, 9930, 9982, 9980, 9967, 9904, 9955, 9947, 9924, 9973, 9997, 9950, 9905, 9924, 9990, 9947, 9953, 9924, 9977, 9938, 9951, 9982, 9932, 9926, 9928, 9912, 9917, 9929, 9924, 9921, 9987, 9910, 9927, 9921, 9929, 9937, 9919, 9995, 9949, 9953}, 3044
        ));
        System.out.println(new Solution().maxFrequency(
                new int[]{1, 1, 1, 2, 2, 2, 3, 3}, 6
        ));
    }

    static class Solution {
        public int maxFrequency(int[] nums, int k) {
            // 先排序
            Arrays.sort(nums);
            // 使用滑动窗口判断是否能让窗口内的差小于k
            int left = 0;
            int right = 1;
            int res = 1;
            int lastNum = nums[0];
            int lastCnt = 1;
            long diff = 0;
            while (right < nums.length) {
                diff += lastCnt * (nums[right] - lastNum);
                lastNum = nums[right];
                lastCnt++;
                right++;
                while (diff > k && left < right) {
                    diff -= lastNum - nums[left];
                    left++;
                    lastCnt--;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }

}
