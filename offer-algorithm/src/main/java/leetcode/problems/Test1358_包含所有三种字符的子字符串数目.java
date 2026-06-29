package leetcode.problems;

public class Test1358_包含所有三种字符的子字符串数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubstrings("abcabc"));
        System.out.println(new Solution().numberOfSubstrings("aaacb"));
        System.out.println(new Solution().numberOfSubstrings("abc"));
    }

    static class Solution {
        public int numberOfSubstrings(String s) {
            int len = s.length();
            int[] abc = new int[3];
            int l = 0, r = 0;
            int res = 0;
            while (r < len) {
                abc[s.charAt(r)-'a']++;
                r++;
                while (abc[0] > 0 && abc[1] > 0 && abc[2] > 0) {
                    res += len - r + 1;
                    abc[s.charAt(l)-'a']--;
                    l++;
                }
            }
            return res;
        }
    }

}
