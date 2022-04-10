package leetcode.contest.week288;

public class Test6038_向表达式添加括号后的最小结果 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeResult("247+38"));
        System.out.println(new Solution().minimizeResult("12+34"));
        System.out.println(new Solution().minimizeResult("999+999"));
    }

    static class Solution {
        public String minimizeResult(String expression) {
            int min = Integer.MAX_VALUE;
            String res = "";
            int pos = expression.indexOf("+");
            for (int l = 0; l < pos; l++) {
                for (int r = pos + 2; r <= expression.length(); r++) {
                    int current = calculate(expression, l, pos, r);
                    if (current < min) {
                        min = current;
                        res = expression.substring(0, l) + "(" + expression.substring(l, r) + ")" + expression.substring(r);
                    }
                }
            }
            return res;
        }

        private int calculate(String expression, int l, int pos, int r) {
            String leftOut = expression.substring(0, l);
            String leftIn = expression.substring(l, pos);
            String rightIn = expression.substring(pos + 1, r);
            String rightOut = expression.substring(r);
            return (leftOut.isEmpty() ? 1 : Integer.parseInt(leftOut)) *
                    (Integer.parseInt(leftIn) + Integer.parseInt(rightIn)) *
                    (rightOut.isEmpty() ? 1 : Integer.parseInt(rightOut));
        }
    }

}
