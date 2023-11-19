package leetcode.contest.week372;

public class Test100131_使三个字符串相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinimumOperations("abc", "abb", "ab"));
        System.out.println(new Solution().findMinimumOperations("dac", "bac", "cac"));
    }

    static class Solution {
        public int findMinimumOperations(String s1, String s2, String s3) {
            int commonLen = 0;
            for (int i = 0; i < Math.min(Math.min(s1.length(), s2.length()), s3.length()); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                char c3 = s3.charAt(i);
                if (c1 == c2 && c2 == c3) {
                    commonLen++;
                } else {
                    break;
                }
            }
            if (commonLen == 0) {
                return -1;
            }
            return s1.length() + s2.length() + s3.length() - 3 * commonLen;
        }
    }

}
