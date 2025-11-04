package leetcode.problems;

import java.util.*;

public class Test3321_计算子数组的xsumII {

    public static void main(String[] args) {
        // nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
        System.out.println(Arrays.toString(new Solution().findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
        // nums = [3,8,7,8,7,5], k = 2, x = 2
        System.out.println(Arrays.toString(new Solution().findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2)));
        // nums = [1000000000,1000000000,1000000000,1000000000,1000000000,1000000000]
        System.out.println(Arrays.toString(new Solution().findXSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000}, 6, 1)));
    }

    static class Solution {
        public long[] findXSum(int[] nums, int k, int x) {
            int len = nums.length;
            Map<Integer, Integer> cntMap = new HashMap<>();
            TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();
            long[] res = new long[len - k + 1];
            int resIdx = 0;
            // 初始化窗口
            // 前k个数直接加入
            for (int i = 0; i < k; i++) {
                int num = nums[i];
                int freq = cntMap.getOrDefault(num, 0);
                cntMap.put(num, freq + 1);
                // 频率更新
                if (freq > 0) {
                    freqMap.get(freq).remove(num);
                }
                freqMap.putIfAbsent(freq + 1, new TreeSet<>());
                freqMap.get(freq + 1).add(num);
            }
            // 窗口开始滑动
            for (int i = k; i <= len; i++) {
                // 取freqMap前x个频率最高的数
                long xSum = 0;
                int xCnt = 0;
                for (Integer freqKey : freqMap.descendingKeySet()) {
                    TreeSet<Integer> numSet = freqMap.get(freqKey);
                    for (Integer num : numSet.descendingSet()) {
                        xSum += (long) num * freqKey;
                        xCnt++;
                        if (xCnt == x) {
                            break;
                        }
                    }
                    if (xCnt == x) {
                        break;
                    }
                }
                res[resIdx++] = xSum;
                if (i == len) {
                    break;
                }
                // 移除窗口左侧元素
                int leftNum = nums[i - k];
                int leftFreq = cntMap.get(leftNum);
                cntMap.put(leftNum, leftFreq - 1);
                freqMap.get(leftFreq).remove(leftNum);
                if (freqMap.get(leftFreq).isEmpty()) {
                    freqMap.remove(leftFreq);
                }
                if (cntMap.get(leftNum) == 0) {
                    cntMap.remove(leftNum);
                } else {
                    freqMap.putIfAbsent(leftFreq - 1, new TreeSet<>());
                    freqMap.get(leftFreq - 1).add(leftNum);
                }
                // 添加窗口右侧元素
                int rightNum = nums[i];
                int rightFreq = cntMap.getOrDefault(rightNum, 0);
                cntMap.put(rightNum, rightFreq + 1);
                freqMap.getOrDefault(rightFreq, new TreeSet<>()).remove(rightNum);
                freqMap.putIfAbsent(rightFreq + 1, new TreeSet<>());
                freqMap.get(rightFreq + 1).add(rightNum);
            }
            return res;
        }
    }

}
