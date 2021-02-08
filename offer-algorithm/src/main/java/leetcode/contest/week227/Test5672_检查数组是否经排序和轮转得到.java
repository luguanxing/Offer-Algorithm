package leetcode.contest.week227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test5672_检查数组是否经排序和轮转得到 {

    public static void main(String[] args) {
        System.out.println(new Solution().check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().check(new int[]{2, 1, 3, 4}));
        System.out.println(new Solution().check(new int[]{1, 2, 3}));
        System.out.println(new Solution().check(new int[]{1, 1, 1}));
        System.out.println(new Solution().check(new int[]{2, 1}));
    }

    static class Solution {
        public boolean check(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> dlist = new ArrayList<>();
            dlist.addAll(list);
            dlist.addAll(list);
            Collections.sort(list);
            return dlist.toString().contains(list.toString().substring(1, list.toString().length() - 1));
        }
    }

    static class Solution_拼接 {
        public boolean check(int[] nums) {
            int[] sortedNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sortedNums);
            int index = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > nums[i]) {
                    index = i;
                }
            }
            int[] checkNums = new int[nums.length];
            for (int i = index; i < nums.length; i++) {
                checkNums[i - index] = nums[i];
            }
            for (int i = 0; i < index; i++) {
                checkNums[i + nums.length - index] = nums[i];
            }
            return Arrays.toString(sortedNums).equals(Arrays.toString(checkNums));
        }
    }

}
