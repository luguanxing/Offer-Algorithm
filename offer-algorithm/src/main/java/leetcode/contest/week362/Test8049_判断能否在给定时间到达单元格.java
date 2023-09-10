package leetcode.contest.week362;

public class Test8049_判断能否在给定时间到达单元格 {

    public static void main(String[] args) {
        System.out.println(new Solution().isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println(new Solution().isReachableAtTime(3, 1, 7, 3, 3));
        System.out.println(new Solution().isReachableAtTime(1, 1, 1, 1, 3));
        System.out.println(new Solution().isReachableAtTime(1, 1, 1, 2, 1));
        System.out.println(new Solution().isReachableAtTime(1, 1, 1, 2, 2));
        System.out.println(new Solution().isReachableAtTime(1, 1, 2, 1, 2));
        System.out.println(new Solution().isReachableAtTime(1, 1, 4, 1, 0));
        System.out.println(new Solution().isReachableAtTime(1, 2, 1, 2, 0));
    }

    static class Solution {
        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
            if (t == 0) {
                if (sx == fx && sy == fy) {
                    return true;
                }
                return false;
            }
            if (sx == fx && sy == fy) {
                if (t == 1) {
                    return false;
                }
                return true;
            }
            int diffX = Math.abs(sx - fx);
            int diffY = Math.abs(sy - fy);
            int diagonal = Math.min(diffX, diffY);
            int min = diffX + diffY - diagonal;
            return min <= t;
        }
    }

}
