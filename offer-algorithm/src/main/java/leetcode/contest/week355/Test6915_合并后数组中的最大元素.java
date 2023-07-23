package leetcode.contest.week355;

import java.util.Stack;

public class Test6915_合并后数组中的最大元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArrayValue(new int[]{2, 3, 7, 9, 3}));
        System.out.println(new Solution().maxArrayValue(new int[]{5, 3, 3}));
    }

    static class Solution {
        public long maxArrayValue(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            for (int num : nums) {
                stack.add(num);
            }
            long current = stack.pop();
            long max = current;
            while (!stack.isEmpty()) {
                int next = stack.peek();
                if (current >= next) {
                    current += next;
                    stack.pop();
                } else {
                    current = stack.pop();
                }
                max = Math.max(max, current);
            }
            return max;
        }
    }

}
