package leetcode.problems;

import java.util.Arrays;

public class Test0593_有效的正方形 {

    public static void main(String[] args) {
        System.out.println(new Solution().validSquare(
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}
        ));
    }

    static class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            double[] pMid = getMid(p1, p2, p3, p4);
            // 中点到各边相等(可能是矩形或正方形)
            if (getDistance(pMid, p1) == getDistance(pMid, p2) && getDistance(pMid, p2) == getDistance(pMid, p3) && getDistance(pMid, p3) == getDistance(pMid, p4)) {
                // 一个角到另外三个角判断正方形
                double[] distances = {
                        getDistance(p1, p2),
                        getDistance(p1, p3),
                        getDistance(p1, p4),
                };
                Arrays.sort(distances);
                if (distances[0] != 0 && distances[0] == distances[1] && distances[0] + distances[1] == distances[2]) {
                    return true;
                }
            }
            return false;
        }

        private double[] getMid(int[] p1, int[] p2, int[] p3, int[] p4) {
            return new double[]{
                    (p1[0] + p2[0] + p3[0] + p4[0]) / 4.0,
                    (p1[1] + p2[1] + p3[1] + p4[1]) / 4.0,
            };
        }


        private double getDistance(double[] pMid, int[] p1) {
            return (pMid[0] - p1[0]) * (pMid[0] - p1[0]) + (pMid[1] - p1[1]) * (pMid[1] - p1[1]);
        }

        private double getDistance(int[] p1, int[] p2) {
            return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        }
    }

}
