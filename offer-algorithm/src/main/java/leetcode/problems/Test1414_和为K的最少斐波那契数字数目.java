package leetcode.problems;

import java.util.*;

public class Test1414_和为K的最少斐波那契数字数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinFibonacciNumbers(7));
        System.out.println(new Solution().findMinFibonacciNumbers(10));
        System.out.println(new Solution().findMinFibonacciNumbers(19));
        System.out.println(new Solution().findMinFibonacciNumbers(513314));
        System.out.println(new Solution().findMinFibonacciNumbers(5));
    }

    static class Solution {
        TreeSet<Integer> fibs = getFibs();

        public int findMinFibonacciNumbers(int k) {
            if (fibs.contains(k)) {
                return 1;
            }
            // 贪心策略，每次用最接近k的数去凑
            int lower = fibs.lower(k);
            return findMinFibonacciNumbers(k - lower) + 1;
        }

        private TreeSet<Integer> getFibs() {
            List<Integer> fibs = new ArrayList<>();
            fibs.add(1);
            fibs.add(1);
            int a = 1;
            int b = 1;
            while (b < Math.pow(10, 9)) {
                int c = a + b;
                fibs.add(c);
                a = b;
                b = c;
            }
            return new TreeSet<>(fibs);
        }
    }

    static class Solution_BFS {
        public int findMinFibonacciNumbers(int k) {
            Set<Integer> fibs = getFibs();
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            int steps = 1;
            queue.add(k);
            // bfs + 层次遍历
            while (!queue.isEmpty()) {
                List<Integer> currents = new ArrayList<>(queue);
                queue.clear();
                for (int current : currents) {
                    if (fibs.contains(current)) {
                        return steps;
                    }
                    visited.add(current);
                    for (int fib : fibs) {
                        int next = current - fib;
                        if (next < 0) {
                            break;
                        }
                        if (visited.contains(next)) {
                            continue;
                        }
                        queue.add(next);
                    }
                }
                steps++;
            }

            return 0;
        }

        private Set<Integer> getFibs() {
            List<Integer> fibs = new ArrayList<>();
            fibs.add(1);
            fibs.add(1);
            int a = 1;
            int b = 1;
            while (b < Math.pow(10, 9)) {
                int c = a + b;
                fibs.add(c);
                a = b;
                b = c;
            }
            return new TreeSet<>(fibs);
        }
    }


}
