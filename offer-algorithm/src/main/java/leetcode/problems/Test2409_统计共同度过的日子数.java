package leetcode.problems;

public class Test2409_统计共同度过的日子数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countDaysTogether("08-15", "08-18", "08-16", "08-19"));
        System.out.println(new Solution().countDaysTogether("10-01", "10-31", "11-01", "12-31"));
    }

    static class Solution {
        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int aArriveDay = getDate(arriveAlice);
            int aLeaveDay = getDate(leaveAlice);
            int bArriveDay = getDate(arriveBob);
            int bLeaveDay = getDate(leaveBob);
            int[] days = new int[500];
            for (int i = aArriveDay; i <= aLeaveDay; i++) {
                days[i]++;
            }
            for (int i = bArriveDay; i <= bLeaveDay; i++) {
                days[i]++;
            }
            int res = 0;
            for (int day : days) {
                if (day == 2) {
                    res++;
                }
            }
            return res;
        }

        private int getDate(String date) {
            int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int month = Integer.parseInt(date.split("-")[0]);
            int day = Integer.parseInt(date.split("-")[1]);
            int d = 0;
            for (int i = 1; i < month; i++) {
                d += months[i];
            }
            d += day;
            return d;
        }
    }

}
