package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test3175_找到连续赢K场比赛的第一位玩家 {

    public static void main(String[] args) {
        // skills = [4,2,6,3,9], k = 2
        System.out.println(new Solution().findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
        // skills = [2,5,4], k = 3
        System.out.println(new Solution().findWinningPlayer(new int[]{2, 5, 4}, 3));
    }

    static class Solution {
        public int findWinningPlayer(int[] skills, int k) {
            int len = skills.length;
            // k大于人数直接取最大
            if (k >= len) {
                k = len;
            }
            // 否则进行模拟，最多遍历一次
            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                queue.offer(new int[]{skills[i], i});
            }
            int cnt = 0;
            while (cnt < k) {
                int[] head = queue.poll();
                int[] next = queue.poll();
                if (head[0] > next[0]) {
                    queue.addFirst(head);
                    queue.addLast(next);
                    cnt++;
                } else {
                    queue.addFirst(next);
                    queue.addLast(head);
                    cnt = 1;
                }
            }
            return queue.peekFirst()[1];
        }
    }

}
