package leetcode.contest.dweek30;

public class Test5447_石子游戏IV {

    public static void main(String[] args) {
        System.out.println(new Solution().winnerSquareGame(1));
        System.out.println(new Solution().winnerSquareGame(2));
        System.out.println(new Solution().winnerSquareGame(4));
        System.out.println(new Solution().winnerSquareGame(7));
        System.out.println(new Solution().winnerSquareGame(17));
    }

    static class Solution {
        public boolean winnerSquareGame(int n) {
            // 动态规划，计算n-i*i的情况
            boolean[] state = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int sqrt = (int) Math.sqrt(i);
                if (sqrt * sqrt == i) {
                    // 当前石子数是平方数，稳赢
                    state[i] = true;
                } else {
                    // 当前石子数不是平方数，拿掉i*i个后如果自己之前是输的，那Bob按这个拿法肯定输，Alice就赢了
                    for (int j = 1; j * j < i; j++) {
                        if (state[i - j * j] == false) {
                            state[i] = true;
                            break;
                        }
                    }
                }
            }
            return state[n];
        }
    }

}
