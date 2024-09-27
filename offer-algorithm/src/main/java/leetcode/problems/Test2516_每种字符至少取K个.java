package leetcode.problems;

public class Test2516_每种字符至少取K个 {

    public static void main(String[] args) {
        System.out.println(new Solution().takeCharacters("aabaaaacaabc", 2));
        System.out.println(new Solution().takeCharacters("a", 1));
    }

    static class Solution {
        public int takeCharacters(String s, int k) {
            // 每个字符至少k个，相当于求里面子串最多cnt-k个的最长长度
            int[] cnts = new int[3];
            for (char c : s.toCharArray()) {
                cnts[c - 'a']++;
            }
            for (int cnt : cnts) {
                if (cnt < k) {
                    return -1;
                }
            }
            // 滑动窗口求子串最长窗口
            int[] currentCnts = new int[3];
            int l = 0;
            int r = 0;
            int res = Integer.MAX_VALUE;
            while (r < s.length()) {
                currentCnts[s.charAt(r++) - 'a']++;
                while (l < r && !isOk(currentCnts, cnts, k)) {
                    currentCnts[s.charAt(l++) - 'a']--;
                }
                res = Math.min(res, s.length() - (r - l));
            }
            return res;
        }

        private boolean isOk(int[] currentCnts, int[] cnts, int k) {
            // 每个字符至多有cnt-k个
            for (int i = 0; i < currentCnts.length; i++) {
                if (currentCnts[i] > cnts[i] - k) {
                    return false;
                }
            }
            return true;
        }
    }

}
