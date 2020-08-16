package leetcode.contest.week202;

import java.util.HashMap;
import java.util.Map;

public class Test5490_吃掉N个橘子的最少天数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(10));
        System.out.println(new Solution().minDays(6));
        System.out.println(new Solution().minDays(1));
        System.out.println(new Solution().minDays(56));
        System.out.println(new Solution().minDays(820592));
    }

    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int minDays(int n) {
            // 递归初始状态和记忆状态
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (map.containsKey(n)) {
                return map.get(n);
            }
            // 把1简化掉(凑到2或3的倍数)，看看吃1/2还是吃2/3哪个更快
            int try2 = minDays(n / 2) + (n % 2) + 1;
            int try3 = minDays(n / 3) + (n % 3) + 1;
            int min = Math.min(try2, try3);
            map.put(n, min);
            return min;
        }
    }

}
