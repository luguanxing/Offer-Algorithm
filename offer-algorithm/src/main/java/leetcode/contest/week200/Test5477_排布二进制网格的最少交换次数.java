package leetcode.contest.week200;

import java.util.*;

public class Test5477_排布二进制网格的最少交换次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps(
                new int[][]{
                        {1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                }
        ));
        System.out.println(new Solution().minSwaps(
                new int[][]{
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0},
                }
        ));
        System.out.println(new Solution().minSwaps(
                new int[][]{
                        {1, 0, 0},
                        {1, 1, 0},
                        {1, 0, 1},
                }
        ));
        System.out.println(new Solution().minSwaps(
                new int[][]{
                        {0, 0},
                        {0, 1},
                }
        ));
    }

    static class Solution {
        public int minSwaps(int[][] grid) {
            // 先判断从右至左有多少个连续的0，保存起来
            int len = grid.length;
            List<Integer> list = new ArrayList<>();
            for (int[] row : grid) {
                int cnt = 0;
                for (int i = len - 1; i >= 0; i--) {
                    if (row[i] == 0) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt == len) {
                    cnt = len - 1;
                }
                // 数目相同时向下弥补
                while (list.contains(cnt)) {
                    cnt--;
                }
                list.add(cnt);
            }
            // 将上面的数，计算排序n-1到1需要多少步
            int res = 0;
            for (int i = 0; i < len - 1; i++) {
                if (list.get(i) != len - 1 - i) {
                    // 寻找长度为len-1-i并移到前面
                    int index = list.indexOf(len - 1 - i);
                    if (index == -1) {
                        return -1;
                    }
                    for (int j = index; j > i; j--) {
                        int tmp = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, tmp);
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
