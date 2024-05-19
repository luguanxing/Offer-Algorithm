package leetcode.contest.week398;

public class Test100300_所有数对中数位不同之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumDigitDifferences(new int[]{13, 23, 12}));
        System.out.println(new Solution().sumDigitDifferences(new int[]{10, 10, 10, 10}));
        System.out.println(new Solution().sumDigitDifferences(new int[]{50, 28, 48}));
        System.out.println(new Solution().sumDigitDifferences(new int[]{824, 843, 837, 620, 836, 234, 276, 859}));
    }

    static class Solution {
        public long sumDigitDifferences(int[] nums) {
            int len = (nums[0] + "").length();
            int[][] map = new int[len][10];
            for (int num : nums) {
                String numStr = num + "";
                for (int i = 0; i < len; i++) {
                    map[i][numStr.charAt(i) - '0']++;
                }
            }
            long res = 0;
            for (int[] cnts : map) {
                for (int i = 0; i < 10; i++) {
                    for (int j = i + 1; j < 10; j++) {
                        res += (long) cnts[i] * cnts[j];
                    }
                }
            }
            return res;
        }
    }
}
