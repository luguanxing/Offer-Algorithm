package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0241_为运算表达式设计优先级 {

    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2-1-1"));
        System.out.println(new Solution().diffWaysToCompute("2*3-4*5"));
    }

    static class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            // 记录符号数
            List<Integer> opIndexs = new ArrayList<>();
            for (int i = 0; i < expression.length(); i++) {
                if (!Character.isDigit(expression.charAt(i))) {
                    opIndexs.add(i);
                }
            }
            // 计算表达式可能的结果列表
            List<Integer> currentResult = new ArrayList<>();
            if (opIndexs.isEmpty()) {
                currentResult.add(Integer.parseInt(expression));
            } else {
                // 当前问题先划分成子问题，再由子问题的结果集做运算得到当前问题结果集
                for (int opIndex : opIndexs) {
                    String leftExpression = expression.substring(0, opIndex);
                    String rightExpression = expression.substring(opIndex + 1);
                    List<Integer> leftResults = diffWaysToCompute(leftExpression);
                    List<Integer> rightResults = diffWaysToCompute(rightExpression);
                    for (int leftResult : leftResults) {
                        for (int rightResult : rightResults) {
                            switch (expression.charAt(opIndex)) {
                                case '+':
                                    currentResult.add(leftResult + rightResult);
                                    break;
                                case '-':
                                    currentResult.add(leftResult - rightResult);
                                    break;
                                case '*':
                                    currentResult.add(leftResult * rightResult);
                                    break;
                            }
                        }
                    }
                }
            }
            return currentResult;
        }
    }

}
