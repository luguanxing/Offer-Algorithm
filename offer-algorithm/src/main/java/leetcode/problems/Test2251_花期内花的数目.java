package leetcode.problems;

import java.util.*;

public class Test2251_花期内花的数目 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().fullBloomFlowers(
                new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}},
                new int[]{2, 3, 7, 11}
        )));
        System.out.println(Arrays.toString(new Solution().fullBloomFlowers(
                new int[][]{{1, 10}, {3, 3}},
                new int[]{3, 3, 2}
        )));
    }

    static class Solution {
        public int[] fullBloomFlowers(int[][] flowers, int[] people) {
            TreeMap<Integer, Integer> flowersCntMap = new TreeMap<>();
            for (int[] flower : flowers) {
                int start = flower[0];
                int end = flower[1];
                flowersCntMap.put(start, flowersCntMap.getOrDefault(start, 0) + 1);
                flowersCntMap.put(end + 1, flowersCntMap.getOrDefault(end + 1, 0) - 1);
            }
            TreeMap<Integer, Integer> peopleMap = new TreeMap<>();
            for (int p : people) {
                peopleMap.put(p, -1);
            }
            int cnt = 0;
            for (int p : peopleMap.keySet()) {
                while (!flowersCntMap.isEmpty() && flowersCntMap.firstKey() <= p) {
                    cnt += flowersCntMap.get(flowersCntMap.firstKey());
                    flowersCntMap.remove(flowersCntMap.firstKey());
                }
                peopleMap.put(p, cnt);
            }
            for (int i = 0; i < people.length; i++) {
                people[i] = peopleMap.get(people[i]);
            }
            return people;
        }
    }

}
