package leetcode.contest.week355;

import java.util.*;

public class Test6955_长度递增组的最大数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(1, 2, 5)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(2, 1, 2)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(1, 1)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(3, 4)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(2, 2, 2)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(2, 1, 2)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(5, 1, 1)));
    }

    static class Solution {
        public int maxIncreasingGroups(List<Integer> usageLimits) {
            int left = 1, right = usageLimits.size();
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (canFormGroups(new ArrayList<>(usageLimits), mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;

        }

        private boolean canFormGroups(ArrayList<Integer> usageLimits, int group) {
            int n = usageLimits.size();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; ++i) {
                pq.add(usageLimits.get(i));
            }
            // 贪心，每次从频次剩余最大的取
            for (int k = 1; k <= group && !pq.isEmpty(); k++) {
                if (pq.size() < k + 1) {
                    return false;
                }
                List<Integer> lefts = new ArrayList<>();
                for (int i = 0; i < k + 1; ++i) {
                    int left = pq.poll();
                    if (left > 1) {
                        lefts.add(left - 1);
                    }
                }
                pq.addAll(lefts);
            }
            return true;
        }
    }

}
