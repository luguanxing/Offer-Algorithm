package leetcode.problems;

public class Test2591_将钱分给最多的儿童 {

    public static void main(String[] args) {
        System.out.println(new Solution().distMoney(20, 3));
        System.out.println(new Solution().distMoney(16, 2));
        System.out.println(new Solution().distMoney(1, 2));
        System.out.println(new Solution().distMoney(5, 2));
        System.out.println(new Solution().distMoney(13, 3));
        System.out.println(new Solution().distMoney(17, 2));
    }

    static class Solution {
        public int distMoney(int money, int children) {
            if (money < children) {
                return -1;
            }
            money -= children;
            // 贪心尽可能先分配7
            int cnt = money / 7;
            if (cnt > children) {
                cnt = children;
            }
            // 剩下的情况分类讨论，找出不符合条件的：剩了钱没分配完or剩了3元只有一个小孩分
            int leftMoney = money - cnt * 7;
            int leftChildren = children - cnt;
            if ((leftChildren == 0 && leftMoney > 0) || (leftChildren == 1 && leftMoney == 3)) {
                cnt--;
            }
            return cnt;
        }
    }

}
