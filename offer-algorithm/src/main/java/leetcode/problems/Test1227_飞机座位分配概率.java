package leetcode.problems;

public class Test1227_飞机座位分配概率 {

    public static void main(String[] args) {
        System.out.println(new Solution().nthPersonGetsNthSeat(1));
        System.out.println(new Solution().nthPersonGetsNthSeat(2));
        System.out.println(new Solution().nthPersonGetsNthSeat(3));
    }

    static class Solution {
        public double nthPersonGetsNthSeat(int n) {
            if (n == 1) {
                return 1.0;
            }
            // 有1/n的机会坐对自己的座位，后面包括n号都全部正常
            // 有1/n的机会坐到n号的位置，后面n号不可能做到自己位置
            // 有(n-2)/n的机会坐到其他位置，于是问题变成了n-1个人的情况
            // 去掉n号没位置的情况得到：f(n) = 1/n + (n-2)/n * f(n-1)
            return 1.0 / n + ((n - 2.0) / n) * nthPersonGetsNthSeat(n - 1);
        }
    }

}
