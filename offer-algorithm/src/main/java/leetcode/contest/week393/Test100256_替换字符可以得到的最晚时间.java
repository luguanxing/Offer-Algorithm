package leetcode.contest.week393;

public class Test100256_替换字符可以得到的最晚时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLatestTime("1?:?4"));
        System.out.println(new Solution().findLatestTime("0?:5?"));
        System.out.println(new Solution().findLatestTime("??:?4"));
        System.out.println(new Solution().findLatestTime("??:??"));
        System.out.println(new Solution().findLatestTime("?3:??"));
        System.out.println(new Solution().findLatestTime("?5:??"));
        System.out.println(new Solution().findLatestTime("?3:12"));
        System.out.println(new Solution().findLatestTime("?2:2?"));

    }

    static class Solution {
        public String findLatestTime(String s) {
            char[] time = s.toCharArray();
            if (time[0] == '?') {
                if ((time[1] < '2' || time[1] == '?')) {
                    time[0] = '1';
                } else {
                    time[0] = '0';
                }
            }
            if (time[1] == '?') {
                time[1] = time[0] == '1' ? '1' : '9';
            }
            if (time[3] == '?') {
                time[3] = '5';
            }
            if (time[4] == '?') {
                time[4] = '9';
            }
            return new String(time);
        }
    }


}
