package leetcode.contest.week297;

public class Test5259_计算应缴税款总额 {

    public static void main(String[] args) {
        System.out.println(new Solution().calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10));
        System.out.println(new Solution().calculateTax(new int[][]{{1, 0}, {4, 25}, {5, 50}}, 2));
        System.out.println(new Solution().calculateTax(new int[][]{{2, 50}}, 0));
    }

    static class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double tax = Math.min(brackets[0][0], income) * brackets[0][1] / 100.0;
            income -= brackets[0][0];
            if (income <= 0) {
                return tax;
            }
            for (int i = 0; i < brackets.length - 1; i++) {
                int[] currentStageAndRate = brackets[i];
                int[] nextStageAndRate = brackets[i + 1];
                int currentRange = nextStageAndRate[0] - currentStageAndRate[0];
                double currentRate = nextStageAndRate[1] / 100.0;
                if (income >= currentRange) {
                    tax += currentRange * currentRate;
                    income -= currentRange;
                } else {
                    tax += income * currentRate;
                    income = 0;
                    break;
                }
            }
            return tax;
        }
    }

}
