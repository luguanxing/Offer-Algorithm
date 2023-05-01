package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1376_通知所有员工所需的时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().numOfMinutes(
                1, 0, new int[]{-1}, new int[]{0}
        ));
        System.out.println(new Solution().numOfMinutes(
                6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}
        ));
    }

    static class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            List<List<Integer>> subordinates = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                subordinates.add(new ArrayList<>());
            }
            for (int i = 0; i < manager.length; i++) {
                if (manager[i] != -1) {
                    subordinates.get(manager[i]).add(i);
                }
            }
            return getMaxTime(subordinates, headID, informTime);
        }

        private int getMaxTime(List<List<Integer>> subordinates, int currentId, int[] informTime) {
            int time = informTime[currentId];
            int maxTime = time;
            for (int subordinate : subordinates.get(currentId)) {
                maxTime = Math.max(maxTime, time + getMaxTime(subordinates, subordinate, informTime));
            }
            return maxTime;
        }
    }

}
