package leetcode.problems;

import java.util.*;

public class Test2009_使数组连续的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(new Solution().minOperations(new int[]{1, 2, 3, 5, 6}));
        System.out.println(new Solution().minOperations(new int[]{1, 10, 100, 1000}));
    }

    static class Solution {
        public int minOperations(int[] nums) {
            int len = nums.length;
            // 先去重排序
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : nums) {
                treeSet.add(num);
            }
            // 维持一个连续的滑动窗口，找出最大的滑动窗口长度，len-长度即为最少操作数
            List<Integer> list = new ArrayList<>(treeSet);
            TreeSet<Integer> window = new TreeSet<>();
            int res = len;
            int l = 0;
            int r = 0;
            while (r < list.size()) {
                window.add(list.get(r++));
                while (window.last() - window.first() >= len) {
                    window.remove(list.get(l++));
                }
                res = Math.min(res, len - window.size());
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public int minOperations(int[] nums) {
            int len = nums.length;
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : nums) {
                treeSet.add(num);
            }
            int res = len;
            for (int left : treeSet) {
                int right = left + len;
                // 统计需要到[left,right)这个范围的移动的次数
                int validCount = treeSet.subSet(left, right).size();
                res = Math.min(res, len - validCount);
            }
            return res;
        }
    }

}
