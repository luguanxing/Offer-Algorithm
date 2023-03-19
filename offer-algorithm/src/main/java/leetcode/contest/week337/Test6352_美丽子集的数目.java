package leetcode.contest.week337;

import java.util.HashMap;
import java.util.Map;

public class Test6352_美丽子集的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().beautifulSubsets(new int[]{2, 4, 6}, 2));
        System.out.println(new Solution().beautifulSubsets(new int[]{1}, 1));
    }

    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        public int beautifulSubsets(int[] nums, int k) {
            dfs(nums, k, 0);
            return res;
        }

        private void dfs(int[] nums, int k, int idx) {
            if (idx == nums.length) {
                return;
            }
            int num = nums[idx];
            // 分能选num的情况和不能选num的情况
            if (!map.containsKey(num + k) && !map.containsKey(num - k)) {
                // 不选num
                dfs(nums, k, idx + 1);
                // 选num
                res++;
                map.put(num, map.getOrDefault(num, 0) + 1);
                dfs(nums, k, idx + 1);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            } else {
                dfs(nums, k, idx + 1);
            }
        }
    }

}
