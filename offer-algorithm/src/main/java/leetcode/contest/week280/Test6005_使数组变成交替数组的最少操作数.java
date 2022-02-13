package leetcode.contest.week280;

import java.util.*;

public class Test6005_使数组变成交替数组的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{3, 1, 3, 2, 4, 3}));
        System.out.println(new Solution().minimumOperations(new int[]{1, 2, 2, 2, 2}));
        System.out.println(new Solution().minimumOperations(new int[]{2, 2}));
        System.out.println(new Solution().minimumOperations(new int[]{2}));
        System.out.println(new Solution().minimumOperations(new int[]{1, 1, 2}));
        System.out.println(new Solution().minimumOperations(new int[]{1, 2}));
        System.out.println(new Solution().minimumOperations(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new Solution().minimumOperations(new int[]{14, 57, 66, 52, 43, 23, 52, 29, 91, 9, 6, 62, 1, 23, 6, 33, 17, 25, 98, 6, 1, 64, 73, 37, 44, 81, 78, 75, 79, 70, 25, 19, 24, 18, 3, 14, 31, 21, 14, 66, 79, 63, 100, 12, 30, 32, 21, 54, 9, 85, 92, 49, 50, 26, 25, 19, 41, 94, 1, 74, 99, 98, 92, 24, 82, 47, 25, 36, 80, 50, 21, 95, 90, 78, 54, 67, 54, 52, 14, 4, 36, 38, 71, 90, 13, 17, 95, 97, 62, 96}));
        System.out.println(new Solution().minimumOperations(new int[]{2, 1, 2, 1, 2, 1, 2, 2, 2}));
        System.out.println(new Solution().minimumOperations(new int[]{69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28, 79, 24}));
        System.out.println(new Solution().minimumOperations(new int[]{2, 2, 2, 2}));
    }

    static class Solution {
        public int minimumOperations(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums.length == 2 && nums[0] == nums[1]) {
                return 1;
            }
            if (nums.length == 2 && nums[0] != nums[1]) {
                return 0;
            }
            // 分流
            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 1) {
                    odds.add(nums[i]);
                } else {
                    evens.add(nums[i]);
                }
                set.add(nums[i]);
            }
            if (set.size() == 1) {
                return nums.length / 2;
            }
            // 取最多且不相等的进行修改
            Map<Integer, Integer> oddsCnt = new HashMap<>();
            Map<Integer, Integer> evensCnt = new HashMap<>();
            for (int odd : odds) {
                oddsCnt.put(odd, oddsCnt.getOrDefault(odd, 0) + 1);
            }
            for (int even : evens) {
                evensCnt.put(even, evensCnt.getOrDefault(even, 0) + 1);
            }
            // 暴力
            List<int[]> oddAndCnt = new ArrayList<>();
            List<int[]> evenAndCnt = new ArrayList<>();
            for (int odd : oddsCnt.keySet()) {
                int cnt = oddsCnt.get(odd);
                oddAndCnt.add(new int[]{odd, cnt});
            }
            for (int even : evensCnt.keySet()) {
                int cnt = evensCnt.get(even);
                evenAndCnt.add(new int[]{even, cnt});
            }
            Collections.sort(oddAndCnt, (o1, o2) -> Integer.compare(o2[1], o1[1]));
            Collections.sort(evenAndCnt, (o1, o2) -> Integer.compare(o2[1], o1[1]));
            int res = Integer.MAX_VALUE;
            for (int[] oddCnt : oddAndCnt) {
                for (int[] evenCnt : evenAndCnt) {
                    if (oddCnt[0] != evenCnt[0]) {
                        res = Math.min(res, odds.size() - oddCnt[1] + evens.size() - evenCnt[1]);
                        break;
                    }
                }
            }
            if (res == Integer.MAX_VALUE) {
                res = Math.min(odds.size() / 2, evens.size() / 2);
            }
            return res;
        }
    }

}
