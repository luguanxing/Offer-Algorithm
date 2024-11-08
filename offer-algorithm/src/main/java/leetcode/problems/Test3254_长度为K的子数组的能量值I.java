package leetcode.problems;

import java.util.*;

public class Test3254_长度为K的子数组的能量值I {

    public static void main(String[] args) {
        // nums = [1,2,3,4,3,2,5], k = 3
        System.out.println(Arrays.toString(new Solution().resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
        // nums = [2,2,2,2,2], k = 4
        System.out.println(Arrays.toString(new Solution().resultsArray(new int[]{2, 2, 2, 2, 2}, 4)));
        // nums = [3,2,3,2,3,2], k = 2
        System.out.println(Arrays.toString(new Solution().resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2)));
        System.out.println(Arrays.toString(new Solution().resultsArray(new int[]{1, 3, 4}, 2)));
    }

    static class Solution {
        public int[] resultsArray(int[] nums, int k) {
            // 单调栈，只存递增的数
            int[] res = new int[nums.length - k + 1];
            int resIndex = 0;
            Deque<Integer> deque = new ArrayDeque<>();
            // 使用单调栈遍历数组
            for (int i = 0; i < nums.length; i++) {
                if (!deque.isEmpty() && deque.peekLast() != nums[i] - 1) {
                    deque.clear();
                }
                deque.addLast(nums[i]);
                if (i >= k - 1) {
                    if (deque.size() > k) {
                        deque.pollFirst();
                    }
                    res[resIndex++] = deque.size() == k ? nums[i] : -1;
                }
            }
            return res;
        }
    }

}
