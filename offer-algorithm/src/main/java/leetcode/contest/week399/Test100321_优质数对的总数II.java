package leetcode.contest.week399;

import java.util.*;

public class Test100321_优质数对的总数II {

    public static void main(String[] args) {
        // nums1 = [1,3,4], nums2 = [1,3,4], k = 1
        System.out.println(new Solution().numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        // nums1 = [1,2,4,12], nums2 = [2,4], k = 3
        System.out.println(new Solution().numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    static class Solution {
        public long numberOfPairs(int[] nums1, int[] nums2, int k) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int num : nums2) {
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            }
            long res = 0;
            for (int num : nums1) {
                // 获取num1的除数
                Set<Integer> divisors = getDivisors(num, k);
                // 计算这些除数在num2的个数
                for (int divisor : divisors) {
                    if (cntMap.containsKey(divisor)) {
                        res += cntMap.get(divisor);
                    }
                }
            }
            return res;
        }

        // 计算num的所有可能的除数，使num % (divisor * k) == 0
        private Set<Integer> getDivisors(int num, int k) {
            Set<Integer> divisors = new HashSet<>();
            int limit = (int) Math.sqrt(num);
            // 从平方根内判断在 num=i*rest 的情况下是否 num%(i*k)==0或者rest%(i*k)==0
            for (int i = 1; i <= limit; i++) {
                if (num % i == 0) {
                    int rest = num / i;
                    // 满足(num/i) % k == 0
                    if (rest % k == 0) {
                        divisors.add(i);
                    }
                    // 满足(num/rest) % k == 0，注意rest!=i否则重复
                    if (i != rest && (num % (rest * k) == 0)) {
                        divisors.add(rest);
                    }
                }
            }
            return divisors;
        }
    }

}
