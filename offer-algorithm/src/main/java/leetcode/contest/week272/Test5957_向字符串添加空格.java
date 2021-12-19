package leetcode.contest.week272;

public class Test5957_向字符串添加空格 {

    public static void main(String[] args) {
        System.out.println(new Solution().addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
        System.out.println(new Solution().addSpaces("icodeinpython", new int[]{1, 5, 7, 9}));
        System.out.println(new Solution().addSpaces("spacing", new int[]{0, 1, 2, 3, 4, 5, 6}));
    }

    static class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder(s);
            int index = 0;
            for (int space : spaces) {
                sb = sb.insert(space + index++, ' ');
            }
            return sb.toString();
        }
    }

}
