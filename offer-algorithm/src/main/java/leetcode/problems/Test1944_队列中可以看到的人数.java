package leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

public class Test1944_队列中可以看到的人数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})));
        System.out.println(Arrays.toString(new Solution().canSeePersonsCount(new int[]{5, 1, 2, 3, 10})));
    }

    static class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            // 单调栈，每次遇到比栈顶元素大的，就弹出+处理栈顶元素，直到栈顶元素比当前元素大
            int len = heights.length;
            int[] res = new int[len];
            Stack<int[]> stack = new Stack<>();
            stack.add(new int[]{heights[0], 0});
            for (int i = 1; i < len; i++) {
                // 弹出+处理栈顶元素
                while (!stack.isEmpty() && stack.peek()[0] <= heights[i]) {
                    int[] pop = stack.pop();
                    res[pop[1]]++;
                }
                // 栈顶元素比当前元素大，栈顶元素可以看到当前元素
                if (!stack.isEmpty()) {
                    res[stack.peek()[1]]++;
                }
                stack.add(new int[]{heights[i], i});
            }
            return res;
        }
    }

}
