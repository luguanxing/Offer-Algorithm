package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test0659_分割数组为连续子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(
                new int[]{1, 2, 3, 3, 4, 5}
        ));
        System.out.println(new Solution().isPossible(
                new int[]{1, 2, 3, 3, 4, 4, 5, 5}
        ));
        System.out.println(new Solution().isPossible(
                new int[]{1, 2, 3, 4, 4, 5}
        ));
        System.out.println(new Solution().isPossible(
                new int[]{1, 3, 3, 4, 4, 7, 8, 8, 9, 10}
        ));
        System.out.println(new Solution().isPossible(
                new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10, 11}
        ));
    }

    static class Solution {
        public boolean isPossible(int[] nums) {
            // 存储计数
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // 循环找连续整数
            while (!map.isEmpty()) {
                List<Integer> list = new ArrayList<>(map.keySet());
                int count = 1;
                int max = map.get(list.get(0));
                map.put(list.get(0), map.get(list.get(0)) - 1);
                for (int i = 1; i < list.size(); i++) {
                    // 不连续时截断
                    if (list.get(i) != list.get(i - 1) + 1) {
                        if (count < 3) {
                            return false;
                        } else {
                            break;
                        }
                    }
                    // 计数不能要更小的，因为要留给后面，所以需要在当前截断
                    if (max > map.get(list.get(i))) {
                        break;
                    } else {
                        max = map.get(list.get(i));
                        map.put(list.get(i), map.get(list.get(i)) - 1);
                    }
                    count++;
                }
                if (count < 3) {
                    return false;
                }
                for (int num : list) {
                    if (map.get(num) == 0) {
                        map.remove(num);
                    }
                }
            }
            return true;
        }
    }

}
