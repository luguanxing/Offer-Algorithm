package leetcode.problems;

import java.util.PriorityQueue;

public class Test1792_最大平均通过率 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxAverageRatio(
                new int[][]{
                        {1, 2}, {3, 5}, {2, 2}
                },
                2
        ));
        System.out.println(new Solution().maxAverageRatio(
                new int[][]{
                        {2, 4}, {3, 9}, {4, 5}, {2, 10}
                },
                4
        ));
    }

    static class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<Class> queue = new PriorityQueue<>((o1, o2) -> -Double.compare(o1.extraIncRate(), o2.extraIncRate()));
            for (int[] passTotal : classes) {
                Class clazz = new Class(passTotal[0], passTotal[1]);
                queue.add(clazz);
            }
            for (int i = 1; i <= extraStudents; i++) {
                Class clazz = queue.poll();
                clazz.addExtra();
                queue.add(clazz);
            }
            double res = 0;
            for (Class clazz : queue) {
                res += clazz.rate;
            }
            return res / queue.size();
        }

        private class Class {
            int pass;
            int total;
            double rate;

            public Class(int pass, int total) {
                this.pass = pass;
                this.total = total;
                this.rate = pass * 1.0 / total;
            }

            public void addExtra() {
                pass++;
                total++;
                rate = pass * 1.0 / total;
            }

            public double extraIncRate() {
                double newRate = (pass + 1.0) / (total + 1.0);
                return newRate - rate;
            }
        }
    }

}
