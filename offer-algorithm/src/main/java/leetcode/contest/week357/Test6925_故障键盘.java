package leetcode.contest.week357;

public class Test6925_故障键盘 {

    public static void main(String[] args) {
        System.out.println(new Solution().finalString("string"));
        System.out.println(new Solution().finalString("poiinter"));
    }

    static class Solution {
        public String finalString(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != 'i') {
                    sb.append(c);
                } else {
                    sb = sb.reverse();
                }
            }
            return sb.toString();
        }
    }

}
