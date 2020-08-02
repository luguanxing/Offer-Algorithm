package leetcode.contest.week200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5476_找出数组游戏的赢家 {

    public static void main(String[] args) {
        System.out.println(new Solution().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(new Solution().getWinner(new int[]{3, 2, 1}, 10));
        System.out.println(new Solution().getWinner(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(new Solution().getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }

    static class Solution {
        public int getWinner(int[] arr, int k) {
            // 重头开始向后统计并保存最大值
            int currentMax = arr[0];
            int cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                if (currentMax < arr[i]) {
                    currentMax = arr[i];
                    cnt = 1;
                } else {
                    cnt++;
                }
                if (cnt == k) {
                    // 当前该数已满足
                    return currentMax;
                }
            }
            // 计数没有达到k，那么最大的数就是结果
            return currentMax;
        }
    }

}
