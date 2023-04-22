package leetcode.contest.year2023.spring;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test1_补给马车 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().supplyWagon(new int[]{7, 3, 6, 1, 8})));
        System.out.println(Arrays.toString(new Solution().supplyWagon(new int[]{1, 3, 1, 5})));
    }

    static class Solution {
        public int[] supplyWagon(int[] supplies) {
            int len = supplies.length;
            List<Integer> list = Arrays.stream(supplies).boxed().collect(Collectors.toList());
            while (list.size() > len / 2) {
                int min = Integer.MAX_VALUE;
                int minIdx = -1;
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) + list.get(i + 1) < min) {
                        min = list.get(i) + list.get(i + 1);
                        minIdx = i;
                    }
                }
                list.remove(minIdx);
                list.remove(minIdx);
                list.add(minIdx, min);
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
