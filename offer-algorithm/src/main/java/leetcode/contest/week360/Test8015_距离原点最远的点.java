package leetcode.contest.week360;

public class Test8015_距离原点最远的点 {

    public static void main(String[] args) {
        System.out.println(new Solution().furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(new Solution().furthestDistanceFromOrigin("_R__LL_"));
        System.out.println(new Solution().furthestDistanceFromOrigin("_______"));
    }

    static class Solution {
        public int furthestDistanceFromOrigin(String moves) {
            int l = 0;
            int r = 0;
            int m = 0;
            for (char c : moves.toCharArray()) {
                if (c == 'L') {
                    l++;
                } else if (c == 'R') {
                    r++;
                } else {
                    m++;
                }
            }
            return m + Math.abs(l - r);
        }
    }

}
