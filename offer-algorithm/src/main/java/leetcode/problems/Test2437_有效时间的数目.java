package leetcode.problems;

public class Test2437_有效时间的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countTime("?5:00"));
        System.out.println(new Solution().countTime("0?:0?"));
        System.out.println(new Solution().countTime("??:??"));
    }

    static class Solution {
        public int countTime(String time) {
            int cnt = 0;
            for (int i = 0; i < 24 * 60; i++) {
                String t = getTimeStr(i);
                if (isLike(t, time)) {
                    cnt++;
                }
            }
            return cnt;
        }

        private String getTimeStr(int t) {
            int hour = t / 60;
            int minutes = t % 60;
            return String.format("%02d:%02d", hour, minutes);
        }

        private boolean isLike(String t, String time) {
            for (int i = 0; i < 5; i++) {
                char c1 = t.charAt(i);
                char c2 = time.charAt(i);
                if (c2 == '?') {
                    continue;
                }
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
    }

}
