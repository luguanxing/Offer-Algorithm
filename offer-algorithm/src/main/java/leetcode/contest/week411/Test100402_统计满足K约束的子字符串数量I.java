package leetcode.contest.week411;

public class Test100402_统计满足K约束的子字符串数量I {

    public static void main(String[] args) {
        // s = "10101", k = 1
        System.out.println(new Solution().countKConstraintSubstrings("10101", 1));
        // s = "1010101", k = 2
        System.out.println(new Solution().countKConstraintSubstrings("1010101", 2));
        // s = "11111", k = 1
        System.out.println(new Solution().countKConstraintSubstrings("11111", 1));
    }

    static class Solution {
        public int countKConstraintSubstrings(String s, int k) {
            int len = s.length();
            int res = 0;
            for (int i = 0; i <= len; i++) {
                for (int j = 0; j < i; j++) {
                    String subStr = s.substring(j, i);
                    int cnt0 = 0;
                    int cnt1 = 0;
                    for (char c : subStr.toCharArray()) {
                        if (c == '0') {
                            cnt0++;
                        } else {
                            cnt1++;
                        }
                    }
                    if (cnt0 <= k || cnt1 <= k) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
