package leetcode.contest.week424;

public class Test100460_使数组元素等于零 {

    public static void main(String[] args) {
        System.out.println(new Solution().countValidSelections(new int[]{1, 0, 2, 0, 3}));
        System.out.println(new Solution().countValidSelections(new int[]{2, 3, 4, 0, 4, 1, 0}));
    }

    static class Solution {
        public int countValidSelections(int[] nums) {
            int len = nums.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) {
                    int lSum = 0;
                    int rSum = 0;
                    for (int j = i - 1; j >= 0; j--) {
                        lSum += nums[j];
                    }
                    for (int j = i + 1; j < len; j++) {
                        rSum += nums[j];
                    }
                    if (lSum == rSum) {
                        res += 2;
                    } else if (Math.abs(lSum - rSum) == 1) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
