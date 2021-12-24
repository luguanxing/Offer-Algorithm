package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1705_吃苹果的最大数目 {

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
                new int[]{1},
                new int[]{2}
        ));
        System.out.println(new Solution().eatenApples(
                new int[]{2, 1, 10},
                new int[]{2, 10, 1}
        ));
    }

    static class Solution {
        public int eatenApples(int[] apples, int[] days) {
            int res = 0;

            PriorityQueue<Apple> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.day));
            for (int i = 0; i < apples.length || !queue.isEmpty(); i++) {
                if (i < apples.length) {
                    int count = apples[i];
                    int day = days[i];
                    if (count > 0) {
                        queue.add(new Apple(count, day));
                    }
                }
                if (!queue.isEmpty()) {
                    res++;
                    queue.peek().count--;
                    for (Apple apple : queue) {
                        apple.day--;
                    }
                    while (!queue.isEmpty()) {
                        if (queue.peek().day == 0 || queue.peek().count == 0) {
                            queue.poll();
                        } else {
                            break;
                        }
                    }
                }
            }

            return res;
        }

        class Apple {
            int count;
            int day;

            public Apple(int count, int day) {
                this.count = count;
                this.day = day;
            }

            @Override
            public String toString() {
                return "(" + count + "," + day + ")";
            }
        }
    }

}
