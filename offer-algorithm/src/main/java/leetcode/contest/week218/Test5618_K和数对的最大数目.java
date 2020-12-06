package leetcode.contest.week218;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5618_K和数对的最大数目 {

    public static void main(String[] args) {
//        System.out.println(new Solution().maxOperations(
//                new int[]{1, 2, 3, 4}, 5
//        ));
//        System.out.println(new Solution().maxOperations(
//                new int[]{3, 1, 3, 4, 3}, 6
//        ));
        System.out.println(new Solution().maxOperations(
                new int[]{2, 2, 2, 3, 1, 1, 4, 1}, 4
        ));
    }

    static class Solution {
        public int maxOperations(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int res = 0;
            while (true) {
                boolean hasMore = false;
                for (int num : map.keySet()) {
                    if (2 * num == k) {
                        if (map.get(num) >= 2) {
                            map.put(num, map.get(num) - 2);
                            res++;
                            hasMore = true;
                        }
                    } else if (map.getOrDefault(k - num, 0) >= 1 && map.get(num) > 0) {
                        map.put(num, map.get(num) - 1);
                        map.put(k - num, map.get(k - num) - 1);
                        res++;
                        hasMore = true;
                    }
                }
                List<Integer> list = new ArrayList<>(map.keySet());
                for (int num : list) {
                    if (map.get(num) == 0) {
                        map.remove(num);
                    }
                }
                if (!hasMore) {
                    break;
                }
            }
            return res;
        }
    }

}
