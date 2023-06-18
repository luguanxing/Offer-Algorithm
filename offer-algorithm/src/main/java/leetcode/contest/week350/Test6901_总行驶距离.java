package leetcode.contest.week350;

public class Test6901_总行驶距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().distanceTraveled(5, 10));
        System.out.println(new Solution().distanceTraveled(1, 2));
        System.out.println(new Solution().distanceTraveled(9, 1));
    }

    static class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
            int dis = 0;
            int used = 0;
            while (mainTank > 0) {
                dis += 10;
                mainTank--;
                used++;
                if (used == 5) {
                    used = 0;
                    if (additionalTank-- > 0) {
                        mainTank++;
                    }
                }
            }
            return dis;
        }
    }

}
