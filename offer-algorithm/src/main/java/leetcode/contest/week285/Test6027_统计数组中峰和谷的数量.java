package leetcode.contest.week285;

public class Test6027_统计数组中峰和谷的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
        System.out.println(new Solution().countHillValley(new int[]{6, 6, 5, 5, 4, 1}));
        System.out.println(new Solution().countHillValley(new int[]{8, 2, 5, 7, 7, 2, 10, 3, 6, 2}));
    }

    static class Solution {
        public int countHillValley(int[] nums) {
            int len = nums.length;
            int res = 0;
            for (int i = 1; i < len - 1; i++) {
                int smallCnt = 0;
                int largeCnt = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        smallCnt++;
                        break;
                    }
                    if (nums[j] > nums[i]) {
                        largeCnt++;
                        break;
                    }
                }
                for (int j = i + 1; j < len; j++) {
                    if (nums[j] < nums[i]) {
                        smallCnt++;
                        break;
                    }
                    if (nums[j] > nums[i]) {
                        largeCnt++;
                        break;
                    }
                }
                if ((smallCnt == 2 && largeCnt == 0) || (largeCnt == 2 && smallCnt == 0)) {
                    if (nums[i] != nums[i - 1]) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
