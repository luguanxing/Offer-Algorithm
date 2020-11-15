package leetcode.contest.week215;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test5602_将x减到0的最小操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution_前缀和().minOperations(
                new int[]{1, 1, 4, 2, 3}, 5
        ));
        System.out.println(new Solution_前缀和().minOperations(
                new int[]{5, 6, 7, 8, 9}, 4
        ));
        System.out.println(new Solution_前缀和().minOperations(
                new int[]{3, 2, 20, 1, 1, 3}, 10
        ));
        System.out.println(new Solution_前缀和().minOperations(
                new int[]{2, 1, 1, 4, 7, 1}, 8
        ));
        System.out.println(new Solution_前缀和().minOperations(
                new int[]{1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136}, 894887480
        ));
        System.out.println(new Solution_前缀和().minOperations(
                new int[]{1, 1}, 3
        ));
    }

    static class Solution {
        public int minOperations(int[] nums, int x) {
            // 使用滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
            int maxPart = -1;
            int sum = Arrays.stream(nums).sum();
            int currentSum = 0;
            int left = 0;
            int right = 0;
            while (left < nums.length) {
                // 如果右边未到尽头，不断先向右探测片段，如果大于目标sum-x则左边移动直到结束
                if (right < nums.length) {
                    currentSum += nums[right++];
                }
                while (currentSum > sum - x && left < nums.length) {
                    currentSum -= nums[left++];
                }
                if (currentSum == sum - x) {
                    maxPart = Math.max(maxPart, right - left);
                }
                if (right == nums.length) {
                    left++;
                }
            }
            return maxPart == -1 ? -1 : nums.length - maxPart;
        }
    }

    static class Solution_前缀和 {
        public int minOperations(int[] nums, int x) {
            // 计算前缀和
            Map<Integer, Integer> leftSumIndex = new HashMap<>();
            Map<Integer, Integer> rightSumIndex = new HashMap<>();
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < nums.length; i++) {
                sum1 += nums[i];
                sum2 += nums[nums.length - 1 - i];
                leftSumIndex.put(sum1, i + 1);
                rightSumIndex.put(sum2, i + 1);
            }
            // 仅用左边或右边和求出和为x
            int res = Math.min(leftSumIndex.getOrDefault(x, Integer.MAX_VALUE), rightSumIndex.getOrDefault(x, Integer.MAX_VALUE));
            // 用左边加右边求出x
            for (int leftSum : leftSumIndex.keySet()) {
                int rightSum = x - leftSum;
                if (leftSum <= x && rightSumIndex.containsKey(rightSum)) {
                    res = Math.min(res, leftSumIndex.get(leftSum) + rightSumIndex.get(rightSum));
                }
            }
            return (res == Integer.MAX_VALUE || res > nums.length) ? -1 : res;
        }
    }

}
