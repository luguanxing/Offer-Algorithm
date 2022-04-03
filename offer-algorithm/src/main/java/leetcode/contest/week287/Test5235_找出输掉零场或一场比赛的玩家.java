package leetcode.contest.week287;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test5235_找出输掉零场或一场比赛的玩家 {

    public static void main(String[] args) {
        System.out.println(new Solution().findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));
        System.out.println(new Solution().findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}}));
    }

    static class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            Map<Integer, Integer> loseCntMap = new TreeMap<>();
            for (int[] match : matches) {
                int winner = match[0];
                int looser = match[1];
                loseCntMap.put(winner, loseCntMap.getOrDefault(winner, 0));
                loseCntMap.put(looser, loseCntMap.getOrDefault(looser, 0) + 1);
            }
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> lose0 = new ArrayList<>();
            List<Integer> lose1 = new ArrayList<>();
            for (int player : loseCntMap.keySet()) {
                int loseCnt = loseCntMap.get(player);
                if (loseCnt == 0) {
                    lose0.add(player);
                }
                if (loseCnt == 1) {
                    lose1.add(player);
                }
            }
            res.add(lose0);
            res.add(lose1);
            return res;
        }
    }

}
