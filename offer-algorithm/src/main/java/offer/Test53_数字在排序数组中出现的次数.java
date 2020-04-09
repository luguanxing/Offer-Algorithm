package offer;

import java.util.HashMap;
import java.util.Map;

public class Test53_数字在排序数组中出现的次数 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 5};
        System.out.println(new Solution().GetNumberOfK(nums, 5));
        System.out.println(new Solution().GetNumberOfK(nums, 1));
        System.out.println(new Solution().GetNumberOfK(nums, 3));
        System.out.println(new Solution().GetNumberOfK(nums, 2));
        System.out.println(new Solution().GetNumberOfK(nums, 999));
    }

    static class Solution_Map {
        public int GetNumberOfK(int[] array, int k) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            for (Integer num : array) {
                if (numCountMap.containsKey(num)) {
                    numCountMap.put(num, numCountMap.get(num) + 1);
                } else {
                    numCountMap.put(num, 1);
                }
            }
            return numCountMap.get(k) == null ? 0 : numCountMap.get(k);
        }
    }

    static class Solution {
        public int GetNumberOfK(int[] array, int k) {
            int firstK = 0;
            int lastK = array.length;
            int left = 0;
            int right = array.length - 1;
            // 判断k是否存在数组中
            if (binarySearchIndex(array, left, right, k) == -1) {
                return 0;
            }
            // 通过二分和向前预判找到第一个K
            do {
                int indexOfK = binarySearchIndex(array, left, right, k);
                if (indexOfK == 0 || array[indexOfK - 1] != k) {
                    firstK = indexOfK;
                    break;
                } else {
                    right = indexOfK - 1;
                }
            } while (true);
            // 通过二分和向后预判找到最后一个K
            left = 0;
            right = array.length;
            do {
                int indexOfK = binarySearchIndex(array, left, right, k);
                if (indexOfK == array.length - 1 || array[indexOfK + 1] != k) {
                    lastK = indexOfK;
                    break;
                } else {
                    left = indexOfK + 1;
                }
            } while (true);
            return lastK - firstK + 1;
        }

        public int binarySearchIndex(int[] array, int start, int end, int k) {
            int left = start;
            int right = end;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid] < k) {
                    left = mid + 1;
                } else if (k < array[mid]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

}
