package leetcode.problems;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test0016_最接近的三数之和 {

    public static void main(String[] args) {
        System.out.println(new Solution2().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(new Solution2().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, 1));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 先排序
            Arrays.sort(nums);
            // 对每个元素双指针找最接近target
            int res = Integer.MAX_VALUE;
            for (int index = 0; index < nums.length; index++) {
                int left = 0;
                int right = nums.length - 1;
                while (left < right) {
                    // 避免左右指针和固定的元素相同
                    if (left == index) {
                        left++;
                        continue;
                    }
                    if (right == index) {
                        right--;
                        continue;
                    }
                    // 滑动窗口找到最逼近target的数目
                    int sum = nums[index] + nums[left] + nums[right];
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                    if (sum < target) {
                        left++;
                    } else if (target < sum) {
                        right--;
                    } else {
                        return sum;
                    }
                }
            }
            return res;
        }
    }

    static class Solution2 {
        public int threeSumClosest(int[] nums, int target) {
            int len = nums.length;
            Arrays.sort(nums);
            int closet = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int sum = nums[i] + nums[j];
                    int diff = target - sum;
                    // 在原有集合中找最接近diff的数
                    int idx = Arrays.binarySearch(nums, j + 1, len, diff);
                    if (idx > 0) {
                        return target;
                    } else {
                        idx = -idx - 1;
                        if (j < idx && idx < len && Math.abs(target - nums[i] - nums[j] - nums[idx]) < Math.abs(target - closet)) {
                            closet = nums[i] + nums[j] + nums[idx];
                        }
                        if (j < idx - 1 && idx - 1 < len && Math.abs(target - nums[i] - nums[j] - nums[idx - 1]) < Math.abs(target - closet)) {
                            closet = nums[i] + nums[j] + nums[idx - 1];
                        }
                        if (j < idx + 1 && idx + 1 < len && Math.abs(target - nums[i] - nums[j] - nums[idx + 1]) < Math.abs(target - closet)) {
                            closet = nums[i] + nums[j] + nums[idx + 1];
                        }
                    }
                }
            }
            return closet;
        }
    }

}
