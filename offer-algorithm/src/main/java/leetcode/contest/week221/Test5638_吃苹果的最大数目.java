package leetcode.contest.week221;

import java.util.*;

public class Test5638_吃苹果的最大数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().eatenApples(
                new int[]{1, 2, 3, 5, 2},
                new int[]{3, 2, 1, 4, 2}
        ));
        System.out.println(new Solution().eatenApples(
                new int[]{3, 0, 0, 0, 0, 2},
                new int[]{3, 0, 0, 0, 0, 2}
        ));
    }

    static class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int res = 0;
            Set<Stat> stats = new TreeSet<>(Comparator.comparingInt(o -> o.days));
            // 模拟每天情况
            int index = 0;
            do {
                // 每天加入新苹果
                if (index < apples.length && apples[index] > 0) {
                    Stat stat = new Stat(apples[index], days[index]);
                    stats.add(stat);
                }
                index++;
                // 吃掉快到期的那个苹果
                if (!stats.isEmpty()) {
                    Stat willEat = stats.iterator().next();
                    willEat.apple--;
                    res++;
                }
                // 更新吃掉的苹果和过期时间
                stats.removeIf(stat -> stat.apple <= 0 || --stat.days <= 0);
            } while (!stats.isEmpty() || index < days.length);
            return res;
        }

        class Stat {
            int apple;
            int days;

            public Stat(int apple, int days) {
                this.apple = apple;
                this.days = days;
            }
        }
    }

}
