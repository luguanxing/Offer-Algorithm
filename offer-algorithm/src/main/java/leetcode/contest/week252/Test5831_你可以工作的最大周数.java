package leetcode.contest.week252;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test5831_你可以工作的最大周数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfWeeks(
                new int[]{1, 2, 3}
        ));
        System.out.println(new Solution().numberOfWeeks(
                new int[]{5, 2, 1}
        ));
        System.out.println(new Solution().numberOfWeeks(
                new int[]{1000000000}
        ));
        System.out.println(new Solution().numberOfWeeks(
                new int[]{1, 3}
        ));
        System.out.println(new Solution().numberOfWeeks(
                new int[]{2, 2}
        ));
        System.out.println(new Solution().numberOfWeeks(
                new int[]{5, 5, 7, 7, 7, 9}
        ));
        System.out.println(new Solution().numberOfWeeks(
                new int[]{8, 8, 2, 6}
        )); // 24
    }

    static class Solution {
        public long numberOfWeeks(int[] milestones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : milestones) {
                queue.add(num);
            }
            int res = 1;
            int tmp = queue.poll();
            tmp--;
            while (!queue.isEmpty()) {
                int first = queue.poll();
                first--;
                res++;
                if (tmp != 0) {
                    queue.add(tmp);
                }
                tmp = first;
            }
            return res;
        }
    }

}
