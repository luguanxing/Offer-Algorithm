package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0506_相对名次 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Solution().findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

    static class Solution {
        public String[] findRelativeRanks(int[] score) {
            List<Integer> list = Arrays.stream(score).boxed().collect(Collectors.toList());
            Collections.sort(list, Comparator.reverseOrder());
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                int num = list.get(i);
                String index = String.valueOf(i + 1);
                if (i == 0) {
                    index = "Gold Medal";
                } else if (i == 1) {
                    index = "Silver Medal";
                } else if (i == 2) {
                    index = "Bronze Medal";
                }
                map.put(num, index);
            }
            String[] res = new String[list.size()];
            for (int i = 0; i < score.length; i++) {
                res[i] = map.get(score[i]);
            }
            return res;
        }
    }

}
