package leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test2171_拿出最少数目的魔法豆 {

    public static void main(String[] args) {
        // beans = [4,1,6,5]
        System.out.println(new Solution().minimumRemoval(new int[]{4, 1, 6, 5}));
        // beans = [2,10,3,2]
        System.out.println(new Solution().minimumRemoval(new int[]{2, 10, 3, 2}));
    }

    static class Solution {
        public long minimumRemoval(int[] beans) {
            int len = beans.length;
            long total = Arrays.stream(beans).boxed().mapToLong(Integer::longValue).sum();
            Arrays.sort(beans);
            long res = total;
            for (int i = 0; i < len; i++) {
                res = Math.min(res, total - (long) beans[i] * (len - i));
            }
            return res;
        }
    }

    static class Solution_二分 {
        public long minimumRemoval(int[] beans) {
            int len = beans.length;
            Arrays.sort(beans);
            long[] prefixSum = new long[len + 1];
            for (int i = 0; i < len; i++) {
                prefixSum[i + 1] = prefixSum[i] + beans[i];
            }
            long res = Long.MAX_VALUE;
            for (int num : Arrays.stream(beans).boxed().collect(Collectors.toSet())) {
                int left = rightBound(beans, num - 1);
                int right = leftBound(beans, num + 1);
                long sum = 0;
                sum += prefixSum[left + 1];
                sum += (prefixSum[len] - prefixSum[right] - (long) (len - right) * num);
                res = Math.min(res, sum);
            }
            return res;
        }

        int leftBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left - 1;
        }
    }


}
