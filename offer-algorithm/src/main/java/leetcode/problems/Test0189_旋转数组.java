package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0189_旋转数组 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {-1, -100, 3, 99};
        new Solution().rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {-1};
        new Solution().rotate(nums3, 2);
        System.out.println(Arrays.toString(nums3));
    }

    static class Solution {
        public void rotate(int[] nums, int k) {
            if (k > nums.length) {
                k %= nums.length;
            }
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> doublelist = new ArrayList<>();
            doublelist.addAll(list);
            doublelist.addAll(list);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = doublelist.get(nums.length + i - k);
            }
        }
    }

}
