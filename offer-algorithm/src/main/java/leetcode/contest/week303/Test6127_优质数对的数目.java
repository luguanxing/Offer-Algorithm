package leetcode.contest.week303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test6127_优质数对的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countExcellentPairs(new int[]{1, 2, 3, 1}, 3));
        System.out.println(new Solution().countExcellentPairs(new int[]{5, 1, 1}, 10));
        System.out.println(new Solution().countExcellentPairs(new int[]{1, 2, 3, 1, 536870911}, 3));
    }

    static class Solution {
        public long countExcellentPairs(int[] nums, int k) {
            Set<String> set = new HashSet<>();
            long res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int andCnt = Integer.bitCount(nums[i] & nums[j]);
                    int orCnt = Integer.bitCount(nums[i] | nums[j]);
                    if (andCnt + orCnt >= k) {
                        if (set.contains(nums[i] + "-" + nums[j]) || set.contains(nums[j] + "-" + nums[i])) {
                            continue;
                        }
                        set.add(nums[i] + "-" + nums[j]);
                        if (i == j) {
                            res += 1;
                        } else {
                            res += 2;
                        }
                    }
                }
            }
            return res;
        }
    }

}
