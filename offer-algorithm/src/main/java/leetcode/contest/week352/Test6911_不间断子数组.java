package leetcode.contest.week352;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test6911_不间断子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().continuousSubarrays(new int[]{5, 4, 2, 4}));
        System.out.println(new Solution().continuousSubarrays(new int[]{1, 2, 3}));
        System.out.println(new Solution().continuousSubarrays(new int[]{65, 66, 67, 66, 66, 65, 64, 65, 65, 64}));
        System.out.println(new Solution().continuousSubarrays(new int[]{42, 41, 42, 41, 41, 40, 39, 38}));
    }

    static class Solution {
        public long continuousSubarrays(int[] nums) {
            int n = nums.length;
            long ans = 0;
            Deque<Integer> maxQ = new ArrayDeque<>();
            Deque<Integer> minQ = new ArrayDeque<>();
            int l = 0;
            for (int r = 0; r < n; r++) {
                while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[r]) {
                    maxQ.pollLast();
                }
                while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[r]) {
                    minQ.pollLast();
                }
                maxQ.offerLast(r);
                minQ.offerLast(r);
                // 移动窗口的左边界（检查最大值和最小值哪个在前）
                while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2) {
                    if (maxQ.peekFirst() < minQ.peekFirst()) {
                        l = maxQ.pollFirst() + 1;
                    } else {
                        l = minQ.pollFirst() + 1;
                    }
                }
                ans += r - l + 1;
            }
            return ans;
        }
    }

}
