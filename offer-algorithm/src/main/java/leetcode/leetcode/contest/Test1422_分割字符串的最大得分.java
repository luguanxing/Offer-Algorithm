package leetcode.leetcode.contest;

public class Test1422_分割字符串的最大得分 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("011101"));
        System.out.println(new Solution().maxScore("00111"));
        System.out.println(new Solution().maxScore("00"));
    }

    static class Solution {
        public int maxScore(String s) {
            if (s == null) {
                return 0;
            }
            // 首轮计分
            int sum = 0;
            if (s.charAt(0) == '0') {
                sum++;
            }
            for (char c : s.substring(1, s.length()).toCharArray()) {
                if (c == '1') {
                    sum++;
                }
            }
            // 找最大值
            int max = sum;
            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i) == '1') {
                    // 左边计分不加，右边计分减一，总分减一
                    sum--;
                } else {
                    // 左边计分加一，右边计分不减，总分加一
                    sum++;
                }
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}
