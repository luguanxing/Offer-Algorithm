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
        // 存储尾数为k的所有数
        List<Integer> parts = new ArrayList<>();
        // 存储能拼出的数和拼出它们对应的最少次数
        Map<Integer, Integer> numCntMap = new HashMap<>();

        public int minimumNumbers(int num, int k) {
            if (num == 0) {
                return 0;
            }
            // 初始化
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= num; i++) {
                if (i % 10 == k) {
                    queue.add(i);
                    parts.add(i);
                    numCntMap.put(i, 1);
                }
            }
            // 使用BFS生成范围内所有可能的结果
            while (!queue.isEmpty()) {
                int currentNum = queue.poll();
                for (int part : parts) {
                    int nextNum = part + currentNum;
                    int nextNumCnt = numCntMap.get(currentNum) + 1;
                    if (nextNum <= num && !numCntMap.containsKey(nextNum)) {
                        queue.add(nextNum);
                        numCntMap.put(nextNum, nextNumCnt);
                    }
                }
            }
            return numCntMap.getOrDefault(num, -1);
        }
    }

}
