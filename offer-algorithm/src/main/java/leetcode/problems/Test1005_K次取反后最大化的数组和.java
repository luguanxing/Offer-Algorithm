package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test1005_K次取反后最大化的数组和 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(new Solution().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    static class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list, Comparator.comparingInt(Math::abs));
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) < 0 && k > 0) {
                    list.set(i, list.get(i) * -1);
                    k--;
                }
            }
            if (k % 2 == 1) {
                list.set(0, list.get(0) * -1);
            }
            return list.stream().reduce(Integer::sum).get();
        }
    }

}
