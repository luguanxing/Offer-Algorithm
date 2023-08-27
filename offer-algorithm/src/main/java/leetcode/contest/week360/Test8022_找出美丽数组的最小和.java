package leetcode.contest.week360;

import java.util.HashSet;
import java.util.Set;

public class Test8022_找出美丽数组的最小和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPossibleSum(2, 3));
        System.out.println(new Solution().minimumPossibleSum(3, 3));
        System.out.println(new Solution().minimumPossibleSum(1, 1));
    }

    static class Solution {
        public long minimumPossibleSum(int n, int target) {
            Set<Long> set = new HashSet<>();
            long idx = 1;
            while (set.size() < n) {
                if (!set.contains(target - idx)) {
                    set.add(idx);
                }
                idx++;
            }
            return set.stream().reduce(Long::sum).get();
        }
    }

}
