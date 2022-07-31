package leetcode.contest.week304;

import java.util.Arrays;

public class Test6133_分组的最大数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumGroups(new int[]{10, 6, 12, 7, 3, 5}));
        System.out.println(new Solution().maximumGroups(new int[]{8, 8}));
    }

    static class Solution {
        public int maximumGroups(int[] grades) {
            int len = grades.length;
            Arrays.sort(grades);
            // 前缀和
            int[] prefixSum = new int[len];
            prefixSum[0] = grades[0];
            for (int i = 1; i < len; i++) {
                prefixSum[i] = prefixSum[i - 1] + grades[i];
            }
            // 计算分组结果
            int res = 1;
            int lastIndex = 0;
            int lastSum = prefixSum[0];
            int lastCnt = 1;
            for (int i = 1; i < len; i++) {
                if (prefixSum[i] - prefixSum[lastIndex] > lastSum && i - lastIndex > lastCnt) {
                    res++;
                    lastCnt = i - lastIndex;
                    lastSum = prefixSum[i] - prefixSum[lastIndex];
                    lastIndex = i;
                }
            }
            return res;
        }
    }

}
