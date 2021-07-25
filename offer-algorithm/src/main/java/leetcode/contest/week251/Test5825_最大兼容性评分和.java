package leetcode.contest.week251;

import java.util.ArrayList;
import java.util.List;

public class Test5825_最大兼容性评分和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxCompatibilitySum(
                new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 1}},
                new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}}
        ));
        System.out.println(new Solution().maxCompatibilitySum(
                new int[][]{{0, 0}, {0, 0}, {0, 0}},
                new int[][]{{1, 1}, {1, 1}, {1, 1}}
        ));
    }

    static class Solution {
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int max = 0;
            // 生成所有导师的排列
            List<List<Integer>> mentorsOrders = getAllPermute(mentors.length);
            for (List<Integer> mentorsOrder : mentorsOrders) {
                int res = calculate(students, mentorsOrder, mentors);
                max = Math.max(max, res);
            }
            return max;
        }

        private int calculate(int[][] students, List<Integer> mentorsOrder, int[][] mentors) {
            int res = 0;
            for (int i = 0; i < students.length; i++) {
                int[] studentScores = students[i];
                int[] mentorScores = mentors[mentorsOrder.get(i)];
                for (int j = 0; j < studentScores.length; j++) {
                    res += studentScores[j] == mentorScores[j] ? 1 : 0;
                }
            }
            return res;
        }

        private List<List<Integer>> ret = new ArrayList<>();

        private List<List<Integer>> getAllPermute(int n) {
            List<Integer> ans = new ArrayList<>();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i;
            }
            ans.add(nums[0]);
            insertNum(nums, 1, ans);
            return ret;
        }

        private void insertNum(int[] nums, int index, List<Integer> ans) {
            if (index == nums.length) {
                List<Integer> newAns = new ArrayList<>(ans);
                ret.add(newAns);
                return;
            }
            ans.add(nums[index]);
            insertNum(nums, index + 1, ans);
            ans.remove(ans.size() - 1);
            for (int j = 0; j < ans.size(); j++) {
                ans.add(j, nums[index]);
                insertNum(nums, index + 1, ans);
                ans.remove(j);
            }
        }
    }

}
