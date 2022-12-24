package leetcode.problems;

public class Test1754_构造字典序最大的合并字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestMerge("cabaa", "bcaaa"));
        System.out.println(new Solution().largestMerge("abcabc", "abdcaba"));
        System.out.println(new Solution().largestMerge("ab", "abc"));
        System.out.println(new Solution().largestMerge("bc", "bca"));
    }

    static class Solution {
        public String largestMerge(String word1, String word2) {
            String res = "";
            int index1 = 0;
            int index2 = 0;
            while (index1 < word1.length() || index2 < word2.length()) {
                if (index1 < word1.length() && word1.substring(index1).compareTo(word2.substring(index2)) > 0) {
                    res += word1.charAt(index1);
                    index1++;
                } else {
                    res += word2.charAt(index2);
                    index2++;
                }
            }
            return res;
        }
    }

}
