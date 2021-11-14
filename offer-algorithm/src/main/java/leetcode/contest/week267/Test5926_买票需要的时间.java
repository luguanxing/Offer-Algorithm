package leetcode.contest.week267;

public class Test5926_买票需要的时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(new Solution().timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(new Solution().timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3));
    }

    static class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int res = 0;
            while (tickets[k] > 0) {
                for (int i = 0; i < tickets.length; i++) {
                    if (tickets[i] > 0) {
                        tickets[i]--;
                        res++;
                    }
                    if (tickets[k] == 0) {
                        break;
                    }
                }
            }
            return res;
        }
    }

}
