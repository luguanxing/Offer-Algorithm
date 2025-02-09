package leetcode.problems;

import java.util.*;

public class Test0080_删除有序数组中的重复项II {

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            int fastIndex = 0;
            int slowIndex = 0;
            while (fastIndex < len) {
                int cnt = 1;
                int nextIndex = fastIndex + 1;
                while (nextIndex < len && nums[nextIndex] == nums[fastIndex]) {
                    cnt++;
                    nextIndex++;
                }
                for (int i = 0; i < Math.min(2, cnt); i++) {
                    nums[slowIndex++] = nums[fastIndex];
                }
                fastIndex = nextIndex;
            }
            return slowIndex;
        }
    }

    static class Solution_SIMPLE {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int num : nums) {
                if (i < 2 || num > nums[i - 2]) {
                    nums[i++] = num;
                }
            }
            return i;
        }
    }

    static class Solution_MAP {
        public int removeDuplicates(int[] nums) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            int index = 0;
            for (int num : nums) {
                int freq = freqMap.getOrDefault(num, 0);
                if (freq >= 2) {
                    continue;
                }
                freqMap.put(num, freq + 1);
                nums[index++] = num;
            }
            return index;
        }
    }

}
