package leetcode.contest.week344;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test6416_找出不同元素数目差数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().distinctDifferenceArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(new Solution().distinctDifferenceArray(new int[]{3, 2, 3, 4, 2})));
    }

    static class Solution {
        public int[] distinctDifferenceArray(int[] nums) {
            int len = nums.length;
            int[] diff = new int[len];
            for (int i = 0; i < len; i++) {
                Set<Integer> set1 = new HashSet<>();
                Set<Integer> set2 = new HashSet<>();
                for (int j = 0; j <= i; j++) {
                    set1.add(nums[j]);
                }
                for (int j = i + 1; j < len; j++) {
                    set2.add(nums[j]);
                }
                diff[i] = set1.size() - set2.size();
            }
            return diff;
        }
    }

}
