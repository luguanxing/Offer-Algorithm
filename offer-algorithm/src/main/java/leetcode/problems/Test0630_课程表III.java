package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test0630_课程表III {

    public static void main(String[] args) {
        System.out.println(new Solution().scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(new Solution().scheduleCourse(new int[][]{{1, 2}}));
        System.out.println(new Solution().scheduleCourse(new int[][]{{3, 2}, {4, 3}}));
        System.out.println(new Solution().scheduleCourse(new int[][]{{8, 16}, {6, 17}, {5, 16}, {6, 10}, {1, 13}}));
        System.out.println(new Solution().scheduleCourse(new int[][]{{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}}));
    }

    static class Solution {
        public int scheduleCourse(int[][] courses) {
            // 按结束时间排序
            Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
            // 优先队列，放入所有课程需要占用的时间
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int day = 0;
            for (int[] course : courses) {
                if (day + course[0] <= course[1]) {
                    // 当前能学该课程
                    day += course[0];
                    queue.add(course[0]);
                } else if (!queue.isEmpty() && course[0] < queue.peek()) {
                    // 当前不能学该课程，判断是否比之前课程耗时少，这样同样是学一门课但会剩更多时间（耗时少、到期时间更长肯定满足替换条件）
                    int last = queue.poll();
                    day -= last;
                    day += course[0];
                    queue.add(course[0]);
                }
            }
            return queue.size();
        }
    }

}
