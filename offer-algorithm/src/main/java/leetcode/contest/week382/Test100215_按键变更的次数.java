package leetcode.contest.week382;

public class Test100215_按键变更的次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countKeyChanges("aAbBcC"));
        System.out.println(new Solution().countKeyChanges("AaAaAaaA"));
    }

    static class Solution {
        public int countKeyChanges(String s) {
            s = s.toUpperCase();
            char[] chars = s.toCharArray();
            int cnt = 0;
            int last = chars[0];
            for (int i = 1; i < chars.length; i++) {
                int cur = chars[i];
                if (cur == last) {
                    continue;
                }
                cnt++;
                last = cur;
            }
            return cnt;
        }
    }

}
