package leetcode.contest.week308;

public class Test6161_从字符串中移除星号 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
        System.out.println(new Solution().removeStars("erase*****"));
    }

    static class Solution {
        public String removeStars(String s) {
            StringBuilder sb = new StringBuilder("");
            for (Character c : s.toCharArray()) {
                if (c != '*') {
                    sb.append(c);
                    continue;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }

}
