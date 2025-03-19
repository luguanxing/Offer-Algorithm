package leetcode.problems;

import java.util.*;

public class Test2610_转换二维数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println(new Solution().findMatrix(new int[]{1, 2, 3, 4}));
    }

    static class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int key : map.keySet()) {
                int cnt = map.get(key);
                for (int i = 0; i < cnt; i++) {
                    if (res.size() == i) {
                        res.add(new ArrayList<>());
                    }
                    res.get(i).add(key);
                }
            }
            return res;
        }
    }

}
