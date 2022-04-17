package leetcode.contest.week298;

import java.util.HashMap;
import java.util.Map;

public class Test6071_完成所有任务需要的最少轮数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
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
            int res = 0;
            for (int cnt : map.values()) {
                if (cnt % 3 == 0) {
                    res += cnt / 3;
                } else if (cnt >= 4 && (cnt - 4) % 3 == 0) {
                    int mod3 = 0;
                    mod3 += (cnt - 4) / 3;
                    mod3 += 2;
                    int mod2 = Integer.MAX_VALUE;
                    if (cnt % 2 == 0) {
                        mod2 = cnt / 2;
                    }
                    res += Math.min(mod3, mod2);
                } else if (cnt >= 2 && (cnt - 2) % 3 == 0) {
                    int mod3 = 0;
                    mod3 += (cnt - 2) / 3;
                    mod3 += 1;
                    int mod2 = Integer.MAX_VALUE;
                    if (cnt % 2 == 0) {
                        mod2 = cnt / 2;
                    }
                    res += Math.min(mod3, mod2);
                } else {
                    if (cnt % 2 != 0) {
                        return -1;
                    }
                    res += cnt / 2;
                }
            }
            return res;
        }
    }

}
