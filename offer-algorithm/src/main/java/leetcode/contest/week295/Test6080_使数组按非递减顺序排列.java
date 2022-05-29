package leetcode.contest.week295;

import java.util.Stack;

public class Test6080_使数组按非递减顺序排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        System.out.println(new Solution().totalSteps(new int[]{4, 5, 7, 7, 13}));
    }

    static class Solution {
        public int totalSteps(int[] nums) {
            int res = 0;
            // 单调栈，存放较大的数和对应移除次数
            Stack<int[]> stack = new Stack<>();
            for (int num : nums) {
                int cnt = 0;
                while (!stack.isEmpty() && stack.peek()[0] <= num) {
                    // 需要压扁中间较小的数
                    int[] numAndCnt = stack.pop();
                    int lastNum = numAndCnt[0];
                    int lastCnt = numAndCnt[1];
                    if (lastCnt > cnt) {
                        cnt = lastCnt;
                    }
                }
                // 已经压扁前面较小的数，还需要加上自身
                if (!stack.isEmpty()) {
                    cnt++;
                }
                res = Math.max(res, cnt);
                // 继续计算单调栈
                stack.push(new int[]{num, cnt});
            }
            return res;
        }
    }

}
