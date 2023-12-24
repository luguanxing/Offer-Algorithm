package leetcode.contest.week377;

public class Test100156_转换字符串的最小成本I {

    public static void main(String[] args) {
        // source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
        System.out.println(new Solution().minimumCost("abcd", "acbe", new char[]{'a', 'b', 'c', 'c', 'e', 'd'}, new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20}));
        // source = "aaaa", target = "bbbb", original = ["a","c"], changed = ["c","b"], cost = [1,2]
        System.out.println(new Solution().minimumCost("aaaa", "bbbb", new char[]{'a', 'c'}, new char[]{'c', 'b'}, new int[]{1, 2}));
        // source = "abcd", target = "abce", original = ["a"], changed = ["e"], cost = [10000]
        System.out.println(new Solution().minimumCost("abcd", "abce", new char[]{'a'}, new char[]{'e'}, new int[]{10000}));
    }

    static class Solution {
        private static final int INF = Integer.MAX_VALUE;
        private static final int ALPHABET_SIZE = 26;

        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            // 计算成本矩阵
            int[][] minCost = new int[ALPHABET_SIZE][ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                for (int j = 0; j < ALPHABET_SIZE; j++) {
                    minCost[i][j] = i == j ? 0 : INF;
                }
            }
            for (int i = 0; i < original.length; i++) {
                int from = original[i] - 'a';
                int to = changed[i] - 'a';
                minCost[from][to] = Math.min(minCost[from][to], cost[i]);
            }
            for (int k = 0; k < ALPHABET_SIZE; k++) {
                for (int i = 0; i < ALPHABET_SIZE; i++) {
                    for (int j = 0; j < ALPHABET_SIZE; j++) {
                        if (minCost[i][k] != INF && minCost[k][j] != INF) {
                            minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                        }
                    }
                }
            }
            // 计算总成本
            long totalCost = 0;
            for (int i = 0; i < source.length(); i++) {
                if (source.charAt(i) != target.charAt(i)) {
                    int costToChange = minCost[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                    if (costToChange == INF) {
                        return -1;
                    }
                    totalCost += costToChange;
                }
            }
            return totalCost;
        }
    }


}
