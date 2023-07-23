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
            Collections.sort(usageLimits);
            long available = 0;
            int group = 0;
            for (int limit : usageLimits) {
                available += limit;
                if (available > group) {
                    available -= group;
                    group++;
                }
            }
            return group;
        }
    }

    static class Solution_模拟 {
        public int maxIncreasingGroups(List<Integer> usageLimits) {
            int n = usageLimits.size();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; ++i) {
                pq.add(usageLimits.get(i));
            }
            // 贪心，每次从频次剩余最大的取
            int groups = 0;
            while (!pq.isEmpty()) {
                int k = groups + 1;
                if (pq.size() < k) {
                    break;
                }
                List<Integer> lefts = new ArrayList<>();
                for (int i = 0; i < k; ++i) {
                    int left = pq.poll();
                    if (left > 1) {
                        lefts.add(left - 1);
                    }
                }
                pq.addAll(lefts);
                ++groups;
            }
            return groups;
        }
    }

}
