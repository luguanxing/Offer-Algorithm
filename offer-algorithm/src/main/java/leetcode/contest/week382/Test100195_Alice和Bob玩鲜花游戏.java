package leetcode.contest.week382;

public class Test100195_Alice和Bob玩鲜花游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().flowerGame(3, 2));
        System.out.println(new Solution().flowerGame(1, 1));
    }

    static class Solution {
        public long flowerGame(int n, int m) {
            // m中的奇数数量
            long oddY = (m + 1) / 2;
            // m中的偶数数量
            long evenY = m / 2;
            long count = 0;
            for (int x = 1; x <= n; x++) {
                if (x % 2 == 0) {
                    // x为偶数，y必须为奇数
                    count += oddY;
                } else {
                    // x为奇数，y必须为偶数
                    count += evenY;
                }
            }
            return count;
        }
    }


}
