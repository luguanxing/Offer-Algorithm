package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test0969_煎饼排序 {

    public static void main(String[] args) {
        System.out.println(new Solution().pancakeSort(new int[]{3, 2, 4, 1}));
        System.out.println(new Solution().pancakeSort(new int[]{1, 2, 3}));
    }

    static class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> res = new ArrayList<>();
            List<Integer> nums = Arrays.stream(arr).boxed().collect(Collectors.toList());
            dfs(nums, nums.size(), res);
            return res;
        }

        private void dfs(List<Integer> nums, int index, List<Integer> res) {
            // 把最大的index放到第index位后递归
            if (index == 1) {
                return;
            }
            if (index == nums.get(index - 1)) {
                dfs(nums, index - 1, res);
            } else {
                // 把index放到翻转到第一位
                int pos = nums.indexOf(index);
                res.add(pos+1);
                List<Integer> prefix = nums.subList(0, pos + 1);
                List<Integer> suffix = nums.subList(pos + 1, index);
                Collections.reverse(prefix);
                // 再翻转到第index位
                res.add(index);
                List<Integer> newNums = new ArrayList<>();
                newNums.addAll(prefix);
                newNums.addAll(suffix);
                Collections.reverse(newNums);
                dfs(newNums, index - 1, res);
            }
        }
    }

}
