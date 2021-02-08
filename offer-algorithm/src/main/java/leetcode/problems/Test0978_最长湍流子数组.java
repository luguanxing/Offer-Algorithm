package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test0978_最长湍流子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}
        ));
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{4, 8, 12, 16}
        ));
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{1}
        ));
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{9, 9}
        ));
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{100, 100, 100}
        ));
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0}
        ));
        System.out.println(new Solution().maxTurbulenceSize(
                new int[]{4, 5}
        ));
    }

    static class Solution {
        public int maxTurbulenceSize(int[] arr) {
            Deque<Integer> deque = new ArrayDeque<>();
            int max = 0;
            for (int current : arr) {
                if (deque.isEmpty()) {
                    deque.addLast(current);
                } else {
                    int last = deque.pollLast();
                    if (current == last) {
                        deque.clear();
                        deque.addLast(current);
                    } else {
                        if (deque.isEmpty()) {
                            deque.addLast(last);
                            deque.addLast(current);
                        } else {
                            int lastLast = deque.pollLast();
                            if (1.0 * (last - lastLast) * (current - last) < 0) {
                                deque.addLast(lastLast);
                                deque.addLast(last);
                                deque.addLast(current);
                            } else {
                                deque.clear();
                                deque.addLast(last);
                                deque.addLast(current);
                            }
                        }
                    }
                }
                max = Math.max(max, deque.size());
            }
            return max;
        }
    }

}
