package leetcode.contest.week217;

import java.util.Arrays;
import java.util.Stack;

public class Test5614_找出最具竞争力的子序列 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().mostCompetitive(
                new int[]{3, 5, 2, 6}, 2
        )));
        System.out.println(Arrays.toString(new Solution().mostCompetitive(
                new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4
        )));
        System.out.println(Arrays.toString(new Solution().mostCompetitive(
                new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3
        )));
    }

    static class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            // 单调栈
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[i] < stack.peek() && k - stack.size() < nums.length - i) {
                    stack.pop();
                }
                if (stack.size() < k) {
                    stack.add(nums[i]);
                }
            }
            // 保存结果
            int[] res = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                res[i] = stack.pop();
            }
            return res;
        }
    }

}
