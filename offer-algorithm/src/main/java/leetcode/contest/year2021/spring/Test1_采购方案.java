package leetcode.contest.year2021.spring;

import java.math.BigInteger;
import java.util.Arrays;

public class Test1_采购方案 {

    public static void main(String[] args) {
        System.out.println(new Solution().purchasePlans(
                new int[]{2, 5, 3, 5},
                6
        ));
        System.out.println(new Solution().purchasePlans(
                new int[]{2, 5, 3, 5},
                5
        ));
        System.out.println(new Solution().purchasePlans(
                new int[]{2, 2, 1, 9},
                10
        ));
        System.out.println(new Solution().purchasePlans(
                new int[]{1, 2, 7, 9, 11},
                10
        ));
        System.out.println(new Solution().purchasePlans(
                new int[]{1, 1, 1, 1},
                3
        ));
        System.out.println(new Solution().purchasePlans(
                new int[]{1, 1, 2, 2},
                5
        ));
        System.out.println(new Solution_双指针().purchasePlans(
                new int[]{1, 1, 2, 2},
                5
        ));
    }

    static class Solution_双指针 {
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length - 1;
            int res = 0;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                    continue;
                }
                res += right - left;
                res %= 1000000007;
                left++;
            }
            return res;
        }
    }

//    static class Solution_双指针 {
//        public int purchasePlans(int[] nums, int target) {
//            int mod = 1_000_000_007;
//            int ans = 0;
//            // 首先对整体进行排序
//            Arrays.sort(nums);
//            // 双指针，left 从前往后找，right 从后往前
//            int left = 0, right = nums.length - 1;
//            while (left < right) {
//                // 如果当前左右之和大于了目标值，说明偏大了，就把右指针往左移动
//                if (nums[left] + nums[right] > target) right--;
//                else {
//                    // 否则的话，说明找到了合适的，需要把两者中间的元素个数都累加起来
//                    ans += right - left;
//                    // 然后再向右移动左指针
//                    left++;
//                }
//                ans %= mod;
//            }
//            return ans % mod;
//        }
//    }

    static class Solution {
        public int purchasePlans(int[] nums, int target) {
            Arrays.sort(nums);
            BigInteger res = new BigInteger("0");
            for (int i = 0; i < nums.length && nums[i] < target; i++) {
                int lastMoney = target - nums[i];
                int nextIndex = binarySearch(nums, i + 1, nums.length, lastMoney);
                while (nextIndex > 0 && nextIndex + 1 < nums.length && nums[nextIndex + 1] == nums[nextIndex]) {
                    nextIndex = binarySearch(nums, nextIndex + 1, nums.length, lastMoney);
                }
                if (nextIndex < 0) {
                    nextIndex = -nextIndex - 1;
                }
                if (nums[nextIndex] <= lastMoney) {
                    res = res.add(new BigInteger((nextIndex - i) + ""));
                }
            }
            return res.mod(new BigInteger("1000000007")).intValue();
        }

        private int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
            int low = fromIndex;
            int high = toIndex - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = a[mid];
                if (midVal < key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
                else
                    return mid;
            }
            return -low;
        }
    }

}
