package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test0349_两个数组的交集 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(
                new int[]{1, 2, 2, 1},
                new int[]{2, 2}
        )));
        System.out.println(Arrays.toString(new Solution().intersection(
                new int[]{4, 9, 5},
                new int[]{9, 4, 9, 8, 4}
        )));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            List<Integer> list = new ArrayList<>();
            for (int num : set1) {
                if (set2.contains(num)) {
                    list.add(num);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
