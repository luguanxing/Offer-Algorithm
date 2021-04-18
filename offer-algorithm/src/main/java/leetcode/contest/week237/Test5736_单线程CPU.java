package leetcode.contest.week237;

import java.util.*;

public class Test5736_单线程CPU {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getOrder(new int[][]{
                {1, 2}, {2, 4}, {3, 2}, {4, 1}
        })));
        System.out.println(Arrays.toString(new Solution().getOrder(new int[][]{
                {7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}
        })));
        System.out.println(Arrays.toString(new Solution().getOrder(new int[][]{
                {19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}
        })));
        System.out.println(Arrays.toString(new Solution().getOrder(new int[][]{
                {35, 36}, {11, 7}, {15, 47}, {34, 2}, {47, 19}, {16, 14}, {19, 8}, {7, 34}, {38, 15}, {16, 18}, {27, 22}, {7, 15}, {43, 2}, {10, 5}, {5, 4}, {3, 11}
        })));
        System.out.println(Arrays.toString(new Solution().getOrder(new int[][]{
                {19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}
        })));
    }

    static class Solution {
        public int[] getOrder(int[][] tasks) {
            List<Task> taskList = new ArrayList<>();
            for (int i = 0; i < tasks.length; i++) {
                taskList.add(new Task(tasks[i][0], tasks[i][1], i));
            }
            taskList.sort(Comparator.comparingInt(task -> task.startTime));

            Queue<Task> queue = new PriorityQueue<>((task1, task2) -> {
                if (task1.costTime == task2.costTime) {
                    return Integer.compare(task1.index, task2.index);
                } else {
                    return Integer.compare(task1.costTime, task2.costTime);
                }
            });

            // 遍历taskList，同时维护一个时间
            int[] res = new int[taskList.size()];
            int time = 0;
            int index = 0;
            for (int i = 0; i < taskList.size(); i++) {
                if (queue.isEmpty()) {
                    time = Math.max(time, taskList.get(index).startTime);
                }
                while (index < taskList.size() && taskList.get(index).startTime <= time) {
                    queue.offer(taskList.get(index));
                    index++;
                }
                Task task = queue.poll();
                res[i] = task.index;
                time += task.costTime;
            }
            return res;
        }

        class Task {
            int startTime;
            int costTime;
            int index;

            public Task(int startTime, int costTime, int index) {
                this.startTime = startTime;
                this.costTime = costTime;
                this.index = index;
            }

            @Override
            public String toString() {
                return "{"+ costTime + "," + index + '}';
            }
        }
    }

}
