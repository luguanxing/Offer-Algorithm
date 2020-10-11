package leetcode.contest.week210;

public class Test5535_括号的最大嵌套深度 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(new Solution().maxDepth("(1)+((2))+(((3)))"));
        System.out.println(new Solution().maxDepth("1+(2*3)/(2-1)"));
        System.out.println(new Solution().maxDepth("1"));
    }

    static class Solution {
        public int maxDepth(String s) {
            int current = 0;
            int max = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    current++;
                } else if (c == ')') {
                    current--;
                }
                max = Math.max(max, current);
            }
            return max;
        }
    }

}
