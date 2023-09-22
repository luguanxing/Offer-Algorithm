package leetcode.problems;

import java.util.Arrays;

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
            int[] gets = new int[children];
            Arrays.fill(gets, 1);
            money -= children;
            int cnt = 0;
            for (int i = 0; i < children; i++) {
                if (money >= 7) {
                    gets[i] += 7;
                    money -= 7;
                    cnt++;
                } else {
                    gets[i] += money;
                    money = 0;
                    if (gets[i] == 4) {
                        if (children == 1) {
                            return -1;
                        } else {
                            if (i == children-1) {
                                cnt--;
                                if (cnt < 0) {
                                    cnt = 0;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            if (money != 0) {
                cnt--;
                if (cnt < 0) {
                    cnt = 0;
                }
            }
            return cnt;
        }
    }

}
