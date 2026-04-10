package leetcode.problems;

import java.util.*;

public class Test3741_三个相等元素之间的最小距离II {

    public static void main(String[] args) {
        // nums = [1,2,1,1,3]
        System.out.println(new Solution().minimumDistance(new int[]{1, 2, 1, 1, 3}));
        // nums = [1,1,2,3,2,1,2]
        System.out.println(new Solution().minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 2}));
        // nums = [1]
        System.out.println(new Solution().minimumDistance(new int[]{1}));
    }

    static class Solution {
        public int minimumDistance(int[] nums) {
            Map<Integer, List<Integer>> indexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
            int result = Integer.MAX_VALUE;
            for (List<Integer> indices : indexMap.values()) {
                for (int i = 0; i < indices.size() - 2; i++) {
                    result = Math.min(
                            result,
                            // 因为已经排序，绝对值可以去掉
                            // (idx[1]-idx[0]) + (idx[2]-idx[1]) + (idx[2]-idx[0]) = 2 * (idx[2]-idx[0])
                            (indices.get(i + 2) - indices.get(i))  * 2
                    );
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }

}
