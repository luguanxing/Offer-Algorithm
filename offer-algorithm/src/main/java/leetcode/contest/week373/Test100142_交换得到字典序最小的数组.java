package leetcode.contest.week373;

import java.util.*;

public class Test100142_交换得到字典序最小的数组 {

    public static void main(String[] args) {
        // nums = [1,5,3,9,8], limit = 2
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 5, 3, 9, 8}, 2)));
        // nums = [1,7,6,18,2,1], limit = 3
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 7, 6, 18, 2, 1}, 3)));
        // nums = [1,7,28,19,10], limit = 3
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 7, 28, 19, 10}, 3)));


        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 7, 5, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 7, 5, 2}, 2)));

        // [1,60,34,84,62,56,39,76,49,38], 4
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{1, 60, 34, 84, 62, 56, 39, 76, 49, 38}, 4)));

        // [89,52,73,74,73,20,92,35,26,73], 9
        System.out.println(Arrays.toString(new Solution().lexicographicallySmallestArray(new int[]{89, 52, 73, 74, 73, 20, 92, 35, 26, 73}, 9)));
    }

    /*
        给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。
        在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。
        返回执行任意次操作后能得到的 字典序最小的数组 。
        如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应字符比数组 b 中的对应字符的字典序更小，则认为数组 a 就比数组 b 字典序更小。例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。
     */
    static class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            TreeMap<Integer, Integer> leftMap = new TreeMap<>();
            Map<Integer, List<Integer>> indexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
                List<Integer> list = indexMap.getOrDefault(num, new ArrayList<>());
                list.add(i);
                indexMap.put(num, list);
            }
            // 贪心替换
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (leftMap.getOrDefault(num, 0) != 0) {
                    leftMap.put(num, leftMap.get(num) - 1);
                    if (leftMap.get(num) == 0) {
                        leftMap.remove(num);
                    }
                }
                // 从leftMap在满足limit下不断找比num最小的数替换
                Integer replace = num;
                while (leftMap.containsKey(replace - limit) || (leftMap.higherKey(replace - limit) != null && leftMap.higherKey(replace - limit) < replace)) {
                    if (leftMap.containsKey(replace - limit)) {
                        replace = replace - limit;
                    } else {
                        replace = leftMap.higherKey(replace - limit);
                    }
                }
                if (replace >= num) {
                    continue;
                }
                // 替换
                nums[i] = replace;
                leftMap.put(replace, leftMap.get(replace) - 1);
                if (leftMap.get(replace) == 0) {
                    leftMap.remove(replace);
                }
                leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
                int j = 0;
                int index = indexMap.get(replace).get(j);
                while (indexMap.get(replace).get(j) <= i) {
                    j++;
                    if (j >= indexMap.get(replace).size()) {
                        break;
                    }
                    index = indexMap.get(replace).get(j);
                }
                indexMap.get(replace).remove(0);
                indexMap.get(num).add(index);
                Collections.sort(indexMap.get(num));
                indexMap.get(num).remove(0);
                nums[index] = num;
            }
            return nums;
        }
    }

}
