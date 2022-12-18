package leetcode.contest.week324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6268_查询树中环的长度 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().cycleLengthQueries(
                3, new int[][]{{5, 3}, {4, 7}, {2, 3}}
        )));
        System.out.println(Arrays.toString(new Solution().cycleLengthQueries(
                2, new int[][]{{1, 2}}
        )));
        System.out.println(Arrays.toString(new Solution().cycleLengthQueries(
                5, new int[][]{{17, 21}}
        )));
    }

    static class Solution {
        public int[] cycleLengthQueries(int n, int[][] queries) {
            int len = queries.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int[] query = queries[i];
                int a = query[0];
                int b = query[1];
                List<Integer> pathA = getPath(a);
                List<Integer> pathB = getPath(b);
                // 计算公共祖先
                int rootLen = 0;
                for (int j = 0; j < Math.min(pathA.size(), pathB.size()); j++) {
                    if ((int) pathA.get(j) == pathB.get(j)) {
                        rootLen++;
                    }
                }
                res[i] = (pathA.size() - rootLen) + (pathB.size() - rootLen) + 1;
            }
            return res;
        }

        private List<Integer> getPath(int num) {
            List<Integer> path = new ArrayList<>();
            while (num > 0) {
                path.add(0, num);
                num /= 2;
            }
            return path;
        }
    }

}
