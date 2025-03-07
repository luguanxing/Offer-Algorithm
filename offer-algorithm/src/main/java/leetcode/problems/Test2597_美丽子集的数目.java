package leetcode.problems;

import java.util.*;

public class Test2597_美丽子集的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubsets(new int[]{2, 4, 6}, 2));
        System.out.println(new Solution().beautifulSubsets(new int[]{1}, 1));
    }

    static class Solution {
        private int res = 0;

        public int beautifulSubsets(int[] nums, int k) {
            dfs(nums, 0, k, new ArrayList<>());
            return res;
        }

        private void dfs(int[] nums, int idx, int k, List<Integer> currents) {
            if (idx == nums.length) {
                if (!currents.isEmpty()) {
                    res++;
                }
                return;
            }
            // 要nums[idx]
            int num = nums[idx];
            if (!currents.contains(num + k) && !currents.contains(num - k)) {
                currents.add(num);
                dfs(nums, idx + 1, k, currents);
                currents.remove(currents.size() - 1);
            }
            // 不要nums[idx]
            dfs(nums, idx + 1, k, currents);
        }
    }

}
