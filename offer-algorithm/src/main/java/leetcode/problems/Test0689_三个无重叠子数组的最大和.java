package leetcode.problems;

import java.util.Arrays;

public class Test0689_三个无重叠子数组的最大和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
        System.out.println(Arrays.toString(new Solution().maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2)));
    }

    static class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            // 先算出K窗口和的数组
            int[] kSumWindow = new int[nums.length - k + 1];
            int kSum = 0;
            for (int i = 0; i < nums.length; i++) {
                kSum += nums[i];
                if (i >= k - 1) {
                    kSumWindow[i - (k - 1)] = kSum;
                    kSum -= nums[i - (k - 1)];
                }
            }
            // 找出窗口每个下标左侧和右侧最大值
            int[] leftMax = new int[kSumWindow.length];
            int[] rightMax = new int[kSumWindow.length];
            int leftMaxIndex = 0;
            for (int i = 0; i < kSumWindow.length; i++) {
                if (kSumWindow[leftMaxIndex] < kSumWindow[i]) {
                    leftMaxIndex = i;
                }
                leftMax[i] = leftMaxIndex;
            }
            int rightMaxIndex = kSumWindow.length - 1;
            for (int i = kSumWindow.length - 1; i >= 0; i--) {
                if (kSumWindow[i] >= kSumWindow[rightMaxIndex]) {
                    rightMaxIndex = i;
                }
                rightMax[i] = rightMaxIndex;
            }
            // 找出每个序号左右距离k的极值
            int currentMax = 0;
            int[] res = new int[3];
            for (int i = k; i < kSumWindow.length - k; i++) {
                int left = kSumWindow[leftMax[i - k]];
                int mid = kSumWindow[i];
                int right = kSumWindow[rightMax[i + k]];
                if (left + mid + right > currentMax) {
                    currentMax = left + mid + right;
                    res[0] = leftMax[i - k];
                    res[1] = i;
                    res[2] = rightMax[i + k];
                }
            }
            return res;
        }
    }

}
