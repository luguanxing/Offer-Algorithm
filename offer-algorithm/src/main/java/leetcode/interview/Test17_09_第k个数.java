package leetcode.interview;

import java.util.*;

public class Test17_09_第k个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().getKthMagicNumber(5));
        System.out.println(new Solution().getKthMagicNumber(251));
        System.out.println(new Solution().getKthMagicNumber(158));
        System.out.println(new Solution().getKthMagicNumber(643));
    }

    static class Solution {
        public int getKthMagicNumber(int k) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            Set<Long> visited = new TreeSet<>();
            queue.add(1l);
            visited.add(1l);
            int idx = 1;
            while (idx <= k) {
                long current = queue.poll();
                long[] nexts = new long[]{current * 3, current * 5, current * 7};
                for (long next : nexts) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                        idx++;
                    }
                }
            }
            // 之前用k个数判断不一定全，还需要把队列剩下的也进行处理
            while (!queue.isEmpty()) {
                long current = queue.poll();
                long[] nexts = new long[]{current * 3, current * 5, current * 7};
                for (long next : nexts) {
                    visited.add(next);
                }
            }
            return (new ArrayList<>(visited).get(k - 1)).intValue();
        }
    }

}
