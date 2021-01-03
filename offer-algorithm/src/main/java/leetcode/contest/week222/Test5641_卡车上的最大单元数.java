package leetcode.contest.week222;

import java.util.Arrays;

public class Test5641_卡车上的最大单元数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumUnits(
                new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4
        ));
        System.out.println(new Solution().maximumUnits(
                new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10
        ));
    }

    static class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            // 先按单元数从大到小排序
            Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
            // 凑出truckSize个
            int res = 0;
            int count = 0;
            for (int[] boxType : boxTypes) {
                int cnt = boxType[0];
                int unit = boxType[1];
                if (count + cnt < truckSize) {
                    count += cnt;
                    res += cnt * unit;
                } else {
                    int left = truckSize - count;
                    res += left * unit;
                    break;
                }
            }
            return res;
        }
    }

}
