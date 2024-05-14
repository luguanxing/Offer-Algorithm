package leetcode.problems;

import java.util.*;

public class Test2244_完成所有任务需要的最少轮数 {

    public static void main(String[] args) {
        // tasks = [2,2,3,3,2,4,4,4,4,4]
        System.out.println(new Solution().minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        // tasks = [2,3,3]
        System.out.println(new Solution().minimumRounds(new int[]{2, 3, 3}));
        System.out.println(new Solution().minimumRounds(new int[]{5, 5, 5, 5}));
        System.out.println(new Solution().minimumRounds(new int[]{66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61}));
    }

    static class Solution {
        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int task : tasks) {
                map.put(task, map.getOrDefault(task, 0) + 1);
            }
            int round = 0;
            // 2x + 3y = cnt，要求y尽可能大，x尽可能小
            // 注意，3个2不如2个3，所以x<3即x=0,1,2
            for (int cnt : map.values()) {
                // 优先凑3
                if (cnt % 3 == 0) {
                    round += cnt / 3;
                } else if (cnt > 2 && (cnt - 2) % 3 == 0) {
                    round += 1;
                    round += (cnt - 2) / 3;
                } else if (cnt > 4 && (cnt - 4) % 3 == 0) {
                    round += 2;
                    round += (cnt - 2) / 3;
                }
                // 凑不了3再凑2
                else if (cnt > 3 && (cnt - 3) % 2 == 0) {
                    round += 1;
                    round += (cnt - 3) / 2;
                } else if (cnt % 2 == 0) {
                    round += cnt / 2;
                }
                // 3和2都凑不了
                else {
                    return -1;
                }
            }
            return round;
        }
    }

}
