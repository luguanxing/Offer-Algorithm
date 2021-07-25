package leetcode.problems;

import java.util.*;

public class Test1743_从相邻元素对还原数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().restoreArray(
                new int[][]{{2, 1}, {3, 4}, {3, 2}}
        )));
        System.out.println(Arrays.toString(new Solution().restoreArray(
                new int[][]{{4, -2}, {1, 4}, {-3, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().restoreArray(
                new int[][]{{100000, -100000}}
        )));
    }

    static class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            // 记录相邻关系
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] pair : adjacentPairs) {
                map.putIfAbsent(pair[0], new ArrayList<>());
                map.putIfAbsent(pair[1], new ArrayList<>());
                map.get(pair[0]).add(pair[1]);
                map.get(pair[1]).add(pair[0]);
            }
            // 由于存在所有的相邻关系，所以总数是adjacentPairs.length + 1
            // 先找到首节点（尾结点）
            int len = adjacentPairs.length + 1;
            int[] res = new int[len];
            for (int key : map.keySet()) {
                if (map.get(key).size() == 1) {
                    res[0] = key;
                    break;
                }
            }
            // 从首节点开始连接
            res[1] = map.get(res[0]).get(0);
            for (int i = 2; i < len; i++) {
                List<Integer> neighbors = map.get(res[i - 1]);
                res[i] = res[i - 2] == neighbors.get(0) ? neighbors.get(1) : neighbors.get(0);
            }
            return res;
        }
    }

}
