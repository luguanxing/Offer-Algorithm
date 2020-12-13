package leetcode.contest.week219;

public class Test5627_石子游戏VII {

    public static void main(String[] args) {
        System.out.println(new Solution().stoneGameVII(
                new int[]{1, 2, 3, 4}
        ));
        System.out.println(new Solution().stoneGameVII(
                new int[]{5, 3, 1, 4, 2}
        ));
        System.out.println(new Solution().stoneGameVII(
                new int[]{7, 90, 5, 1, 100, 10, 10, 2}
        ));
    }

    static class Solution {
        public int stoneGameVII(int[] stones) {
            int[][] dp = new int[stones.length][stones.length];
            for (int y = stones.length - 1; y >=0; y--) {
                for (int x = y + 1; x < stones.length; x++) {
                    if (x - y == 1) {
                        // 只有两个元素，Alice拿掉最小的，Bob没有得拿，差值为Alice刚拿完剩下的值
                        dp[y][x] = Math.max(stones[x], stones[y]);
                    } else if (x - y == 2) {
                        // 有三个元素，Alice先拿最小，Bob拿掉剩下更小的，差值为Bob刚拿的那个更小的
                        if (stones[y] < stones[x]) {
                            dp[y][x] = Math.min(stones[y + 1], stones[x]);
                        } else {
                            dp[y][x] = Math.min(stones[y], stones[y + 1]);
                        }
                    } else {
                        //  多个元素，Alice可以拿第一个或者最后一个取最大值，Bob从剩下再拿第一个或最后一个取最小值
                        int selectY = Math.min(stones[y + 1] + dp[y + 2][x], dp[y + 1][x - 1] + stones[x]);
                        int selectX = Math.min(stones[y] + dp[y + 1][x - 1], dp[y][x - 2] + stones[x - 1]);
                        dp[y][x] = Math.max(selectY, selectX);
                    }
                }
            }
            return dp[0][stones.length - 1];
        }
    }

}
