package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0941_有效的山脉数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().validMountainArray(
                new int[]{2, 1}
        ));
        System.out.println(new Solution().validMountainArray(
                new int[]{3, 5, 5}
        ));
        System.out.println(new Solution().validMountainArray(
                new int[]{0, 3, 2, 1}
        ));
        System.out.println(new Solution().validMountainArray(
                new int[]{1, 7, 9, 5, 4, 1, 2}
        ));
    }

    static class Solution {
        public boolean validMountainArray(int[] A) {
            List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
            Integer max = list.stream().max(Integer::compareTo).orElse(0);
            int maxIndex = list.indexOf(max);
            if (list.indexOf(max) == 0 || list.lastIndexOf(max) == A.length - 1) {
                return false;
            }
            for (int i = 0; i < maxIndex; i++) {
                if (list.get(i) >= list.get(i + 1)) {
                    return false;
                }
            }
            for (int i = maxIndex + 1; i < list.size() - 1; i++) {
                if (list.get(i) <= list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

}
