package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0090_子集II {

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new Solution().subsetsWithDup(new int[]{0}));
        System.out.println(new Solution().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            // 先排序，避免换顺序重复
            Arrays.sort(nums);
            dfs(nums, 0, current, res);
            return res;
        }

        private void dfs(int[] nums, int index, List<Integer> current, List<List<Integer>> res) {
            int len = nums.length;
            if (index >= len) {
                res.add(new ArrayList<>(current));
                return;
            }
            // 要index对应的数
            current.add(nums[index]);
            dfs(nums, index + 1, current, res);
            current.remove(current.size() - 1);
            // 不要index对应的数，但为了避免后面遇到相同情况，可以跳过相同的数
            int nextIndex = index+1;
            while (nextIndex < len && nums[nextIndex] == nums[index]) {
                nextIndex++;
            }
            dfs(nums, nextIndex, current, res);
        }
    }

    static class Solution_OLD {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list);
            List<Integer> current = new ArrayList<>();
            check(list, current, 0);
            return res;
        }

        private void check(List<Integer> list, List<Integer> current, int index) {
            if (index == list.size()) {
                if (!set.contains(current.toString())) {
                    set.add(current.toString());
                    res.add(new ArrayList<>(current));
                }
                return;
            }
            current.add(list.get(index));
            check(list, current, index + 1);
            current.remove(current.size() - 1);
            check(list, current, index + 1);
        }
    }

}
