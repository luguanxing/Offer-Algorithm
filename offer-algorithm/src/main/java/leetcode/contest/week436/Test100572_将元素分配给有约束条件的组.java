package leetcode.contest.week436;

import java.util.Arrays;

public class Test100572_将元素分配给有约束条件的组 {

    public static void main(String[] args) {
        // groups = [8,4,3,2,4], elements = [4,2]
        System.out.println(Arrays.toString(new Solution().assignElements(new int[]{8, 4, 3, 2, 4}, new int[]{4, 2})));
        // groups = [2,3,5,7], elements = [5,3,3]
        System.out.println(Arrays.toString(new Solution().assignElements(new int[]{2, 3, 5, 7}, new int[]{5, 3, 3})));
        // groups = [10,21,30,41], elements = [2,1]
        System.out.println(Arrays.toString(new Solution().assignElements(new int[]{10, 21, 30, 41}, new int[]{2, 1})));
    }

    static class Solution {
        public int[] assignElements(int[] groups, int[] elements) {
            int eLen = elements.length;
            int gLen = groups.length;
            int MAX = (int) (1E5+5);

            // 记录每个数值的最小下标
            int[] minElementIndex = new int[MAX];
            Arrays.fill(minElementIndex, -1);
            for (int i = 0; i < eLen; i++) {
                int val = elements[i];
                if (minElementIndex[val] == -1) {
                    minElementIndex[val] = i;
                }
            }

            // 对每个组，找出满足 groups[i] % elements[j] == 0 的 j，取下标最小的那个
            int[] minDivIndex = new int[gLen];
            for (int i = 0; i < gLen; i++) {
                int groupVal = groups[i];
                int divIndex = Integer.MAX_VALUE;
                int sqrt = (int) Math.sqrt(groupVal);
                for (int d = 1; d <= sqrt; d++) {
                    if (groupVal % d == 0) {
                        int other = groupVal / d;
                        // 检查第一个因子 d
                        if (minElementIndex[d] != -1) {
                            divIndex = Math.min(divIndex, minElementIndex[d]);
                        }
                        // 检查另一因子 other
                        if (other != d && minElementIndex[other] != -1) {
                            divIndex = Math.min(divIndex, minElementIndex[other]);
                        }
                    }
                }
                minDivIndex[i] = (divIndex == Integer.MAX_VALUE) ? -1 : divIndex;
            }

            return minDivIndex;
        }
    }

}
