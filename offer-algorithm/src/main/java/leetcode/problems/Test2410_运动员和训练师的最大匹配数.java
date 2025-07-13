package leetcode.problems;

import java.util.*;

public class Test2410_运动员和训练师的最大匹配数 {

    public static void main(String[] args) {
        // players = [4,7,9], trainers = [8,2,5,8]
        System.out.println(new Solution().matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8}));
        // players = [1,1,1], trainers = [10]
        System.out.println(new Solution().matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10}));
    }

    static class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            TreeMap<Integer, Integer> trainerMap = new TreeMap<>();
            for (int trainer : trainers) {
                trainerMap.put(trainer, trainerMap.getOrDefault(trainer, 0) + 1);
            }
            int res = 0;
            for (int player : players) {
                Integer trainer = trainerMap.ceilingKey(player);
                if (trainer != null) {
                    res++;
                    if (trainerMap.get(trainer) == 1) {
                        trainerMap.remove(trainer);
                    } else {
                        trainerMap.put(trainer, trainerMap.get(trainer) - 1);
                    }
                }
            }
            return res;
        }
    }

}
