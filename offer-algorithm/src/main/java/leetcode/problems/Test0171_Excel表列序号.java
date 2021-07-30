package leetcode.problems;

public class Test0171_Excel表列序号 {

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("A"));
        System.out.println(new Solution().titleToNumber("AB"));
        System.out.println(new Solution().titleToNumber("ZY"));
        System.out.println(new Solution().titleToNumber("FXSHRXW"));
    }

    static class Solution {
        public int titleToNumber(String columnTitle) {
            int res = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                char c = columnTitle.charAt(columnTitle.length() - 1 - i);
                int num = (c - 'A' + 1);
                int turn = i;
                while (turn-- > 0) {
                    num *= 26;
                }
                res += num;
            }
            return res;
        }
    }

}
