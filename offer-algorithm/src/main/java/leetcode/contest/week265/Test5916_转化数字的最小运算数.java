package leetcode.contest.week265;

import java.util.*;

public class Test5916_转化数字的最小运算数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{1, 3}, 6, 4));
        System.out.println(new Solution().minimumOperations(new int[]{2, 4, 12}, 2, 12));
        System.out.println(new Solution().minimumOperations(new int[]{3, 5, 7}, 0, -4));
        System.out.println(new Solution().minimumOperations(new int[]{2, 8, 16}, 0, 1));
        System.out.println(new Solution().minimumOperations(new int[]{1}, 0, 3));
    }

    static class Solution {
        public int minimumOperations(int[] nums, int start, int goal) {
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            List<Integer> currentNums = new ArrayList<>();
            queue.add(start);
            int res = 0;
            while (!queue.isEmpty()) {
                // 查看当前该趟所有结果
                while (!queue.isEmpty()) {
                    int currentNum = queue.poll();
                    currentNums.add(currentNum);
                    visited.add(currentNum);
                }
                // 准备BFS下一趟
                for (int currentNum : currentNums) {
                    if (currentNum == goal) {
                        return res;
                    }
                    if (currentNum < 0 || currentNum > 1000) {
                        continue;
                    }
                    for (int num : nums) {
                        if (!visited.contains(currentNum + num)) {
                            queue.add(currentNum + num);
                            visited.add(currentNum + num);
                        }
                        if (!visited.contains(currentNum - num)) {
                            queue.add(currentNum - num);
                            visited.add(currentNum - num);
                        }
                        if (!visited.contains(currentNum ^ num)) {
                            queue.add(currentNum ^ num);
                            visited.add(currentNum ^ num);
                        }
                    }
                }
                res++;
                currentNums.clear();
            }
            return -1;
        }
    }

}
