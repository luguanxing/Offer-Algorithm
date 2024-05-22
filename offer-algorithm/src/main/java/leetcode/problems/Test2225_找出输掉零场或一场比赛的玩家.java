package leetcode.problems;

import java.util.*;

public class Test2225_找出输掉零场或一场比赛的玩家 {

    public static void main(String[] args) {
        // matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
        System.out.println(new Solution().findWinners(new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}
        }));
        // matches = [[2,3],[1,3],[5,4],[6,4]]
        System.out.println(new Solution().findWinners(new int[][]{
                {2, 3}, {1, 3}, {5, 4}, {6, 4}
        }));
    }

    static class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            Set<Integer> players = new HashSet<>();
            Map<Integer, Integer> loseCnt = new HashMap<>();
            for (int[] match : matches) {
                int a = match[0];
                int b = match[1];
                players.add(a);
                players.add(b);
                loseCnt.put(b, loseCnt.getOrDefault(b, 0) + 1);
            }
            List<Integer> neverLoseList = new ArrayList<>();
            List<Integer> loseOneList = new ArrayList<>();
            for (int player : players) {
                if (!loseCnt.containsKey(player)) {
                    neverLoseList.add(player);
                } else if (loseCnt.get(player) == 1) {
                    loseOneList.add(player);
                }
            }
            Collections.sort(neverLoseList);
            Collections.sort(loseOneList);
            List<List<Integer>> res = new ArrayList<>();
            res.add(neverLoseList);
            res.add(loseOneList);
            return res;
        }
    }

}
