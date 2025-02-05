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
            Set<String> set = new HashSet<>();
            // 先排序，避免换顺序重复
            Arrays.sort(nums);
            dfs(nums, 0, current, set, res);
            return res;
        }

        private void dfs(int[] nums, int index, List<Integer> current, Set<String> set, List<List<Integer>> res) {
            if (index >= nums.length) {
                if (!set.contains(current.toString())) {
                    set.add(current.toString());
                    res.add(new ArrayList<>(current));
                }
                return;
            }
            // 要index
            current.add(nums[index]);
            dfs(nums, index + 1, current, set, res);
            current.remove(current.size() - 1);
            // 不要index
            dfs(nums, index + 1, current, set, res);
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
