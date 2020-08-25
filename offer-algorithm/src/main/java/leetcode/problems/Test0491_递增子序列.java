package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test0491_递增子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7, 7}));
    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();
        private List<Integer> currentNums = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            recursion(nums, 0, Integer.MIN_VALUE);
            Map<String, List<Integer>> map = new HashMap<>();
            result
                    .stream()
                    .filter(list -> list.size() >= 2)
                    .collect(Collectors.toList())
                    .forEach(list -> map.put(list.toString(), list));
            return new ArrayList<>(map.values());
        }

        private void recursion(int[] nums, int index, int currentMax) {
            if (index == nums.length) {
                result.add(new ArrayList<>(currentNums));
                return;
            }
            // 如果num[index]比currentMax更大，可要可不要
            int num = nums[index];
            if (num >= currentMax) {
                // 能要并且要该数
                currentNums.add(num);
                recursion(nums, index + 1, num);
                currentNums.remove(currentNums.size() - 1);
            }
            // 不要或不能要该数
            recursion(nums, index + 1, currentMax);
        }
    }

}
