package leetcode.contest.week387;

import java.util.*;

public class Test100246_将元素分配到两个数组中II {

    public static void main(String[] args) {
        // nums = [2,1,3,3]
        System.out.println(Arrays.toString(new Solution().resultArray(new int[]{2, 1, 3, 3})));
        // nums = [5,14,3,1,2]
        System.out.println(Arrays.toString(new Solution().resultArray(new int[]{5, 14, 3, 1, 2})));
        // nums = [3,3,3,3]
        System.out.println(Arrays.toString(new Solution().resultArray(new int[]{3, 3, 3, 3})));
        System.out.println(Arrays.toString(new Solution().resultArray(new int[]{2, 38, 2})));
    }

    static class Solution {
        TreeMap<Integer, Integer> t1 = new TreeMap<>();
        TreeMap<Integer, Integer> t2 = new TreeMap<>();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        public int[] resultArray(int[] nums) {
            // 第一步，直接添加
            addToArrAndMap(nums[0], true); // true 表示添加到 arr1 和 t1
            addToArrAndMap(nums[1], false); // false 表示添加到 arr2 和 t2

            // 从第三个元素开始遍历
            for (int i = 2; i < nums.length; i++) {
                // 计算greaterCount
                int count1 = greaterCount(t1, nums[i]);
                int count2 = greaterCount(t2, nums[i]);
                // 根据条件添加到arr1或arr2
                if (count1 > count2 || (count1 == count2 && arr1.size() <= arr2.size())) {
                    addToArrAndMap(nums[i], true);
                } else {
                    addToArrAndMap(nums[i], false);
                }
            }

            // 合并arr1和arr2
            arr1.addAll(arr2);
            // 转换为int[]
            return arr1.stream().mapToInt(Integer::intValue).toArray();
        }

        private void addToArrAndMap(int num, boolean toArr1) {
            if (toArr1) {
                arr1.add(num);
                t1.put(num, t1.getOrDefault(num, 0) + 1);
            } else {
                arr2.add(num);
                t2.put(num, t2.getOrDefault(num, 0) + 1);
            }
        }

        private int greaterCount(TreeMap<Integer, Integer> map, int val) {
            return map.tailMap(val + 1).values().stream().mapToInt(Integer::intValue).sum();
        }
    }


}
