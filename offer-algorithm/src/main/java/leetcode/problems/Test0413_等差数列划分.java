package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0413_等差数列划分 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 2, 3, 6, 7, 8}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    static class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int[] diff = new int[nums.length - 1];
            for (int i = 1; i < nums.length; i++) {
                diff[i - 1] = nums[i] - nums[i - 1];
            }
            int res = 0;
            int cur = diff.length > 0 ? diff[0] : 0;
            int times = 1;
            for (int i = 1; i <= diff.length; i++) {
                if (i == diff.length || diff[i] != cur) {
                    res += times * (times - 1) / 2;
                    if (i < diff.length) {
                        cur = diff[i];
                        times = 1;
                    }
                } else {
                    times++;
                }
            }
            return res;
        }
    }

    static class Solution_原始 {
        public int numberOfArithmeticSlices(int[] nums) {
            // 前后差的数组
            int[] diff = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                diff[i - 1] = nums[i] - nums[i - 1];
            }
            // 统计相同的差出现频次
            List<int[]> statList = new ArrayList<>();
            int cur = diff[0];
            int times = 1;
            for (int i = 1; i < diff.length; i++) {
                if (i == diff.length - 1 || diff[i] != cur) {
                    int[] stat = new int[2];
                    stat[0] = cur;
                    stat[1] = times;
                    statList.add(stat);
                    if (i != diff.length - 1) {
                        cur = diff[i];
                        times = 1;
                    }
                } else {
                    times++;
                }
            }
            // 统计结果 -> N个相同的数(n>=3)
            //  1个长度为N数组
            //  2个长度为N-1数组
            //  ...
            //  n-1个长度为2数组
            //  res += 1 + 2 + ... n-1
            int res = 0;
            for (int[] stat : statList) {
                int t = stat[1];
                res += t * (t - 1) / 2;
            }
            return res;
        }
    }

}
