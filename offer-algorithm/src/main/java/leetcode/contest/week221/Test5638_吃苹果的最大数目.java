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
        System.out.println(new Solution().eatenApples(
                new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5},
                new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7}
        ));
    }

    static class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int MAX = 20005;
            int[] canEat = new int[MAX];
            for (int i = 0; i < apples.length; i++) {
                int apple = apples[i];
                int day = days[i];
                for (int j = 0; j < day && apple > 0; j++) {
                    if (canEat[i + j] == 0) {
                        canEat[i + j] = 1;
                        apple--;
                    }
                }
            }
            return Arrays.stream(canEat).sum();
        }
    }

    static class Solution_模拟 {
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
