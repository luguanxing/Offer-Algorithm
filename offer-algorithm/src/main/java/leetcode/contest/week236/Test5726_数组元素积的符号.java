package leetcode.contest.week236;

public class Test5726_数组元素积的符号 {

    public static void main(String[] args) {
        System.out.println(new Solution().arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        System.out.println(new Solution().arraySign(new int[]{1, 5, 0, 2, -3}));
        System.out.println(new Solution().arraySign(new int[]{-1, 1, -1, 1, -1}));
    }

    static class Solution {
        public int arraySign(int[] nums) {
            int res = 1;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                } else if (num > 0) {
                    res *= 1;
                } else {
                    res *= -1;
                }
            }
            return res;
        }
    }

}
