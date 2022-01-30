package leetcode.contest.week278;

import java.util.ArrayList;
import java.util.List;

public class Test5981_分组得分最高的所有下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreIndices(new int[]{0, 0, 1, 0}));
        System.out.println(new Solution().maxScoreIndices(new int[]{0, 0, 0}));
        System.out.println(new Solution().maxScoreIndices(new int[]{1, 1}));
    }

    static class Solution {
        public List<Integer> maxScoreIndices(int[] nums) {
            // 计算left0 right1
            int len = nums.length;
            int[] left0 = new int[len];
            int left0Cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) {
                    left0Cnt++;
                }
                left0[i] = left0Cnt;
            }
            int[] right1 = new int[len];
            int right1Cnt = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (nums[i] == 1) {
                    right1Cnt++;
                }
                right1[i] = right1Cnt;
            }
            // 计算最大值
            int[] score = new int[len + 1];
            int max = 0;
            for (int i = 0; i <= len; i++) {
                int left = i == 0 ? 0 : left0[i - 1];
                int right = i == len ? 0 : right1[i];
                score[i] = left + right;
                max = Math.max(max, score[i]);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i <= len; i++) {
                if (score[i] == max) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
