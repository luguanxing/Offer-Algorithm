package leetcode.contest.week375;

import java.math.BigInteger;
import java.util.*;

public class Test100136_统计好分割方案的数目 {

    public static void main(String[] args) {
        // nums = [1,2,3,4]
        System.out.println(new Solution().numberOfGoodPartitions(new int[]{1, 2, 3, 4}));
        // nums = [1,1,1,1]
        System.out.println(new Solution().numberOfGoodPartitions(new int[]{1, 1, 1, 1}));
        // nums = [1,2,1,3]
        System.out.println(new Solution().numberOfGoodPartitions(new int[]{1, 2, 1, 3}));
        // [1,5,1,5,6]
        System.out.println(new Solution().numberOfGoodPartitions(new int[]{1, 5, 1, 5, 6}));
        // [2,3,2,8,8]
        System.out.println(new Solution().numberOfGoodPartitions(new int[]{2, 3, 2, 8, 8}));
    }

    static class Solution {
        public int numberOfGoodPartitions(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            Map<Integer, Integer> lastIndexMap = new HashMap<>();

            // 预先遍历数组，统计每个数的出现次数以及最后出现的位置
            for (int i = 0; i < nums.length; i++) {
                countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
                lastIndexMap.put(nums[i], i);
            }

            int blockCount = 0;
            int i = 0;
            while (i < nums.length) {
                if (countMap.get(nums[i]) == 1) {
                    // 如果当前数字只出现一次，它自成一块
                    blockCount++;
                    i++;
                } else {
                    // 如果当前数字出现不止一次，找到所有这些数字的最后出现位置
                    int last = lastIndexMap.get(nums[i]);
                    for (int j = i + 1; j <= last; j++) {
                        if (countMap.get(nums[j]) > 1) {
                            last = Math.max(last, lastIndexMap.get(nums[j]));
                        }
                    }
                    blockCount++;
                    i = last + 1;
                }
            }

            int MOD = (int) (1E9 + 7);
            return new BigInteger("2")
                    .modPow(new BigInteger(blockCount - 1 + ""), new BigInteger(String.valueOf(MOD)))
                    .intValue();
        }
    }

}
