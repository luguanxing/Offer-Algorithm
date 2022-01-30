package leetcode.contest.week278;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test5993_将找到的值乘以2 {

    public static void main(String[] args) {
        System.out.println(new Solution().findFinalValue(
                new int[]{5, 3, 6, 1, 12}, 3
        ));
        System.out.println(new Solution().findFinalValue(
                new int[]{2, 7, 9}, 4
        ));
    }

    static class Solution {
        public int findFinalValue(int[] nums, int original) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            while (set.contains(original)) {
                original *= 2;
            }
            return original;
        }
    }

}
