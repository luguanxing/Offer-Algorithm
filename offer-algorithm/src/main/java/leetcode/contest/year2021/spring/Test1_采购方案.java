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
    }

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
