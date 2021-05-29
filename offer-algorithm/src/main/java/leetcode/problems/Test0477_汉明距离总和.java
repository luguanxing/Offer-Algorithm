package leetcode.problems;

public class Test0477_汉明距离总和 {

    public static void main(String[] args) {
        System.out.println(new Solution().totalHammingDistance(
                new int[]{4, 14, 2}
        ));
        System.out.println(new Solution().totalHammingDistance(
                new int[]{1, 2, 3, 4, 5}
        ));
    }

    static class Solution {
        public int totalHammingDistance(int[] nums) {
            int[] bits0 = new int[32];
            int[] bits1 = new int[32];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                String str = getBitString(num);
                for (int j = 0; j < 32; j++) {
                    if (str.charAt(j) == '0') {
                        bits0[j]++;
                    } else {
                        bits1[j]++;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res += bits0[i] * bits1[i];
                res += bits1[i] * bits0[i];
            }
            return res / 2;
        }

        public String getBitString(int num) {
            String s = Integer.toBinaryString(num);
            while (s.length() < 32) {
                s = "0" + s;
            }
            return s;
        }
    }

}
