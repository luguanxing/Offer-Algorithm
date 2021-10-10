package leetcode.contest.week262;

import java.util.*;
import java.util.stream.Collectors;

public class Test5894_至少在两个数组中出现的值 {

    public static void main(String[] args) {
        System.out.println(new Solution().twoOutOfThree(
                new int[]{1, 1, 3, 2},
                new int[]{2, 3},
                new int[]{3}
        ));
        System.out.println(new Solution().twoOutOfThree(
                new int[]{3, 1},
                new int[]{2, 3},
                new int[]{1, 2}
        ));
        System.out.println(new Solution().twoOutOfThree(
                new int[]{1, 2, 2},
                new int[]{4, 3, 3},
                new int[]{5}
        ));
    }

    static class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            Set<Integer> set3 = Arrays.stream(nums3).boxed().collect(Collectors.toSet());
            List<Integer> res = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            set.addAll(set1);
            set.addAll(set2);
            set.addAll(set3);
            for (int num : set) {
                if ((set1.contains(num) && set2.contains(num)) ||
                        (set1.contains(num) && set3.contains(num)) ||
                        (set2.contains(num) && set3.contains(num))
                ) {
                    res.add(num);
                }
            }
            return res;
        }
    }

}
