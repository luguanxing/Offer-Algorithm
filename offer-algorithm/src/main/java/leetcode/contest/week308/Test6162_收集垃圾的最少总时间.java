package leetcode.contest.week308;

public class Test6162_收集垃圾的最少总时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().garbageCollection(
                new String[]{"G", "P", "GP", "GG"},
                new int[]{2, 4, 3}
        ));
        System.out.println(new Solution().garbageCollection(
                new String[]{"MMM", "PGM", "GP"},
                new int[]{3, 10}
        ));
    }

    static class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            int total = 0;
            total += get(garbage, travel, 'P');
            total += get(garbage, travel, 'G');
            total += get(garbage, travel, 'M');
            return total;
        }

        private int get(String[] garbage, int[] travel, char target) {
            int cnt = 0;
            int cost = 0;

            int firstIdx = -1;
            int lastIdx = -1;
            for (int i = 0; i < garbage.length; i++) {
                String g = garbage[i];
                for (char c : g.toCharArray()) {
                    if (c == target) {
                        cnt++;
                        if (firstIdx == -1) {
                            firstIdx = i;
                        }
                        lastIdx = i;
                    }
                }
            }
            for (int i = 0; i < lastIdx; i++) {
                cost += travel[i];
            }

            return cnt == 0 ? 0 : cost + cnt;
        }
    }

}
