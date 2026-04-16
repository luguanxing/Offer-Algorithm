package leetcode.problems;

import java.util.*;

public class Test3488_距离最小相等元素查询 {

    public static void main(String[] args) {
        // nums = [1,3,1,4,1,3,2], queries = [0,3,5]
        System.out.println(new Solution().solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5}));
        // nums = [1,2,3,4], queries = [0,1,2,3]
        System.out.println(new Solution().solveQueries(new int[]{1, 2, 3, 4}, new int[]{0, 1, 2, 3}));
        // nums = [14,14,4,2,19,19,14,19,14], queries = [2,4,8,6,3]
        System.out.println(new Solution().solveQueries(new int[]{14, 14, 4, 2, 19, 19, 14, 19, 14}, new int[]{2, 4, 8, 6, 3}));
    }

    static class Solution {
        public List<Integer> solveQueries(int[] nums, int[] queries) {
            int len = nums.length;
            Map<Integer, TreeSet<Integer>> numIndexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                numIndexMap.computeIfAbsent(nums[i], k -> new TreeSet<>()).add(i);
            }
            List<Integer> res = new ArrayList<>();
            for (int qIdx : queries) {
                int num = nums[qIdx];
                // 找前或后最近的相同元素
                TreeSet<Integer> indexes = numIndexMap.get(num);
                Integer floor = indexes.lower(qIdx);
                Integer ceiling = indexes.higher(qIdx);
                int dis = Integer.MAX_VALUE;
                if (floor != null) {
                    dis = Math.min(dis, Math.abs(qIdx - floor));
                    dis = Math.min(dis, len - Math.abs(qIdx - floor));
                }
                if (ceiling != null) {
                    dis = Math.min(dis, Math.abs(ceiling - qIdx));
                    dis = Math.min(dis, len - Math.abs(ceiling - qIdx));
                }
                // 找数组首尾第一个相同元素（环形数组）
                Integer first = indexes.first();
                Integer last = indexes.last();
                if (first != null && first != qIdx) {
                    dis = Math.min(dis, Math.abs(first - qIdx));
                    dis = Math.min(dis, len - Math.abs(first - qIdx));
                }
                if (last != null && last != qIdx) {
                    dis = Math.min(dis, Math.abs(last - qIdx));
                    dis = Math.min(dis, len - Math.abs(last - qIdx));
                }
                res.add(dis == Integer.MAX_VALUE ? -1 : dis);
            }
            return res;
        }
    }

}
