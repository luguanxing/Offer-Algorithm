package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test1015_可被K整除的最小整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestRepunitDivByK(1));
        System.out.println(new Solution().smallestRepunitDivByK(2));
        System.out.println(new Solution().smallestRepunitDivByK(3));
    }

    static class Solution {
        public int smallestRepunitDivByK(int k) {
            // mod(new, k) = mod(old*10+1, k) = mod(mod(old, k)*10+1, k)
            // 使用set判断余数是否出现循环
            int cnt = 1;
            int reminder = 1 % k;
            Set<Integer> set = new HashSet<>();
            while (reminder != 0) {
                if (set.contains(reminder)) {
                    return -1;
                }
                set.add(reminder);
                reminder = reminder * 10 + 1;
                reminder %= k;
                cnt++;
            }
            return cnt;
        }
    }

}
