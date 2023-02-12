package leetcode.contest.week332;

import java.util.*;

public class Test6356_子字符串异或查询 {

    public static void main(String[] args) {
        new Solution().substringXorQueries("101101", new int[][]{{0, 5}, {1, 2}});
        new Solution().substringXorQueries("0101", new int[][]{{12, 8}});
        new Solution().substringXorQueries("1", new int[][]{{4, 5}});
    }

    static class Solution {
        public int[][] substringXorQueries(String s, int[][] queries) {
            int qLen = queries.length;
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < qLen; i++) {
                int first = queries[i][0];
                int second = queries[i][1];
                int xor = first ^ second;
                String xorStr = Integer.toBinaryString(xor);
                List<Integer> list = map.getOrDefault(xorStr, new ArrayList<>());
                list.add(i);
                map.put(xorStr, list);
            }
            int[][] res = new int[qLen][2];
            Arrays.fill(res, new int[]{-1, -1});
            int sLen = s.length();
            for (int i = 0; i < sLen; i++) {
                // 关键需要剪枝，保留长度30以内的数，否则2^30 > 10^9
                for (int j = i + 1; j <= Math.min(sLen, i + 31); j++) {
                    String str = s.substring(i, j);
                    if (map.containsKey(str)) {
                        for (int idx : map.get(str)) {
                            res[idx] = new int[]{i, j - 1};
                        }
                        map.remove(str);
                    }
                }
            }
            return res;
        }
    }

    static class Solution_TLE2 {
        public int[][] substringXorQueries(String s, int[][] queries) {
            int qLen = queries.length;
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < qLen; i++) {
                int first = queries[i][0];
                int second = queries[i][1];
                int xor = first ^ second;
                String xorStr = Integer.toBinaryString(xor);
                List<Integer> list = map.getOrDefault(xorStr, new ArrayList<>());
                list.add(i);
                map.put(xorStr, list);
            }
            int[][] res = new int[qLen][2];
            Arrays.fill(res, new int[]{-1, -1});
            int sLen = s.length();
            for (int i = 0; i < sLen; i++) {
                for (int j = i + 1; j <= sLen; j++) {
                    String str = s.substring(i, j);
                    if (map.containsKey(str)) {
                        for (int idx : map.get(str)) {
                            res[idx] = new int[]{i, j - 1};
                        }
                        map.remove(str);
                    }
                }
            }
            return res;
        }
    }

    static class Solution_TLE {
        public int[][] substringXorQueries(String s, int[][] queries) {
            int len = queries.length;
            int[][] res = new int[len][2];
            for (int i = 0; i < len; i++) {
                int first = queries[i][0];
                int second = queries[i][1];
                int xor = first ^ second;
                String xorStr = Integer.toBinaryString(xor);
                int index = s.indexOf(xorStr);
                if (index < 0) {
                    res[i] = new int[]{-1, -1};
                } else {
                    res[i] = new int[]{index, index + xorStr.length() - 1};
                }
            }
            return res;
        }
    }

}
