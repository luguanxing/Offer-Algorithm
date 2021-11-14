package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0046_全排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{}));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> last = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> current = new ArrayList<>();
            dfs(last, current);
            return result;
        }

        private void dfs(List<Integer> last, List<Integer> current) {
            if (last.isEmpty()) {
                // 全排列要last一个不剩
                result.add(new ArrayList<>(current));
                return;
            }
            for (Integer num : last) {
                // 从last选择num，一定要选择出一个，没有不选择的情况
                List<Integer> newLast = new ArrayList<>(last);
                List<Integer> newCurrent = new ArrayList<>(current);
                newLast.remove(num);
                newCurrent.add(num);
                dfs(newLast, newCurrent);
            }
        }
    }

}
