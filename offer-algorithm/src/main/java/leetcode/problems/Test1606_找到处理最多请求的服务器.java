package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test1606_找到处理最多请求的服务器 {

    public static void main(String[] args) {
        System.out.println(new Solution().busiestServers(
                3,
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 2, 3, 3, 3}
        ));
        System.out.println(new Solution().busiestServers(
                3,
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 1, 2}
        ));
        System.out.println(new Solution().busiestServers(
                3,
                new int[]{1, 2, 3},
                new int[]{10, 12, 11}
        ));
        System.out.println(new Solution().busiestServers(
                3,
                new int[]{1, 2, 3, 4, 8, 9, 10},
                new int[]{5, 2, 10, 3, 1, 2, 2}
        ));
        System.out.println(new Solution().busiestServers(
                1,
                new int[]{1},
                new int[]{1}
        ));
    }

    static class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            // 初始化优先队列
            PriorityQueue<Server> priorityQueue = new PriorityQueue<>((s1, s2) -> {
                if (s1.freeTime != s2.freeTime) {
                    return Integer.compare(s1.freeTime, s2.freeTime);
                } else {
                    return Integer.compare(s1.index, s2.index);
                }
            });
            for (int i = 0; i < k; i++) {
                priorityQueue.add(new Server(i, 0));
            }
            // 不断放入任务
            for (int i = 0; i < arrival.length; i++) {
                int startAt = arrival[i];
                int costTime = load[i];
                List<Server> popServers = new ArrayList<>();
                while (!priorityQueue.isEmpty()) {
                    Server server = priorityQueue.poll();
                    popServers.add(server);
                    if (server.freeTime > startAt) {
                        continue;
                    }
                    server.addJob(startAt + costTime);
                    break;
                }
                priorityQueue.addAll(popServers);
            }
            // 找出处理任务最多的server
            int maxCnt = 0;
            for (Server server : priorityQueue) {
                if (server.taskCnt > maxCnt) {
                    maxCnt = server.taskCnt;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (Server server : priorityQueue) {
                if (server.taskCnt == maxCnt) {
                    res.add(server.index);
                }
            }
            return res;
        }
    }

    static class Server {
        int index;
        int freeTime;
        int taskCnt;

        public Server(int index, int freeTime) {
            this.index = index;
            this.freeTime = freeTime;
        }

        public void addJob(int finishAt) {
            this.freeTime = finishAt;
            this.taskCnt++;
        }
    }

}
