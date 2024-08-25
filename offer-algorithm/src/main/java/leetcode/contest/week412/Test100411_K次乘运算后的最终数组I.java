package leetcode.contest.week412;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test100411_K次乘运算后的最终数组I {

    public static void main(String[] args) {
        // nums = [2,1,3,5,6], k = 5, multiplier = 2
        System.out.println(Arrays.toString(new Solution().getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)));
        // nums = [1,2], k = 3, multiplier = 4
        System.out.println(Arrays.toString(new Solution().getFinalState(new int[]{1, 2}, 3, 4)));
    }

    static class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            for (int i = 0; i < nums.length; i++) {
                queue.add(new int[]{nums[i], i});
            }
            for (int i = 0; i < k; i++) {
                int[] poll = queue.poll();
                poll[0] *= multiplier;
                queue.add(poll);
            }
            int[] res = new int[nums.length];
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                res[poll[1]] = poll[0];
            }
            return res;
        }
    }

}
