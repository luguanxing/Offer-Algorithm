package leetcode.contest.week298;

import java.util.*;

public class Test5218_个位数字为K的整数之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumNumbers(58, 9));
        System.out.println(new Solution().minimumNumbers(37, 2));
        System.out.println(new Solution().minimumNumbers(0, 7));
        System.out.println(new Solution().minimumNumbers(3000, 1));
        System.out.println(new Solution().minimumNumbers(5, 1));
    }

    static class Solution {
        Set<Integer> parts = new HashSet<>();
        Map<Integer, Integer> numMap = new HashMap<>();

        public int minimumNumbers(int num, int k) {
            if (num == 0) {
                return 0;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= num; i++) {
                if (i % 10 == k) {
                    numMap.put(i, 1);
                    parts.add(i);
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int currentNum = queue.poll();
                for (int part : parts) {
                    int nextNum = part + currentNum;
                    int nextNumLevl = numMap.get(currentNum) + 1;
                    if (nextNum <= num && !numMap.containsKey(nextNum)) {
                        queue.add(nextNum);
                        numMap.put(nextNum, nextNumLevl);
                    }
                }
            }
            return numMap.getOrDefault(num, -1);
        }
    }

}
