package leetcode.contest.week315;

public class Test6204_与对应负数同时存在的最大正整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxK(new int[]{-1, 2, -3, 3}));
        System.out.println(new Solution().findMaxK(new int[]{-1, 10, 6, 7, -7, 1}));
        System.out.println(new Solution().findMaxK(new int[]{-10, 8, 6, 7, -2, -3}));
    }

    static class Solution {
        public int findMaxK(int[] nums) {
            int MAX = 1005;
            boolean[] flags1 = new boolean[MAX];
            boolean[] flags2 = new boolean[MAX];
            for (int num : nums) {
                if (num > 0) {
                    flags1[num] = true;
                } else {
                    flags2[-num] = true;
                }
            }
            for (int i = MAX - 1; i >= 1; i--) {
                if (flags1[i] && flags2[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

}
