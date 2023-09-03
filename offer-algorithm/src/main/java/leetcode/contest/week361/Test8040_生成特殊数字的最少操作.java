package leetcode.contest.week361;

public class Test8040_生成特殊数字的最少操作 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations("2245047"));
        System.out.println(new Solution().minimumOperations("2908305"));
        System.out.println(new Solution().minimumOperations("10"));
        System.out.println(new Solution().minimumOperations("528033"));
        System.out.println(new Solution().minimumOperations("820366"));
    }

    static class Solution {
        public int minimumOperations(String num) {
            int len = num.length();
            int ans = num.length();
            if (len == 2) {
                if (num.equals("25") || num.equals("50") || num.equals("75")) {
                    return 0;
                } else if (num.contains("0")) {
                    return 1;
                }
            }

            for (int i = 2; i <= len; i++) {
                int[] map = new int[10];
                for (int j = len - i; j < len; j++) {
                    int c = num.charAt(j) - '0';
                    // Check 25
                    if (c == 5 && map[2] > 0) {
                        return i - 2;
                    }
                    // Check 50
                    if (c == 0 && map[5] > 0) {
                        return i - 2;
                    }
                    // Check 75
                    if (c == 5 && map[7] > 0) {
                        return i - 2;
                    }
                    map[c]++;
                }
                // Check 00
                if (map[0] >= 2) {
                    return i - 2;
                }
            }
            if (num.contains("0")) {
                ans = Math.min(ans, len - 1);
            }
            return ans;
        }
    }

}
