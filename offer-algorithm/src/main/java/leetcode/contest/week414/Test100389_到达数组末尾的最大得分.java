package leetcode.contest.week414;

import java.util.Arrays;
import java.util.List;

public class Test100389_到达数组末尾的最大得分 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumScore(Arrays.asList(1, 3, 1, 5)));
        System.out.println(new Solution().findMaximumScore(Arrays.asList(4, 3, 1, 3, 2)));
    }

    static class Solution {
        public long findMaximumScore(List<Integer> nums) {
            long ans = 0;
            long currentMax = 0;
            for (int num : nums) {
                ans += currentMax;
                currentMax = Math.max(currentMax, num);
            }
            return ans;
        }
    }

}
