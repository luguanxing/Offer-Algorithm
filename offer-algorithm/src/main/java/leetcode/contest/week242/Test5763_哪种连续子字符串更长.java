package leetcode.contest.week242;

public class Test5763_哪种连续子字符串更长 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkZeroOnes("1101"));
        System.out.println(new Solution().checkZeroOnes("111000"));
        System.out.println(new Solution().checkZeroOnes("110100010"));
    }

    static class Solution {
        public boolean checkZeroOnes(String s) {
            int max1 = 0;
            int max0 = 0;
            int cur1 = 0;
            int cur0 = 0;
            Character last = null;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    if (last == null || last == '1') {
                        cur1++;
                    } else {
                        cur1 = 1;
                    }
                    last = '1';
                } else {
                    if (last == null || last == '0') {
                        cur0++;
                    } else {
                        cur0 = 1;
                    }
                    last = '0';
                }
                max1 = Math.max(max1, cur1);
                max0 = Math.max(max0, cur0);
            }
            return max1 > max0;
        }
    }

}
