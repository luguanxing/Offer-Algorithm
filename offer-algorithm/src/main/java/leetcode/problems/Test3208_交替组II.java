package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test3208_交替组II {

    public static void main(String[] args) {
        // colors = [0,1,0,1,0], k = 3
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        // colors = [0,1,0,0,1,0,1], k = 6
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
        // colors = [1,1,0,1], k = 4
        System.out.println(new Solution().numberOfAlternatingGroups(new int[]{1, 1, 0, 1}, 4));
    }

    static class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int len = colors.length;
            int cnt = 0;
            int diff = 0;
            for (int i = 0; i < len + k - 1; i++) {
                int current = colors[i % len];
                if (diff > 0) {
                    // 判断之前的颜色是否和当前颜色不同
                    int last = colors[(i - 1 + len) % len];
                    if (current == last) {
                        // 颜色相同直接清除
                        diff = 0;
                    }
                    diff++;
                    // 维护队列，长度合适则计数
                    if (diff >= k) {
                        cnt++;
                    }
                } else {
                    // 队列为空直接放入
                    diff++;
                }
            }
            return cnt;
        }
    }

    static class Solution_Deque {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int len = colors.length;
            int cnt = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < len + k - 1; i++) {
                int current = colors[i % len];
                if (!queue.isEmpty()) {
                    // 判断之前的颜色是否和当前颜色不同
                    int last = queue.peekLast();
                    if (current == last) {
                        // 颜色相同直接清除
                        queue.clear();
                    }
                    queue.add(current);
                    // 维护队列，长度合适则计数
                    if (queue.size() > k) {
                        queue.pollFirst();
                    }
                    if (queue.size() == k) {
                        cnt++;
                    }
                } else {
                    // 队列为空直接放入
                    queue.add(current);
                }
            }
            return cnt;
        }
    }

}
