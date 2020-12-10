package leetcode.problems;


import java.util.Arrays;

public class Test0860_柠檬水找零 {

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(
                new int[]{5, 5, 5, 10, 20}
        ));
        System.out.println(new Solution().lemonadeChange(
                new int[]{5, 5, 10}
        ));
        System.out.println(new Solution().lemonadeChange(
                new int[]{10, 10}
        ));
        System.out.println(new Solution().lemonadeChange(
                new int[]{5, 5, 10, 10, 20}
        ));
        System.out.println(new Solution().lemonadeChange(
                new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5}
        ));
    }

    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int cnt5 = 0;
            int cnt10 = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    cnt5++;
                } else if (bill == 10) {
                    if (cnt5 > 0) {
                        cnt5--;
                        cnt10++;
                    } else {
                        return false;
                    }
                } else {
                    if (cnt10 > 0 && cnt5 > 0) {
                        cnt5--;
                        cnt10--;
                    } else if (cnt5 > 3) {
                        cnt5 -= 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
