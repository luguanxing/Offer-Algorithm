package leetcode.contest.week235;

import java.util.*;

public class Test5723_查找用户活跃分钟数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findingUsersActiveMinutes(new int[][]{
                {0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}
        }, 5)));
        System.out.println(Arrays.toString(new Solution().findingUsersActiveMinutes(new int[][]{
                {1, 1}, {2, 2}, {2, 3}
        }, 4)));
    }

    static class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            int[] res = new int[k];
            Map<Integer, Set<Integer>> uidMap = new HashMap<>();
            for (int[] log : logs) {
                int uid = log[0];
                int time = log[1];
                Set<Integer> set = uidMap.getOrDefault(uid, new HashSet<>());
                set.add(time);
                uidMap.put(uid, set);
            }
            for (Set<Integer> set : uidMap.values()) {
                res[set.size() - 1]++;
            }
            return res;
        }
    }

}
