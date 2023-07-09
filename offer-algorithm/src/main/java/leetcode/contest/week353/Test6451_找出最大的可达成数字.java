package leetcode.contest.week353;

public class Test6451_找出最大的可达成数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().theMaximumAchievableX(4, 1));
        System.out.println(new Solution().theMaximumAchievableX(3, 2));
    }

    static class Solution {
        public int theMaximumAchievableX(int num, int t) {
            return num + 2 * t;
        }
    }

}
