package leetcode.problems;

import java.util.*;

public class Test2831_找出最长等值子数组 {

    public static void main(String[] args) {
        // nums = [1,3,2,3,1,3], k = 3
        System.out.println(new Solution().longestEqualSubarray(Arrays.asList(1, 3, 2, 3, 1, 3), 3));
        // nums = [1,1,2,2,1,1], k = 2
        System.out.println(new Solution().longestEqualSubarray(Arrays.asList(1, 1, 2, 2, 1, 1), 2));
        System.out.println(new Solution().longestEqualSubarray(Arrays.asList(4, 4, 4, 3, 4), 1));
        System.out.println(new Solution().longestEqualSubarray(Arrays.asList(1, 1, 2, 2, 3, 2), 2));
    }

    static class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int len = nums.size();
            // 使用滑动窗口每次计算并维护右边界算出的最大的频率
            Map<Integer, Integer> freqMap = new HashMap<>();
            int maxFreq = 0;
            int l = 0;
            int r = 0;
            while (r < len) {
                int rNum = nums.get(r);
                freqMap.put(rNum, freqMap.getOrDefault(rNum, 0) + 1);
                maxFreq = Math.max(maxFreq, freqMap.get(rNum));
                r++;
                // 不满足条件（窗口比maxFreq+k还长）时收缩左边界
                while (l < r && r - l > maxFreq + k) {
                    int lNum = nums.get(l);
                    freqMap.put(lNum, freqMap.get(lNum) - 1);
                    if (freqMap.get(lNum) == 0) {
                        freqMap.remove(lNum);
                    }
                    l++;
                }
            }
            return maxFreq;
        }
    }

    static class Solution_TLE {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int len = nums.size();
            // 滑动窗口计算最多k个不同时的长度
            Map<Integer, Integer> freqMap = new HashMap<>();
            int res = 0;
            int l = 0;
            int r = 0;
            while (r < len) {
                // 扩展右边界
                int num = nums.get(r++);
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                // 不满足条件时收缩左边界
                TreeSet<Integer> freqs = new TreeSet<>(freqMap.values());
                while (l < r && r - l - freqs.last() > k) {
                    freqMap.put(nums.get(l), freqMap.get(nums.get(l)) - 1);
                    if (freqMap.get(nums.get(l)) == 0) {
                        freqMap.remove(nums.get(l));
                    }
                    l++;
                }
                res = Math.max(res, freqMap.get(num));
            }
            return res;
        }
    }

}
