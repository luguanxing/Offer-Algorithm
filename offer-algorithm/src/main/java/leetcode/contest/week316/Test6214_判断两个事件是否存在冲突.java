package leetcode.contest.week316;

public class Test6214_判断两个事件是否存在冲突 {

    public static void main(String[] args) {
        System.out.println(new Solution().haveConflict(
                new String[]{"01:15", "02:00"},
                new String[]{"02:00", "03:00"}
        ));
        System.out.println(new Solution().haveConflict(
                new String[]{"01:00", "02:00"},
                new String[]{"01:20", "03:00"}
        ));
        System.out.println(new Solution().haveConflict(
                new String[]{"10:00", "11:00"},
                new String[]{"14:00", "15:00"}
        ));
        System.out.println(new Solution().haveConflict(
                new String[]{"05:10","15:05"},
                new String[]{"14:59","19:17"}
        ));
    }

    static class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            int start1 = get(event1[0]);
            int end1 = get(event1[1]);
            int start2 = get(event2[0]);
            int end2 = get(event2[1]);
            int[] cnt = new int[24 * 60];
            for (int i = start1; i <= end1; i++) {
                cnt[i]++;
            }
            for (int i = start2; i <= end2; i++) {
                cnt[i]++;
            }
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == 2) {
                    return true;
                }
            }
            return false;
        }

        private int get(String s) {
            int hour = Integer.parseInt(s.split(":")[0]);
            int minute = Integer.parseInt(s.split(":")[1]);
            return hour * 60 + minute;
        }
    }

}
