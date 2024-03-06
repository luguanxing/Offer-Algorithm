package leetcode.problems;

public class Test2917_找出数组中的Kor值 {

    public static void main(String[] args) {
        // nums = [7,12,9,8,9,15], k = 4
        System.out.println(new Solution().findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
        // nums = [2,12,1,11,4,5], k = 6
        System.out.println(new Solution().findKOr(new int[]{2, 12, 1, 11, 4, 5}, 6));
        // nums = [10,8,5,9,11,6,8], k = 1
        System.out.println(new Solution().findKOr(new int[]{10, 8, 5, 9, 11, 6, 8}, 1));
        // nums = [14,7,12,9,8,9,1,15], k = 4
        System.out.println(new Solution().findKOr(new int[]{14, 7, 12, 9, 8, 9, 1, 15}, 4));
    }

    static class Solution {
        public int findKOr(int[] nums, int k) {
            int[] cnt = new int[32];
            for (int num : nums) {
                for (int idx = 0; idx < 32; idx++) {
                    if ((num & (1 << idx)) != 0) {
                        cnt[idx]++;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < 32; i++) {
                if (cnt[i] >= k) {
                    res += (1 << i);
                }
            }
            return res;
        }
    }

}
