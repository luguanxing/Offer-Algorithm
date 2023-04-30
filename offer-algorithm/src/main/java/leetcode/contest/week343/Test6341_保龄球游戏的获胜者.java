package leetcode.contest.week343;

public class Test6341_保龄球游戏的获胜者 {

    public static void main(String[] args) {
        System.out.println(new Solution().isWinner(
                new int[]{4, 10, 7, 9},
                new int[]{6, 5, 2, 3}
        ));
        System.out.println(new Solution().isWinner(
                new int[]{3, 5, 7, 6},
                new int[]{8, 10, 10, 2}
        ));
        System.out.println(new Solution().isWinner(
                new int[]{2, 3},
                new int[]{4, 1}
        ));
        System.out.println(new Solution().isWinner(
                new int[]{10, 2, 2, 3},
                new int[]{3, 8, 4, 5}
        ));
    }

    static class Solution {
        public int isWinner(int[] player1, int[] player2) {
            int sum1 = getSum(player1);
            int sum2 = getSum(player2);
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return 2;
            } else {
                return 0;
            }
        }

        private int getSum(int[] player) {
            int sum = 0;
            for (int i = 0; i < player.length; i++) {
                int p = player[i];
                int p1 = i - 1 >= 0 ? player[i - 1] : 0;
                int p2 = i - 2 >= 0 ? player[i - 2] : 0;
                if (p1 == 10 || p2 == 10) {
                    sum += p * 2;
                } else {
                    sum += p;
                }
            }
            return sum;
        }
    }

}
