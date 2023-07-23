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
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(8, 1, 6)));
        System.out.println(new Solution().maxIncreasingGroups(Arrays.asList(1, 999, 999, 999, 999, 999)));
    }

    static class Solution {
        public int maxIncreasingGroups(List<Integer> usageLimits) {
            /**
             * 先对usageLimits排序
             * 贪心，每新增一个group, 最优的策略：group[i + 1].size() = group[i].size() + 1;
             * 从小到大遍历usageLimits, 每新增一个group, 必须要新增一个元素,
             * 且新增元素值 和 缓存未用完的值 必须要大于当前分组的值。若满足，说明可以新增一个group，未使用完的值加入缓存。
             *
             * 举例说明：[2, 2, 2]
             * group[0]: 0
             * group[1]: 2 1
             * group[2]: 2 1 0
             *
             * 从i开始遍历（倒序看上面这个过程，填充"列"），而且排序后递增顺序能保证相同的数不在同一行（下面被新数填充）
             * i == 0时，使用一个0放入group[2][2]即可，剩余一个0可以加入缓存，这个缓存的值在后续的i都是可以使用的。
             * i == 1时，使用两个1, 分别放在group[1][1], group[2][1].
             * i == 2时，使用两个2和缓存里的0, 分别放在group[0][0], grouo[1][0], group[2][0]的位置。
             */
            Collections.sort(usageLimits);
            long available = 0;
            int group = 0;
            for (int limit : usageLimits) {
                available += limit;
                if (available > group) {
                    group++;
                    available -= group;
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
