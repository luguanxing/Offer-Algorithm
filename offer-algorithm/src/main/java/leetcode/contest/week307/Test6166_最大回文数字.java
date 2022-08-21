package leetcode.contest.week307;

public class Test6166_最大回文数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestPalindromic("444947137"));
        System.out.println(new Solution().largestPalindromic("00009"));
        System.out.println(new Solution().largestPalindromic("00001105"));
        System.out.println(new Solution().largestPalindromic("00000"));
        System.out.println(new Solution().largestPalindromic("0000"));
    }

    static class Solution {
        public String largestPalindromic(String num) {
            int[] map = new int[10];
            for (char c : num.toCharArray()) {
                map[c - '0']++;
            }
            int once = -1;
            for (int i = 9; i >= 0; i--) {
                if (map[i] % 2 == 1) {
                    once = i;
                    map[i]--;
                    break;
                }
            }
            StringBuilder front = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                int iCnt = map[i];
                for (int j = 0; j < iCnt / 2; j++) {
                    front.append(i);
                }
            }
            StringBuilder back = new StringBuilder(front).reverse();
            StringBuilder res = new StringBuilder();
            if (once != -1) {
                res.append(once);
            }
            res.insert(0, front);
            res.append(back);
            while (res.length() > 1 && res.charAt(0) == '0') {
                res.deleteCharAt(0);
                res.deleteCharAt(res.length() - 1);
            }
            return res.length() == 0 ? "0" : res.toString();
        }
    }

}
