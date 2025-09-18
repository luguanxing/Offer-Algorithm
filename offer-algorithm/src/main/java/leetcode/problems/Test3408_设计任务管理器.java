package leetcode.problems;

import java.util.*;

public class Test3408_设计任务管理器 {

    public static void main(String[] args) {
        List<List<Integer>> tasks = new ArrayList<>();
        tasks.add(Arrays.asList(10, 26, 5));
        TaskManager taskManager = new TaskManager(tasks);
        taskManager.rmv(26);
        System.out.println(taskManager.execTop());
    }

    static class TaskManager {
        Map<Integer, Task> idMap = new HashMap<>();
        TreeMap<Integer, TreeMap<Integer, Task>> priorityMap = new TreeMap<>(Comparator.reverseOrder());

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                add(userId, taskId, priority);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            idMap.put(taskId, task);
            TreeMap<Integer, Task> priorityIdMap = priorityMap.getOrDefault(priority, new TreeMap<>(Comparator.reverseOrder()));
            priorityIdMap.put(taskId, task);
            priorityMap.put(priority, priorityIdMap);
        }

        public void edit(int taskId, int newPriority) {
            Task task = idMap.get(taskId);
            if (task != null) {
                int oldPriority = task.priority;
                task.priority = newPriority;
                TreeMap<Integer, Task> oldPriorityIdMap = priorityMap.get(oldPriority);
                oldPriorityIdMap.remove(taskId);
                if (oldPriorityIdMap.isEmpty()) {
                    priorityMap.remove(oldPriority);
                }
                TreeMap<Integer, Task> newPriorityIdMap = priorityMap.getOrDefault(newPriority, new TreeMap<>(Comparator.reverseOrder()));
                newPriorityIdMap.put(taskId, task);
                priorityMap.put(newPriority, newPriorityIdMap);
            }
        }

        public void rmv(int taskId) {
            Task task = idMap.get(taskId);
            if (task != null) {
                int priority = task.priority;
                idMap.remove(taskId);
                TreeMap<Integer, Task> priorityIdMap = priorityMap.get(priority);
                priorityIdMap.remove(taskId);
                if (priorityIdMap.isEmpty()) {
                    priorityMap.remove(priority);
                }
            }
        }

        public int execTop() {
            if (priorityMap.isEmpty()) {
                return -1;
            }
            TreeMap<Integer, Task> priorityIdMap = priorityMap.firstEntry().getValue();
            Task task = priorityIdMap.pollFirstEntry().getValue();
            priorityIdMap.remove(task.taskId);
            if (priorityIdMap.isEmpty()) {
                priorityMap.remove(task.priority);
            }
            idMap.remove(task.taskId);
            return task.userId;
        }

        class  Task {
            int userId;
            int taskId;
            int priority;

            public Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }
        }
    }

    /**
     * Your TaskManager object will be instantiated and called as such:
     * TaskManager obj = new TaskManager(tasks);
     * obj.add(userId,taskId,priority);
     * obj.edit(taskId,newPriority);
     * obj.rmv(taskId);
     * int param_4 = obj.execTop();
     */

    static class TaskManager_优先队列 {
        Map<Integer, Task> idMap = new HashMap<>();
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.priority != o2.priority) {
                return o2.priority - o1.priority;
            } else {
                return o2.taskId - o1.taskId;
            }
        });

        public TaskManager_优先队列(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                add(userId, taskId, priority);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            idMap.put(taskId, task);
            priorityQueue.offer(task);
        }

        public void edit(int taskId, int newPriority) {
            Task task = idMap.get(taskId);
            if (task != null) {
                priorityQueue.remove(task);
                task.priority = newPriority;
                priorityQueue.offer(task);
            }
        }

        public void rmv(int taskId) {
            Task task = idMap.get(taskId);
            if (task != null) {
                priorityQueue.remove(task);
                idMap.remove(taskId);
            }
        }

        public int execTop() {
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            Task task = priorityQueue.poll();
            idMap.remove(task.taskId);
            return task.userId;
        }

        class  Task {
            int userId;
            int taskId;
            int priority;

            public Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }
        }
    }


}
