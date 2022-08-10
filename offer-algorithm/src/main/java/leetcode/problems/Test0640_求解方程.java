package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0640_求解方程 {

    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("x+5-3+x=6+x-2"));
        System.out.println(new Solution().solveEquation("x=x"));
        System.out.println(new Solution().solveEquation("2x=x"));
        System.out.println(new Solution().solveEquation("x=x+2"));
        System.out.println(new Solution().solveEquation("-x=-1"));
    }

    static class Solution {
        public String solveEquation(String equation) {
            String left = equation.split("=")[0];
            String right = equation.split("=")[1];
            // 化简成ax=b的形式
            List<String> leftParts = getParts(left);
            List<String> rightParts = getParts(right);
            int a = 0;
            int b = 0;
            for (String part : leftParts) {
                if (part.contains("x")) {
                    int factor = 1;
                    if (part.contains("-")) {
                        factor = -1;
                    }
                    part = part.replaceAll("[+|-]|x", "");
                    int xCnt = factor * (part.isEmpty() ? 1 : Integer.parseInt(part));
                    a += xCnt;
                } else {
                    b -= part.isEmpty() ? 0 : Integer.parseInt(part);
                }
            }
            for (String part : rightParts) {
                if (part.contains("x")) {
                    int factor = 1;
                    if (part.contains("-")) {
                        factor = -1;
                    }
                    part = part.replaceAll("[+|-]|x", "");
                    int xCnt = factor * (part.isEmpty() ? 1 : Integer.parseInt(part));
                    a -= xCnt;
                } else {
                    b += part.isEmpty() ? 0 : Integer.parseInt(part);
                }
            }
            if (a == 0 && b == 0) {
                return "Infinite solutions";
            }
            return a == 0 ? "No solution" : "x=" + (b / a);
        }

        private List<String> getParts(String s) {
            List<String> result = new ArrayList<>();
            String current = "";
            for (char c : s.toCharArray()) {
                if (c == '-' || c == '+') {
                    result.add(current);
                    current = "" + c;
                } else {
                    current += c;
                }
            }
            result.add(current);
            return result;
        }
    }

}
