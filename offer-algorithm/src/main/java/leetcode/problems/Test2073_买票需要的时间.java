package leetcode.problems;

public class Test2073_买票需要的时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(new Solution().timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(new Solution().timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3));
    }

    static class Solution {
        // 分两步：移动到前面 + 利用循环次数计算剩余耗时
        public int timeRequiredToBuy(int[] tickets, int k) {
            // 花k + 1时间将目标移动到队伍前面并买票
            int res = k + 1;
            for (int i = 0; i <= k; i++) {
                tickets[i]--;
            }
            // 计算买剩下ticket[k]-1张票所需循环次数以及对应的耗时
            int round = tickets[k];
            for (int t : tickets) {
                res += Math.min(round, t);
            }
            return res;
        }
    }

}
