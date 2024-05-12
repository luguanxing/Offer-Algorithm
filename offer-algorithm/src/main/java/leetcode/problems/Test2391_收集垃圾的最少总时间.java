package leetcode.problems;

public class Test2391_收集垃圾的最少总时间 {

    public static void main(String[] args) {
        // garbage = ["G","P","GP","GG"], travel = [2,4,3]
        System.out.println(new Solution().garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        // garbage = ["MMM","PGM","GP"], travel = [3,10]
        System.out.println(new Solution().garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10}));
    }

    static class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
            int len = garbage.length;
            int res = garbage[0].length();
            int costOfM = 0;
            int costOfP = 0;
            int costOfG = 0;
            for (int i = 1; i < len; i++) {
                String g = garbage[i];
                // 各车路程花费
                costOfM += travel[i - 1];
                costOfP += travel[i - 1];
                costOfG += travel[i - 1];
                if (g.contains("M")) {
                    res += costOfM;
                    costOfM = 0;
                }
                if (g.contains("P")) {
                    res += costOfP;
                    costOfP = 0;
                }
                if (g.contains("G")) {
                    res += costOfG;
                    costOfG = 0;
                }
                // 收集垃圾花费
                res += g.length();
            }
            return res;
        }
    }


    static class Solution_2Loop {
        public int garbageCollection(String[] garbage, int[] travel) {
            int len = garbage.length;
            int res = garbage[0].length();
            int lastIndexOfM = 0;
            int lastIndexOfP = 0;
            int lastIndexOfG = 0;
            for (int i = 1; i < len; i++) {
                String g = garbage[i];
                res += g.length();
                if (g.contains("M")) {
                    lastIndexOfM = i;
                }
                if (g.contains("P")) {
                    lastIndexOfP = i;
                }
                if (g.contains("G")) {
                    lastIndexOfG = i;
                }
            }
            for (int i = 1; i < len; i++) {
                if (i <= lastIndexOfM) {
                    res += travel[i - 1];
                }
                if (i <= lastIndexOfP) {
                    res += travel[i - 1];
                }
                if (i <= lastIndexOfG) {
                    res += travel[i - 1];
                }
            }
            return res;
        }
    }

}
