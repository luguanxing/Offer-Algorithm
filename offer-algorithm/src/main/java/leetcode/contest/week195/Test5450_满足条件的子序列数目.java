package leetcode.contest.week195;

import java.math.BigInteger;
import java.util.Arrays;

public class Test5450_满足条件的子序列数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(new Solution().numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(new Solution().numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println(new Solution().numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16));
    }

    static class Solution {
        public int numSubseq(int[] nums, int target) {
            // 先排序
            Arrays.sort(nums);
            // 确定范围，需要使用二分搜索加速
            BigInteger res = new BigInteger("0");
            for (int i = 0; i < nums.length; i++) {
                int left = i;
                int right = nums.length;
                while (right - left > 1) {
                    int mid = (left + right) / 2;
                    if (nums[i] + nums[mid] <= target) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                if (nums[i] + nums[left] <= target) {
                    res = res.add(new BigInteger("2").pow(left - i));
                }
            }
            return res.mod(new BigInteger("1000000007")).intValue();
        }
    }

}
