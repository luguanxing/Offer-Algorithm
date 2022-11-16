package leetcode.problems;

import java.util.*;

public class Test0775_全局倒置与局部倒置 {

    public static void main(String[] args) {
        System.out.println(new Solution().isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(new Solution().isIdealPermutation(new int[]{1, 2, 0}));
    }

    static class Solution {
        public boolean isIdealPermutation(int[] nums) {
            /*
                如果全局倒置与局部倒置的数量相等，那么全局倒置就是局部倒置。说明我们不能找到 一对下标（i, j）使 i + 2 <= j 且 A[i] > A[j]。
                nums 数组排好序的结果是：nums' = [0, 1, 2, ..., n - 1]，这也就是 nums 数组的下标。
                如果要满足上面的条件，那么只能在 nums' 的基础上交换相邻的元素。也就是说 nums 数组中的每个元素与它下标的偏移量不能大于 1。否则就会出现全局倒置的数量大于局部倒置的数量的情况。
             */
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(nums[i] - i) > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution_暴力优化2 {
        public boolean isIdealPermutation(int[] nums) {
            int len = nums.length;
            int cnt1 = 0, cnt2 = 0;
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    cnt1++;
                }
            }
            Set<Integer> list = new TreeSet<>();
            for (int num : nums) {
                list.add(num);
                int idx = Collections.binarySearch(new LinkedList<>(list), num);
                int cnt = list.size() - 1 - idx;
                cnt2 += cnt;
            }
            return cnt1 == cnt2;
        }
    }

    static class Solution_暴力优化 {
        public boolean isIdealPermutation(int[] nums) {
            int len = nums.length;
            int cnt1 = 0, cnt2 = 0;
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    cnt1++;
                }
            }
            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums) {
                int cnt = 0;
                Integer next = set.higher(num);
                while (next != null) {
                    cnt++;
                    next = set.higher(next);
                }
                set.add(num);
                cnt2 += cnt;
            }
            return cnt1 == cnt2;
        }
    }

    static class Solution_暴力 {
        public boolean isIdealPermutation(int[] nums) {
            int len = nums.length;
            int cnt1 = 0, cnt2 = 0;
            for (int i = 0; i < len - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    cnt1++;
                }
            }
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        cnt2++;
                    }
                }
            }
            return cnt1 == cnt2;
        }
    }

}
