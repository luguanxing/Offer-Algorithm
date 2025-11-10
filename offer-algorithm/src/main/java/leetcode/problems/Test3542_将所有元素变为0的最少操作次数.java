package leetcode.problems;

import java.util.Stack;

public class Test3542_将所有元素变为0的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{0, 2}));
        System.out.println(new Solution().minOperations(new int[]{3, 1, 2, 1}));
        System.out.println(new Solution().minOperations(new int[]{1, 2, 1, 2, 1, 2}));
        System.out.println(new Solution().minOperations(new int[]{3, 1, 4}));
        System.out.println(new Solution().minOperations(new int[]{1, 4, 4, 6}));
        System.out.println(new Solution().minOperations(new int[]{7, 2, 0, 4, 2}));
    }

    static class Solution {
        public int minOperations(int[] nums) {
            // 递增单调栈，某个数遇到有左右都小的数时，才会被操作
            int len = nums.length;
            int cnt = 0;
            Stack<Integer> queue = new Stack<>();
            for (int num : nums) {
                // 遇到0，清空栈，进入下一阶段
                if (num == 0) {
                    cnt += queue.size();
                    queue.clear();
                    continue;
                }
                // 弹出比当前数大的数，这些数左右都有比它小的数，需要单独操作
                while (!queue.isEmpty() && queue.peek() > num) {
                    queue.pop();
                    cnt++;
                }
                // 相同的数只保留一个，不需要单独操作
                if (!queue.isEmpty() && queue.peek() == num) {
                    continue;
                }
                queue.push(num);
            }
            return cnt + queue.size();
        }
    }

}
