package leetcode.contest.week261;

public class Test5890_转换字符串的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumMoves("XXX"));
        System.out.println(new Solution().minimumMoves("XXOX"));
        System.out.println(new Solution().minimumMoves("OOOO"));
        System.out.println(new Solution().minimumMoves("OXOX"));
        System.out.println(new Solution().minimumMoves("OOOXOX"));
        System.out.println(new Solution().minimumMoves("OOOOXOX"));
    }

    static class Solution {
        public int minimumMoves(String s) {
            int res = 0;
            int len = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0; i < len; i++) {
                if (chars[i] == 'X') {
                    res++;
                    for (int j = i; j < Math.min(i + 3, len); j++) {
                        chars[j] = 'O';
                    }
                }
            }
            return res;
        }
    }

}
