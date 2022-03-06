package leetcode.contest.week283;

import java.util.Set;
import java.util.TreeSet;

public class Test6017_向数组中追加K个整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
        System.out.println(new Solution().minimalKSum(new int[]{5, 6}, 6));
    }

    static class Solution {
        public long minimalKSum(int[] nums, int k) {
            Set<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
            }
            set.add(0);
            set.add(Integer.MAX_VALUE);
            // 找出每两个数之间的间隔，算入结果中
            long res = 0;
            Integer lastNum = null;
            for (int num : set) {
                if (lastNum == null) {
                    lastNum = num;
                    continue;
                }
                int diff = num - lastNum;
                if (diff > 1 && k > 0) {
                    // res += (lastNum+1) + (lastNum+2) + ... + (lastNum+diff-1)且不超过k个
                    long range = Math.min(diff - 1, k);
                    res += (lastNum + 1 + lastNum + range) * range / 2;
                    k -= range;
                }
                lastNum = num;
            }
            return res;
        }
    }

}
