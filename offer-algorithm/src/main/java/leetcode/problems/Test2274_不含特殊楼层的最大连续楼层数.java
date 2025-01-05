package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test2274_不含特殊楼层的最大连续楼层数 {

    public static void main(String[] args) {
        // bottom = 2, top = 9, special = [4,6]
        System.out.println(new Solution().maxConsecutive(2, 9, new int[]{4, 6}));
        // bottom = 6, top = 8, special = [7,6,8]
        System.out.println(new Solution().maxConsecutive(6, 8, new int[]{7, 6, 8}));
    }

    static class Solution {
        public int maxConsecutive(int bottom, int top, int[] special) {
            List<Integer> list = Arrays.stream(special).boxed().collect(Collectors.toList());
            list.add(bottom - 1);
            list.add(top + 1);
            Collections.sort(list);
            int maxGap = 0;
            for (int i = 1; i < list.size(); i++) {
                maxGap = Math.max(maxGap, list.get(i) - list.get(i - 1) - 1);
            }
            return maxGap;
        }
    }

    static class Solution_SET {
        public int maxConsecutive(int bottom, int top, int[] special) {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(bottom - 1);
            for (int s : special) {
                set.add(s);
            }
            set.add(top + 1);
            int maxGap = 0;
            for (int level : set) {
                Integer previousLevel = set.lower(level);
                if (previousLevel != null) {
                    maxGap = Math.max(maxGap, level - previousLevel);
                }
            }
            return maxGap - 1;
        }
    }

}
