package leetcode.contest.week333;

import java.util.TreeMap;

public class Test6362_合并两个二维数组_求和法 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int[] kv : nums1) {
                map.merge(kv[0], kv[1], Integer::sum);
            }
            for (int[] kv : nums2) {
                map.merge(kv[0], kv[1], Integer::sum);
            }
            int[][] res = new int[map.size()][2];
            int index = 0;
            for (int k : map.keySet()) {
                int v = map.get(k);
                res[index++] = new int[]{k, v};
            }
            return res;
        }
    }

}
