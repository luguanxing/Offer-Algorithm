package leetcode.problems;

import java.util.*;

public class Test3143_正方形中的最多点数 {

    public static void main(String[] args) {
        // points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca"
        System.out.println(new Solution().maxPointsInsideSquare(new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}}, "abdca"));
        // points = [[1,1],[-2,-2],[-2,2]], s = "abb"
        System.out.println(new Solution().maxPointsInsideSquare(new int[][]{{1, 1}, {-2, -2}, {-2, 2}}, "abb"));
        // points = [[1,1],[-1,-1],[2,-2]], s = "ccd"
        System.out.println(new Solution().maxPointsInsideSquare(new int[][]{{1, 1}, {-1, -1}, {2, -2}}, "ccd"));
        // points = [[-1,-4],[16,-8],[13,-3],[-12,0]], s = "abda"
        System.out.println(new Solution().maxPointsInsideSquare(new int[][]{{-1, -4}, {16, -8}, {13, -3}, {-12, 0}}, "abda"));
    }

    static class Solution {
        public int maxPointsInsideSquare(int[][] points, String s) {
            // 存储边界和点
            TreeMap<Integer, List<Character>> treeMap = new TreeMap<>();
            for (int i = 0; i < s.length(); i++) {
                int[] point = points[i];
                char label = s.charAt(i);
                int side = Math.max(Math.abs(point[1]), Math.abs(point[0]));
                List<Character> list = treeMap.getOrDefault(side, new ArrayList<>());
                list.add(label);
                treeMap.put(side, list);
            }
            // 按边长从小到大枚举对应的标签，看到哪条边才出现重复
            int sum = 0;
            Set<Character> visitedLabel = new HashSet<>();
            for (int side : treeMap.keySet()) {
                List<Character> labels = treeMap.get(side);
                for (Character label : labels) {
                    if (visitedLabel.contains(label)) {
                        return sum;
                    }
                    visitedLabel.add(label);
                }
                sum += labels.size();
            }
            return sum;
        }
    }

}
