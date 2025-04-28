package leetcode.problems;

public class Test2302_统计得分小于K的子数组数目 {

    public static void main(String[] args) {
        // nums = [2,1,4,3,5], k = 10
        System.out.println(new Solution().countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));
        // nums = [1,1,1], k = 5
        System.out.println(new Solution().countSubarrays(new int[]{1, 1, 1}, 5));
    }

    static class Solution {
        public long countSubarrays(int[] nums, long k) {
            int len = nums.length;
            long res = 0;
            int l = 0;
            int r = 0;
            long sum = 0;
            int cnt = 0;
            while (r < len) {
                sum += nums[r++];
                cnt++;
                while (sum*cnt >= k && l < r) {
                    sum -= nums[l++];
                    cnt--;
                }
                res += (r-l);
            }
            return res;
        }
    }

}
