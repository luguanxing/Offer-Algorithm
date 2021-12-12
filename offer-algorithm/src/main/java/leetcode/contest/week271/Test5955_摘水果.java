package leetcode.contest.week271;

public class Test5955_摘水果 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalFruits(
                new int[][]{{2, 8}, {6, 3}, {8, 6}}, 5, 4
        ));
        System.out.println(new Solution().maxTotalFruits(
                new int[][]{{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}}, 5, 4
        ));
        System.out.println(new Solution().maxTotalFruits(
                new int[][]{{0, 3}, {6, 4}, {8, 5}}, 3, 2
        ));
        System.out.println(new Solution().maxTotalFruits(
                new int[][]{{200000, 10000}}, 200000, 200000
        ));
        System.out.println(new Solution().maxTotalFruits(
                new int[][]{{200000, 10000}}, 0, 200000
        ));
        System.out.println(new Solution().maxTotalFruits(
                new int[][]{{0, 7}, {7, 4}, {9, 10}, {12, 6}, {14, 8}, {16, 5}, {17, 8}, {19, 4}, {20, 1}, {21, 3}, {24, 3}, {25, 3}, {26, 1}, {28, 10}, {30, 9}, {31, 6}, {32, 1}, {37, 5}, {40, 9}}, 21, 30
        ));
    }

    static class Solution {
        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
            int MAX = 5 * 100000;
            // 计算水果总数前缀和
            int[] sum = new int[MAX];
            int fruitIndex = 0;
            int currentSum = 0;
            for (int i = 0; i < MAX; i++) {
                if (fruitIndex < fruits.length && i == fruits[fruitIndex][0]) {
                    currentSum += fruits[fruitIndex][1];
                    fruitIndex++;
                }
                sum[i] = currentSum;
            }
            // 计算k步的能走的范围内水果数
            int res = 0;
            // 先往左走i步，再往右走完
            for (int i = 0; i <= k; i++) {
                int left = Math.max(0, startPos - i);
                int right = Math.min(MAX, left + (k - i));
                int current = sum[right] - (left == 0 ? 0 : sum[left - 1]);
                res = Math.max(res, current);
            }
            // 先往右走i步，再往右走完
            for (int i = 0; i <= k; i++) {
                int right = startPos + i;
                int left = Math.max(0, right - (k - i));
                int current = sum[right] - (left == 0 ? 0 : sum[left - 1]);
                res = Math.max(res, current);
            }
            return res;
        }
    }

}
