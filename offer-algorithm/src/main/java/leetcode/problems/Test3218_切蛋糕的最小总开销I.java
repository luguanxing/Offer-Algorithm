package leetcode.problems;

import java.util.*;

public class Test3218_切蛋糕的最小总开销I {

    public static void main(String[] args) {
        // m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]
        System.out.println(new Solution().minimumCost(3, 2, new int[]{1, 3}, new int[]{5}));
        // m = 2, n = 2, horizontalCut = [7], verticalCut = [4]
        System.out.println(new Solution().minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }

    static class Solution {
        public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
            // 初始化选择
            int[][] choices = new int[m + n][2];
            int idx = 0;
            for (int h : horizontalCut) {
                choices[idx++] = new int[]{0, h};
            }
            for (int v : verticalCut) {
                choices[idx++] = new int[]{1, v};
            }
            Arrays.sort(choices, (a, b) -> b[1] - a[1]);
            // 比如一个2*6块，先切了竖的一刀，那只需对剩下两个块分别对做横的一刀和的竖刀考虑就好，
            // 那么其实对于这两个小块都只需考虑原始值，而不考虑已经切的竖刀，不会互相影响
            // 进而通过局部最优实现全局最优（贪心按切割值原始大到小选就行）
            int hCnt = 1;
            int vCnt = 1;
            int total = 0;
            for (int[] choice : choices) {
                if (choice[0] == 0) {
                    total += choice[1] * vCnt;
                    hCnt++;
                } else {
                    total += choice[1] * hCnt;
                    vCnt++;
                }
            }
            return total;
        }
    }

}
