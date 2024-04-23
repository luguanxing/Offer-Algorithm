package leetcode.problems;

import java.util.*;

public class Test1052_爱生气的书店老板 {

    public static void main(String[] args) {
        // customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
        System.out.println(new Solution().maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                3
        ));
        // customers = [1], grumpy = [0], minutes = 1
        System.out.println(new Solution().maxSatisfied(
                new int[]{1},
                new int[]{0},
                1
        ));
    }

    static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            // 计算已满意的顾客数satisfiedCount
            int n = customers.length;
            int satisfiedCount = 0;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) {
                    satisfiedCount += customers[i];
                }
            }
            // 滑动窗口计算最大挽留的顾客数maxChangeMindCount
            int currentChangeMindCount = 0;
            for (int i = 0; i < minutes; i++) {
                if (grumpy[i] == 1) {
                    currentChangeMindCount += customers[i];
                }
            }
            int maxChangeMindCount = currentChangeMindCount;
            for (int i = minutes; i < n; i++) {
                if (grumpy[i] == 1) {
                    currentChangeMindCount += customers[i];
                }
                if (grumpy[i - minutes] == 1) {
                    currentChangeMindCount -= customers[i - minutes];
                }
                maxChangeMindCount = Math.max(maxChangeMindCount, currentChangeMindCount);
            }
            // 返回结果 = 已满意的顾客数 + 最大挽留的顾客数
            return satisfiedCount + maxChangeMindCount;
        }
    }

}
