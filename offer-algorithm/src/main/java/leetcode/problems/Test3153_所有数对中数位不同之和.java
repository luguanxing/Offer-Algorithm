package leetcode.problems;

public class Test3153_所有数对中数位不同之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumDigitDifferences(new int[]{13, 23, 12}));
        System.out.println(new Solution().sumDigitDifferences(new int[]{10, 10, 10, 10}));
    }

    static class Solution {
        public long sumDigitDifferences(int[] nums) {
            int len = String.valueOf(nums[0]).length();
            // map用于统计每一位上0-10的频数，最多len位数
            int[][] numCntMap = new int[len][10];
            for (int num : nums) {
                // 统计每一位上的频数
                for (int i = 0; i < len; i++) {
                    numCntMap[i][num % 10]++;
                    num /= 10;
                }
            }
            // 计算每位上和其它不同的数的和
            long res = 0;
            for (int[] numCnt : numCntMap) {
                for (int x = 0; x < 10; x++) {
                    for (int y = x + 1; y < 10; y++) {
                        res += (long) numCnt[x] * numCnt[y];
                    }
                }
            }
            return res;
        }
    }

}
