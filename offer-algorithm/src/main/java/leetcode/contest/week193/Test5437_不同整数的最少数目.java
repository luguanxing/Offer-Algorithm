package leetcode.contest.week193;

import java.util.*;
import java.util.stream.Collectors;

public class Test5437_不同整数的最少数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{1}, 0));
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{1, 2, 3}, 99));
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{1, 1}, 1));
        System.out.println(new Solution().findLeastNumOfUniqueInts(new int[]{1, 2, 2, 2, 2}, 4));
    }

    static class Solution {
        public int findLeastNumOfUniqueInts(int[] arr, int k) {
            // 计算每个数出现次数
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.stream(arr).forEach(num -> map.put(num, map.getOrDefault(num, 0) + 1));
            // 贪心，从数量最少的开始移除
            List<NumCount> numCountList = map
                    .entrySet()
                    .stream()
                    .map(entry -> new NumCount(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparingInt(o -> o.count))
                    .collect(Collectors.toList());
            int sum = numCountList.get(0).count;
            for (int i = 1; i < numCountList.size(); i++) {
                if (sum == k) {
                    return numCountList.size() - i;
                } else if (sum > k) {
                    return numCountList.size() - i + 1;
                } else {
                    sum += numCountList.get(i).count;
                }
            }
            if (sum <= k) {
                return 0;
            } else {
                return 1;
            }
        }

        class NumCount {
            int num;
            int count;

            public NumCount(int num, int count) {
                this.num = num;
                this.count = count;
            }
        }
    }

}
