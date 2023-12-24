package leetcode.contest.week377;

import java.util.*;

public class Test100169_移除栅栏得到的正方形田地的最大面积 {

    public static void main(String[] args) {
        // m = 4, n = 3, hFences = [2,3], vFences = [2]
        System.out.println(new Solution().maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
        // m = 6, n = 7, hFences = [2], vFences = [4]
        System.out.println(new Solution().maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}));
    }

    static class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            // 添加边界
            hFences = addBoundary(hFences, m);
            vFences = addBoundary(vFences, n);
            Arrays.sort(hFences);
            Arrays.sort(vFences);
            // 预处理距离
            Set<Integer> hDistances = new HashSet<>();
            Set<Integer> vDistances = new HashSet<>();
            for (int i = 0; i < hFences.length; i++) {
                for (int j = i + 1; j < hFences.length; j++) {
                    hDistances.add(hFences[j] - hFences[i]);
                }
            }
            for (int i = 0; i < vFences.length; i++) {
                for (int j = i + 1; j < vFences.length; j++) {
                    vDistances.add(vFences[j] - vFences[i]);
                }
            }
            long maxSquare = 0;
            // 用二分查找匹配距离
            for (int distance : hDistances) {
                if (vDistances.contains(distance)) {
                    maxSquare = Math.max(maxSquare, (long)distance * distance);
                }
            }
            return maxSquare == 0 ? -1 : (int) (maxSquare % 1000000007);
        }

        private int[] addBoundary(int[] fences, int boundary) {
            int[] newFences = new int[fences.length + 2];
            newFences[0] = 1;
            newFences[newFences.length - 1] = boundary;
            System.arraycopy(fences, 0, newFences, 1, fences.length);
            return newFences;
        }
    }

}
