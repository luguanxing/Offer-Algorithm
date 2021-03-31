package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0090_子集II {

    public static void main(String[] args) {
//        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
//        System.out.println(new Solution().subsetsWithDup(new int[]{0}));
        System.out.println(new Solution().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    static class Solution {
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
