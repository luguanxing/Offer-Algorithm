package leetcode.problems;

import java.util.*;

public class Test2766_重新放置石块 {

    public static void main(String[] args) {
        System.out.println(new Solution().relocateMarbles(
                new int[]{1, 6, 7, 8},
                new int[]{1, 7, 2},
                new int[]{2, 9, 5}
        ));
        System.out.println(new Solution().relocateMarbles(
                new int[]{1, 1, 3, 3},
                new int[]{1, 3},
                new int[]{2, 2}
        ));
    }

    static class Solution {
        public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
            Set<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int i = 0; i < moveFrom.length; i++) {
                int from = moveFrom[i];
                int to = moveTo[i];
                if (set.contains(from)) {
                    set.remove(from);
                    set.add(to);
                }
            }
            return new ArrayList<>(set);
        }
    }

}
