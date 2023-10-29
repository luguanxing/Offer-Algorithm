package leetcode.contest.week369;

public class Test100111_找出数组中的K_or值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
        System.out.println(new Solution().findKOr(new int[]{2, 12, 1, 11, 4, 5}, 6));
        System.out.println(new Solution().findKOr(new int[]{10, 8, 5, 9, 11, 6, 8}, 1));
    }

    static class Solution {
        public int findKOr(int[] nums, int k) {
            int kor = 0;
            for (int d = 0; d <= 31; d++) {
                int cnt = 0;
                for (int num : nums) {
                    if ((num & (1 << d)) > 0) {
                        cnt++;
                    }
                }
                if (cnt >= k) {
                    kor |= (1 << d);
                }
            }
            return kor;
        }
    }
}
