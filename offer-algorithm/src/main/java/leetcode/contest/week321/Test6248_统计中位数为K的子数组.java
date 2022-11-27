package leetcode.contest.week321;

import java.util.*;

public class Test6248_统计中位数为K的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSubarrays(
                new int[]{3, 2, 1, 4, 5}, 4
        ));
        System.out.println(new Solution().countSubarrays(
                new int[]{2, 3, 1}, 3
        ));
        System.out.println(new Solution().countSubarrays(
                new int[]{1, 2, 3, 4, 5}, 3
        ));
        System.out.println(new Solution().countSubarrays(
                new int[]{2, 5, 1, 4, 3, 6}, 1
        ));
    }

    static class Solution {
        public int countSubarrays(int[] nums, int k) {
            int len = nums.length;
            // 找出k所在下标idx
            int idx = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == k) {
                    idx = i;
                    break;
                }
            }
            // 统计idx之前的后缀和个数
            Map<Integer, Integer> map = new HashMap<>();
            int suffixSum = 0;
            for (int i = idx - 1; i >= 0; i--) {
                if (nums[i] < k) {
                    suffixSum--;
                } else {
                    suffixSum++;
                }
                map.put(suffixSum, map.getOrDefault(suffixSum, 0) + 1);
            }
            // 枚举idx与idx之前后缀和的和，和为0或1的数目可计入答案
            int res = 0;
            res += 1;
            res += map.getOrDefault(0, 0);
            res += map.getOrDefault(1, 0);
            // 枚举idx之后的数与idx+idx之前后缀和的和，和为0或1的数目可计入答案
            int prefixSum = 0;
            map.put(0, map.getOrDefault(0, 0) + 1);
            for (int i = idx + 1; i < len; i++) {
                if (nums[i] < k) {
                    prefixSum--;
                } else {
                    prefixSum++;
                }
                res += map.getOrDefault(-prefixSum, 0);
                res += map.getOrDefault(-prefixSum + 1, 0);
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public int countSubarrays(int[] nums, int k) {
            int len = nums.length;
            // 找出k所在下标idx
            int idx = -1;
            for (int i = 0; i < len; i++) {
                if (nums[i] == k) {
                    idx = i;
                    break;
                }
            }
            // 使用前缀和计算包括idx的子序列为0或1的个数
            int res = 0;
            int x = 0;
            int d = 0;
            for (int l = idx; l >= 0; l--) {
                if (nums[l] < k) {
                    x++;
                } else if (nums[l] > k) {
                    d++;
                }
                int xx = x;
                int dd = d;
                for (int r = idx; r < len; r++) {
                    if (nums[r] < k) {
                        x++;
                    } else if (nums[r] > k) {
                        d++;
                    }
                    if (x == d || x + 1 == d) {
                        res++;
                    }
                }
                x = xx;
                d = dd;
            }
            return res;
        }
    }
}
