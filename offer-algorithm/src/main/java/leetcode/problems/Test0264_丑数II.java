package leetcode.problems;

import java.util.*;

public class Test0264_丑数II {

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
        System.out.println(new Solution().nthUglyNumber(1));
        System.out.println(new Solution().nthUglyNumber(1407));
    }

    static class Solution {
        public int nthUglyNumber(int n) {
            List<Long> list = new ArrayList<>();
            Set<Long> set = new TreeSet<>();
            set.add(1l);
            // 每次用最小的数生成后面3个数并放到序列中排序
            while (list.size() < n && !set.isEmpty()) {
                long num = set.stream().findFirst().orElse(0l);
                list.add(num);
                set.remove(num);
                set.add(num * 2);
                set.add(num * 3);
                set.add(num * 5);
            }
            return list.get(n-1).intValue();
        }
    }

}
