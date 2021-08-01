package offer;

import java.util.Arrays;

public class Test1337_矩阵中战斗力最弱的K行 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kWeakestRows(
                new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                },
                3
        )));
        System.out.println(Arrays.toString(new Solution().kWeakestRows(
                new int[][]{
                        {1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}
                },
                2
        )));
    }

    static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            int[][] powerIndex = new int[mat.length][2];
            for (int i = 0; i < mat.length; i++) {
                powerIndex[i][0] = Arrays.stream(mat[i]).sum();
                powerIndex[i][1] = i;
            }
            Arrays.sort(powerIndex, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = powerIndex[i][1];
            }
            return res;
        }
    }

}
