package leetcode.problems;

public class Test0791_自定义字符串排序 {

    public static void main(String[] args) {
        System.out.println(new Solution().customSortString("cba", "abcd"));
        System.out.println(new Solution().customSortString("cbafg", "abcd"));
    }

    static class Solution {
        public String customSortString(String order, String s) {
            int[] cntMap = new int[26];
            for (char c : s.toCharArray()) {
                cntMap[c - 'a']++;
            }
            StringBuilder res = new StringBuilder();
            for (char o : order.toCharArray()) {
                while (cntMap[o - 'a'] > 0) {
                    res.append(o);
                    cntMap[o - 'a']--;
                }
            }
            // 加上剩下的
            for (int i = 0; i < 26; i++) {
                while (cntMap[i]-- > 0) {
                    res.append((char)('a' + i));
                }
            }
            return res.toString();
        }
    }

}
