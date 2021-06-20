package leetcode.contest.week246;

public class Test5789_你完成的完整对局数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfRounds("12:01", "12:44"));
        System.out.println(new Solution().numberOfRounds("20:00", "06:00"));
        System.out.println(new Solution().numberOfRounds("00:00", "23:59"));
    }

    static class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            int startHours = Integer.parseInt(startTime.split(":")[0]);
            int startMinutes = Integer.parseInt(startTime.split(":")[1]);
            int endHours = Integer.parseInt(finishTime.split(":")[0]);
            int endMinutes = Integer.parseInt(finishTime.split(":")[1]);
            int start = startHours * 60 + startMinutes;
            int end = endHours * 60 + endMinutes;
            if (start > end) {
                end += 24 * 60;
            }
            int res = 0;
            int cnt = 0;
            for (int t = start; t <= end; t++) {
                if (t % 15 == 0) {
                    if (cnt == 15) {
                        res++;
                    }
                    cnt = 0;
                }
                cnt++;
            }
            return res;
        }
    }

}
