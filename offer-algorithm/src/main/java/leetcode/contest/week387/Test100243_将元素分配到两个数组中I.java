package leetcode.contest.week387;

import java.util.*;

public class Test100243_将元素分配到两个数组中I {

    public static void main(String[] args) {
        // nums = [2,1,3]
        System.out.println(Arrays.toString(new Solution().resultArray(new int[]{2, 1, 3})));
        // nums = [5,4,3,8]
        System.out.println(Arrays.toString(new Solution().resultArray(new int[]{5, 4, 3, 8})));
    }

    static class Solution {
        public int[] resultArray(int[] nums) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(nums[0]);
            list2.add(nums[1]);
            for (int i = 2; i < nums.length; i++) {
                if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                    list1.add(nums[i]);
                } else {
                    list2.add(nums[i]);
                }
            }
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

}
