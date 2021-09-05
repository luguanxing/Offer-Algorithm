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
    }

    static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            int res = 0;
            for (int i = 1; i < properties.length; i++) {
                int[] last = properties[i - 1];
                int[] current = properties[i];
                if (current[0] > last[0] && current[1] > last[1]) {
                    res = i - 1;
                }
            }
            return res;
        }
    }

}
