package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0047_全排列II {

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new Solution().permuteUnique(new int[]{1, 2, 3}));
    }

    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> available = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> current = new ArrayList<>();
            Set<String> set = new HashSet<>();
            dfs(available, current, res, set);
            return res;
        }

        private void dfs(List<Integer> available, List<Integer> current, List<List<Integer>> res, Set<String> set) {
            if (available.isEmpty()) {
                if (!set.contains(current.toString())) {
                    res.add(new ArrayList<>(current));
                    set.add(current.toString());
                }
                return;
            }
            for (int i = 0; i < available.size(); i++) {
                int next = available.get(i);
                available.remove(i);
                current.add(next);
                dfs(available, current, res, set);
                current.remove(current.size() - 1);
                available.add(i, next);
            }
        }
    }

}
