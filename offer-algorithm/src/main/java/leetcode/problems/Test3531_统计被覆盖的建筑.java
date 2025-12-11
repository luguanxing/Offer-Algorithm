package leetcode.problems;

import java.util.*;

public class Test3531_统计被覆盖的建筑 {

    public static void main(String[] args) {
        // n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
        System.out.println(new Solution().countCoveredBuildings(3, new int[][]{
                {1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}
        }));
        // n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]
        System.out.println(new Solution().countCoveredBuildings(3, new int[][]{
                {1, 1}, {1, 2}, {2, 1}, {2, 2}
        }));
        // n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]
        System.out.println(new Solution().countCoveredBuildings(5, new int[][]{
                {1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}
        }));
        // n = 3, buildings = [[1,1],[2,3],[3,3],[2,2],[1,3]]
        System.out.println(new Solution().countCoveredBuildings(3, new int[][]{
                {1, 1}, {2, 3}, {3, 3}, {2, 2}, {1, 3}
        }));
        // n = 3, buildings = [[1,2],[3,1],[1,1],[3,2],[1,3]]
        System.out.println(new Solution().countCoveredBuildings(3, new int[][]{
                {1, 2}, {3, 1}, {1, 1}, {3, 2}, {1, 3}
        }));
        // n = 3, buildings = [[2,1],[2,3],[3,3],[2,2],[1,3]]
        System.out.println(new Solution().countCoveredBuildings(3, new int[][]{
                {2, 1}, {2, 3}, {3, 3}, {2, 2}, {1, 3}
        }));
    }

    static class Solution {
        public int countCoveredBuildings(int n, int[][] buildings) {
            TreeMap<Integer, TreeSet<Integer>> xMap = new TreeMap<>();
            TreeMap<Integer, TreeSet<Integer>> yMap = new TreeMap<>();
            for (int[] building : buildings) {
                int x = building[0];
                int y = building[1];
                TreeSet<Integer> treeSet = xMap.getOrDefault(x, new TreeSet<>());
                treeSet.add(y);
                xMap.put(x, treeSet);
                TreeSet<Integer> treeSetY = yMap.getOrDefault(y, new TreeSet<>());
                treeSetY.add(x);
                yMap.put(y, treeSetY);
            }
            int cnt = 0;
            for (int[] building : buildings) {
                int x = building[0];
                int y = building[1];
                TreeSet<Integer> xTreeSet = xMap.get(x);
                TreeSet<Integer> yTreeSet = yMap.get(y);
                if (
                        xTreeSet.lower(y) != null &&
                        xTreeSet.higher(y) != null &&
                        yTreeSet.lower(x) != null &&
                        yTreeSet.higher(x) != null
                ) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
