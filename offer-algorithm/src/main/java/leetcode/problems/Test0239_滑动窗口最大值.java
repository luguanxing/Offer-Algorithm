package leetcode.problems;

import java.util.*;

public class Test0239_滑动窗口最大值 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3
        )));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{1}, 1
        )));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{1, -1}, 1
        )));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{9, 11}, 2
        )));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{4, -2}, 2
        )));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{1, 3, 1, 2, 0, 5}, 3
        )));
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            // 窗口内保持递减，遇到更大的替换前面全部
            List<Integer> window = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (window.isEmpty() || window.get(window.size() - 1) >= nums[i]) {
                    window.add(nums[i]);
                } else {
                    for (int j = window.size() - 1; j >= 0; j--) {
                        if (window.get(j) < nums[i]) {
                            window.set(j, nums[i]);
                        } else {
                            break;
                        }
                    }
                    window.add(nums[i]);
                }
            }
            res[0] = window.get(0);
            // 窗口滑动并计算
            for (int i = k; i < nums.length; i++) {
                window.remove(0);
                if (window.isEmpty() || window.get(window.size() - 1) >= nums[i]) {
                    window.add(nums[i]);
                } else {
                    for (int j = window.size() - 1; j >= 0; j--) {
                        if (window.get(j) < nums[i]) {
                            window.set(j, nums[i]);
                        } else {
                            break;
                        }
                    }
                    window.add(nums[i]);
                }
                res[i - k + 1] = window.get(0);
            }
            return res;
        }
    }

    static class Solution_TLE {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }
            res[0] = queue.peek();
            for (int i = k; i < nums.length; i++) {
                Integer addNum = nums[i];
                Integer removeNum = nums[i - k];
                queue.remove(removeNum);
                queue.add(addNum);
                res[i - k + 1] = queue.peek();
            }
            return res;
        }
    }

}
