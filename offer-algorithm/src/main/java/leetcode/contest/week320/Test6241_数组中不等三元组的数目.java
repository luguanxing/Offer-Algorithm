package leetcode.contest.week320;

public class Test6241_数组中不等三元组的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        System.out.println(new Solution().unequalTriplets(new int[]{1, 1, 1, 1, 1}));
    }

    static class Solution {
        public int unequalTriplets(int[] nums) {
            int cnt = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }

}
