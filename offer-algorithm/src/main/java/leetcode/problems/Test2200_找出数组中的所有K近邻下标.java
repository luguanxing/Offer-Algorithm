package leetcode.problems;

import java.util.*;

public class Test2200_找出数组中的所有K近邻下标 {

    public static void main(String[] args) {
        // nums = [3,4,9,1,3,9,5], key = 9, k = 1
        System.out.println(new Solution().findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
        // nums = [2,2,2,2,2], key = 2, k = 2
        System.out.println(new Solution().findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2));
    }

    static class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            int MAX = 1005;
            boolean[] map = new boolean[MAX];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == key) {
                    for (int j = Math.max(0, i - k); j <= Math.min(nums.length - 1, i + k); j++) {
                        map[j] = true;
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (map[i]) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
