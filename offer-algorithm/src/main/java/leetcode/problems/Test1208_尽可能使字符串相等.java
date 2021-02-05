package leetcode.problems;

public class Test1208_尽可能使字符串相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().equalSubstring("abcd", "bcdf", 3));
        System.out.println(new Solution().equalSubstring("abcd", "cdef", 3));
        System.out.println(new Solution().equalSubstring("abcd", "acde", 0));
    }

    static class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int[] diff = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }
            int left = 0;
            int right = 0;
            int sum = 0;
            int res = 0;
            while (right < diff.length) {
                sum += diff[right++];
                while (sum > maxCost) {
                    sum -= diff[left++];
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }

}
