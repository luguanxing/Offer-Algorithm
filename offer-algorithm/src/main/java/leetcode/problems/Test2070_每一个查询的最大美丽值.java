package leetcode.problems;

import java.util.*;

public class Test2070_每一个查询的最大美丽值 {

    public static void main(String[] args) {
        // items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
        System.out.println(Arrays.toString(new Solution().maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6})));
        // items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
        System.out.println(Arrays.toString(new Solution().maximumBeauty(new int[][]{{1, 2}, {1, 2}, {1, 3}, {1, 4}}, new int[]{1})));
        // items = [[10,1000]], queries = [5]
        System.out.println(Arrays.toString(new Solution().maximumBeauty(new int[][]{{10, 1000}}, new int[]{5})));
    }

    static class Solution {
        public int[] maximumBeauty(int[][] items, int[] queries) {
            // 先按价格排序
            Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
            // 按价格递增构建map
            int currentBeauty = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int[] item : items) {
                int price = item[0];
                int beauty = item[1];
                currentBeauty = Math.max(currentBeauty, beauty);
                map.put(price, currentBeauty);
            }
            // 更新结果
            int len = queries.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int query = queries[i];
                Integer price = map.floorKey(query);
                if (price != null) {
                    res[i] = map.get(price);
                }
            }
            return res;
        }
    }

}
