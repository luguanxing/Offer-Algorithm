package leetcode.contest.week363;

import java.util.*;

public class Test100040_让所有学生保持开心的分组方法数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countWays(Arrays.asList(1, 1)));
        System.out.println(new Solution().countWays(Arrays.asList(6, 0, 3, 3, 6, 7, 2, 7)));
        System.out.println(new Solution().countWays(Arrays.asList(5, 0, 3, 4, 2, 1, 2, 4)));
        System.out.println(new Solution().countWays(Arrays.asList(2, 2, 7, 1, 2, 2, 4, 7)));
    }

    static class Solution {
        public int countWays(List<Integer> list) {
            Set<Integer> set = new HashSet<>(list);
            int len = list.size();
            Collections.sort(list);
            int res = 0;
            for (int chosenCnt = 1; chosenCnt < len - 1; chosenCnt++) {
                if (set.contains(chosenCnt)) {
                    continue;
                }
                Integer leftScore = list.get(chosenCnt - 1);
                Integer rightScore = list.get(chosenCnt);
                if (leftScore < chosenCnt && rightScore > chosenCnt) {
                    res++;
                }
            }
            // 单独判断chosenCnt==0和chosenCnt==len的情况
            if (list.get(0) > 0) {
                res++;
            }
            if (list.get(len - 1) < len) {
                res++;
            }
            return res;
        }
    }

}
