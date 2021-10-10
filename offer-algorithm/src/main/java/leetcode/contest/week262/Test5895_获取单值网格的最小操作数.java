package leetcode.contest.week262;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test5895_获取单值网格的最小操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[][]{
                {2, 4},
                {6, 8},
        }, 2));
        System.out.println(new Solution().minOperations(new int[][]{
                {1, 5},
                {2, 3},
        }, 1));
        System.out.println(new Solution().minOperations(new int[][]{
                {1, 2},
                {3, 4},
        }, 2));
        System.out.println(new Solution().minOperations(new int[][]{
                {931, 128},
                {639, 712},
        }, 73));
    }

    static class Solution {
        public int minOperations(int[][] grid, int x) {
            // 取中位数
            List<Integer> list = new ArrayList<>();
            for (int[] nums : grid) {
                list.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            }
            Collections.sort(list);
            int mid = list.get(list.size() / 2);
            int res = 0;
            for (int[] nums : grid) {
                for (int num : nums) {
                    if ( Math.abs(num - mid) % x != 0) {
                        return -1;
                    }
                    res += Math.abs(num - mid) / x;
                }
            }
            return res;
        }
    }

}
