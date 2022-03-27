package leetcode.contest.week286;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test5268_找出两数组的不同 {

    public static void main(String[] args) {
        System.out.println(new Solution().findDifference(
                new int[]{1, 2, 3},
                new int[]{2, 4, 6}
        ));
        System.out.println(new Solution().findDifference(
                new int[]{1, 2, 3, 3},
                new int[]{1, 1, 2, 2}
        ));
    }

    static class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            for (int num : nums2) {
                set2.add(num);
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int num : set1) {
                if (!set2.contains(num)) {
                    list1.add(num);
                }
            }
            for (int num : set2) {
                if (!set1.contains(num)) {
                    list2.add(num);
                }
            }
            res.add(list1);
            res.add(list2);
            return res;
        }
    }

}
