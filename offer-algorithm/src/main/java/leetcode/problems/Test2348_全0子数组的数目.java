package leetcode.problems;

public class Test2348_全0子数组的数目 {

    public static void main(String[] args) {
        // nums = [1,3,0,0,2,0,0,4]
        System.out.println(new Solution().zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
        // nums = [0,0,0,2,0,0]
        System.out.println(new Solution().zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
    }

    static class Solution {
        public long zeroFilledSubarray(int[] nums) {
            int len = nums.length;
            long res = 0;
            for (int i = 0; i < len; i++) {
                int cnt0 = 0;
                while (i < len && nums[i] == 0) {
                    cnt0++;
                    res += cnt0;
                    i++;
                }
            }
            return res;
        }
    }

    static class Solution_OLD {
        public long zeroFilledSubarray(int[] nums) {
            long res = 0;
            int cnt0 = 0;
            for (int num : nums) {
                if (num == 0) {
                    cnt0++;
                } else {
                    res += (long) cnt0 * (cnt0 + 1) / 2;
                    cnt0 = 0;
                }
            }
            res += (long) cnt0 * (cnt0 + 1) / 2;
            return res;
        }
    }

}
