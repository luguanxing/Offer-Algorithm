package leetcode.contest.week287;

public class Test6055_转化时间需要的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().convertTime("02:30", "04:35"));
        System.out.println(new Solution().convertTime("11:00", "11:01"));
    }

    static class Solution {
        public int convertTime(String current, String correct) {
            String[] currents = current.split(":");
            String[] targets = correct.split(":");
            int currentMins = Integer.parseInt(currents[0]) * 60 + Integer.parseInt(currents[1]);
            int targetMins = Integer.parseInt(targets[0]) * 60 + Integer.parseInt(targets[1]);
            int diffMins = targetMins - currentMins;
            int res = 0;
            res += diffMins / 60;
            diffMins %= 60;
            res += diffMins / 15;
            diffMins %= 15;
            res += diffMins / 5;
            diffMins %= 5;
            res += diffMins;
            return res;
        }
    }

}
