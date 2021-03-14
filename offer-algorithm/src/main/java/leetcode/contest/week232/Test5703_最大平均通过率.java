package leetcode.contest.week232;

import java.util.*;

public class Test5703_最大平均通过率 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxAverageRatio(new int[][]{
                {1, 2}, {3, 5}, {2, 2}}, 2
        ));
        System.out.println(new Solution().maxAverageRatio(new int[][]{
                {2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4
        ));
    }

    static class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            PriorityQueue<ClassInfo> queue = new PriorityQueue<>(Comparator.comparingDouble(ClassInfo::getPriority));
            for (int[] classInfo : classes) {
                queue.add(new ClassInfo(classInfo[0], classInfo[1]));
            }
            while (extraStudents-- > 0) {
                ClassInfo classInfo = queue.poll();
                queue.remove(0);
                classInfo.add();
                queue.add(classInfo);
            }
            double rate = 0;
            for (ClassInfo classInfo : queue) {
                rate += classInfo.pass * 1.0 / classInfo.total;
            }
            return rate / queue.size();
        }

        static class ClassInfo {
            int pass;
            int total;
            double priority;

            public ClassInfo(int pass, int total) {
                this.pass = pass;
                this.total = total;
                this.priority = ((pass + 1) * 1.0 / (total + 1)) - (pass * 1.0 / total);
            }

            public double getPriority() {
                return -priority;
            }

            public void add() {
                pass++;
                total++;
                priority = ((pass + 1) * 1.0 / (total + 1)) - (pass * 1.0 / total);
            }
        }
    }

}
