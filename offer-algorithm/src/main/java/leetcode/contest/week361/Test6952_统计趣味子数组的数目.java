package leetcode.contest.week361;

import java.util.*;

public class Test6952_统计趣味子数组的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countInterestingSubarrays(Arrays.asList(3, 2, 4), 2, 1));
        System.out.println(new Solution().countInterestingSubarrays(Arrays.asList(3, 1, 9, 6), 3, 0));
    }

    static class Solution {
        public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            long res = 0;
            // 前缀和，表示当前取模modulo=k的个数
            int cntPrefix = 0;
            // 存储前缀和模 modulo 后的计数
            Map<Integer, Integer> cntMap = new HashMap<>();
            cntMap.put(0, 1);
            for (int num : nums) {
                if (num % modulo == k) {
                    cntPrefix++;
                }
                // 判断当前"取模modulo=k的个数cnt"，取余modulo的余数
                int cntRemainder = cntPrefix % modulo;
                // 判断上次差值为k的余数是否也存在于cntMap，有的话将其值加到res
                int cntRemainderOfK = (cntRemainder - k + modulo) % modulo;
                res += cntMap.getOrDefault(cntRemainderOfK, 0);
                // 更新 cntMap
                cntMap.put(cntRemainder, cntMap.getOrDefault(cntRemainder, 0) + 1);
            }
            return res;
        }
    }

}
