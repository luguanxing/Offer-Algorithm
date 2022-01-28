package leetcode.problems;

import java.util.Arrays;

public class Test1996_游戏中弱角色的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWeakCharacters(new int[][]{
                {5, 5}, {6, 3}, {3, 6}
        }));
        System.out.println(new Solution().numberOfWeakCharacters(new int[][]{
                {2, 2}, {3, 3}
        }));
        System.out.println(new Solution().numberOfWeakCharacters(new int[][]{
                {1, 5}, {10, 4}, {4, 3}
        }));
    }

    static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            // 先按攻高到低，再按防低到高排序
            Arrays.sort(properties, (p1, p2) -> {
                if (p1[0] != p2[0]) {
                    return -Integer.compare(p1[0], p2[0]);
                } else {
                    return Integer.compare(p1[1], p2[1]);
                }
            });
            // 因为攻击力相同时防御力从低到高，所以如果比之前最大防御力低那肯定是在攻击力不同(小于之前)的情况
            int res = 0;
            int maxDefend = 0;
            for (int[] p : properties) {
                int currentDefend = p[1];
                if (maxDefend > currentDefend) {
                    res++;
                }
                maxDefend = Math.max(maxDefend, currentDefend);
            }
            return res;
        }
    }

}
