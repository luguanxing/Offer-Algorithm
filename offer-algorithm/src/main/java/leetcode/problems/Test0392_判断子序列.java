package leetcode.problems;

public class Test0392_判断子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("acb", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", ""));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            char[] source = s.toCharArray();
            char[] target = t.toCharArray();
            int tIndex = 0;
            for (int i = 0; i < source.length; i++) {
                char sChar = source[i];
                boolean isMatch = false;
                while (tIndex < target.length) {
                    char tTarget = target[tIndex++];
                    if (sChar == tTarget) {
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    return false;
                }
            }
            return true;
        }
    }

}
