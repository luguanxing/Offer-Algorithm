package leetcode.problems;

import java.util.Stack;

public class Test2645_构造有效字符串的最少插入数 {

    public static void main(String[] args) {
        System.out.println(new Solution().addMinimum("b"));
        System.out.println(new Solution().addMinimum("aaa"));
        System.out.println(new Solution().addMinimum("abc"));
        System.out.println(new Solution().addMinimum("aaaabb"));
    }

    static class Solution {
        public int addMinimum(String word) {
            int groupCnt = 1;
            for (int i = 1; i < word.length(); i++) {
                // 后面大于前面一定是不同一组
                if (word.charAt(i - 1) >= word.charAt(i)) {
                    groupCnt++;
                }
            }
            // 答案 = 组数*3 - 原长度
            return groupCnt * 3 - word.length();
        }
    }

    static class Solution_栈 {
        public int addMinimum(String word) {
            Stack<Character> stack = new Stack<>();
            int cnt = 0;
            for (char current : word.toCharArray()) {
                if (current == 'a') {
                    if (!stack.isEmpty()) {
                        char last = stack.peek();
                        cnt += last == 'c' ? 0 : (last == 'b' ? 1 : 2);
                    }
                } else if (current == 'b') {
                    if (stack.isEmpty()) {
                        cnt += 1;
                    } else {
                        char last = stack.peek();
                        cnt += last == 'a' ? 0 : (last == 'c' ? 1 : 2);
                    }
                } else if (current == 'c') {
                    if (stack.isEmpty()) {
                        cnt += 2;
                    } else {
                        char last = stack.peek();
                        cnt += last == 'b' ? 0 : (last == 'a' ? 1 : 2);
                    }
                }
                stack.add(current);
            }
            cnt += stack.peek() == 'c' ? 0 : (stack.peek() == 'b' ? 1 : 2);
            return cnt;
        }
    }

}
