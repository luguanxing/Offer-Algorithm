package leetcode.problems;

import java.util.*;

public class Test3623_统计梯形的数目I {

    public static void main(String[] args) {
        // points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
        System.out.println(new Solution().countTrapezoids(new int[][]{
                {1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}
        }));
        // points = [[0,0],[1,0],[0,1],[2,1]]
        System.out.println(new Solution().countTrapezoids(new int[][]{
                {0, 0}, {1, 0}, {0, 1}, {2, 1}
        }));
    }

    static class Solution {
        public int countTrapezoids(int[][] points) {
            Map<Integer, Integer> yPointCnt = new HashMap<>();
            for (int[] point : points) {
                yPointCnt.put(point[1], yPointCnt.getOrDefault(point[1], 0) + 1);
            }
            List<Long> ySideCnts = new ArrayList<>();
            Long ySideCntsSum = 0L;
            for (int cnt : yPointCnt.values()) {
                long ySideCnt = (long) cnt * (cnt - 1) / 2;
                ySideCnts.add(ySideCnt);
                ySideCntsSum += ySideCnt;
            }
            long res = 0;
            for (long side : ySideCnts) {
                res += (ySideCntsSum - side) * side;
            }
            return (int) ((res / 2) % (int) (1e9 + 7));
        }
    }

}
