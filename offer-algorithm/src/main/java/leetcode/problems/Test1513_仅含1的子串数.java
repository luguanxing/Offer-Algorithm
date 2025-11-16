package leetcode.problems;

public class Test1513_仅含1的子串数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numSub("0110111"));
        System.out.println(new Solution().numSub("101"));
        System.out.println(new Solution().numSub("111111"));
        System.out.println(new Solution().numSub("000"));
    }

    static class Solution {
        public int numSub(String s) {
            int MOD = (int) 1e9 + 7;
            int res = 0;
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    res += (int) (((long) count * (count + 1) / 2) % MOD);
                    count = 0;
                } else {
                    count++;
                }
            }
            res += (int) (((long) count * (count + 1) / 2) % MOD);
            return res;
        }
    }

    static class Solution_字符串 {
        public int numSub(String s) {
            int MOD = (int) 1e9 + 7;
            int res = 0;
            for (String subStr : s.split("0")) {
                if (subStr.isEmpty()) {
                    continue;
                }
                int len = subStr.length();
                res += (int) (((long) len * (len + 1) / 2) % MOD);
            }
            return res;
        }
    }

}
