package leetcode.contest.week382;

import java.util.*;

public class Test100206_子集中元素的最大数量 {

    public static void main(String[] args) {
        // nums = [5,4,1,2,2]
        System.out.println(new Solution().maximumLength(new int[]{5, 4, 1, 2, 2}));
        // nums = [1,3,2,4]
        System.out.println(new Solution().maximumLength(new int[]{1, 3, 2, 4}));
        System.out.println(new Solution().maximumLength(new int[]{1, 1, 1}));
        System.out.println(new Solution().maximumLength(new int[]{1, 1}));
        System.out.println(new Solution().maximumLength(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(new Solution().maximumLength(new int[]{1, 16, 49, 16, 121}));
        System.out.println(new Solution().maximumLength(new int[]{14, 14, 196, 196, 38416, 38416}));
        System.out.println(new Solution().maximumLength(new int[]{16, 9, 81, 81, 64, 100, 81, 1, 25, 49}));
    }

    static class Solution {
        public int maximumLength(int[] nums) {
            // 哈希映射存储每个数字的出现次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int maxLength = 1;
            for (int num : map.keySet()) {
                if (num == 1) {
                    int cnt = map.get(1);
                    if (cnt % 2 == 1) {
                        maxLength = Math.max(maxLength, map.get(1));
                    } else {
                        maxLength = Math.max(maxLength, map.get(1) - 1);
                    }
                    continue;
                }
                int current = num;
                int len = map.get(current);
                if (len == 1) {
                    continue;
                }
                if (len > 2) {
                    len = 2;
                }
                while (map.containsKey(current * current)) {
                    if (map.get(current * current) == 1) {
                        len++;
                        break;
                    }
                    current *= current;
                    len += 2;
                }
                if (len % 2 == 0) {
                    len--;
                }
                maxLength = Math.max(maxLength, len);
            }
            return maxLength;
        }
    }

}
