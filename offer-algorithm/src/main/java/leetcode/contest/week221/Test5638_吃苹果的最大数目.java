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
        System.out.println(new Solution().eatenApples(
                new int[]{2, 2, 2, 2, 2},
                new int[]{10, 8, 6, 4, 2}
        ));
    }

    static class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int res = 0;
            Set<int[]> stats = new TreeSet<>(Comparator.comparingInt(stat -> stat[1]));
            // 模拟每天情况
            int index = 0;
            do {
                // 每天加入新苹果
                if (index < apples.length && apples[index] > 0) {
                    stats.add(new int[]{apples[index], index + days[index]});
                }
                index++;
                // 吃掉快到期的那个苹果
                if (!stats.isEmpty()) {
                    int[] stat = stats.iterator().next();
                    stat[0]--;
                    res++;
                }
                // 更新吃掉的苹果和过期时间
                Iterator<int[]> iterator = stats.iterator();
                while (iterator.hasNext()) {
                    int[] stat = iterator.next();
                    if (stat[0] <= 0 || stat[1] <= index) {
                        iterator.remove();
                    } else {
                        break;
                    }
                }
            } while (!stats.isEmpty() || index < days.length);
            return res;
        }
    }

}
