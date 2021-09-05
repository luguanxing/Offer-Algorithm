package leetcode.contest.week257;

import java.util.Arrays;

public class Test5864_游戏中弱角色的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWeakCharacters(
                new int[][]{{5, 5}, {6, 3}, {3, 6}}
        ));
        System.out.println(new Solution().numberOfWeakCharacters(
                new int[][]{{2, 2}, {3, 3}}
        ));
        System.out.println(new Solution().numberOfWeakCharacters(
                new int[][]{{1, 5}, {10, 4}, {4, 3}}
        ));
        System.out.println(new Solution().numberOfWeakCharacters(
                new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}}
        ));
        System.out.println(new Solution().numberOfWeakCharacters(
                new int[][]{{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}}
        ));
    }

    static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            // 先根据攻击力排序从高到低，再根据防御力从低到高排序
            Arrays.sort(properties, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return -Integer.compare(o1[0], o2[0]);
                }
            });
            // 逐个比较当前防御力与之前的最大防御力
            // 因为攻击力相同时防御力从低到高，所以不用如果比之前最大防御力低那肯定是在攻击力不同的情况
            int res = 0;
            int maxDefense = properties[0][1];
            for (int i = 1; i < properties.length; i++) {
                if (maxDefense > properties[i][1]) {
                    // 当前攻防双低
                    res++;
                }
                maxDefense = Math.max(maxDefense, properties[i][1]);
            }
            return res;
        }
    }

}
