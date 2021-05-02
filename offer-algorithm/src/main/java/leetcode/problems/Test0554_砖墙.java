package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0554_砖墙 {

    public static void main(String[] args) {
        System.out.println(new Solution().leastBricks(
                Arrays.asList(
                        Arrays.asList(1, 2, 2, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 1, 1)
                )
        ));
        System.out.println(new Solution().leastBricks(
                Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(1),
                        Arrays.asList(1)
                )
        ));
    }

    static class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            // 找出缝隙最多的地方即可
            Map<Integer, Integer> gapCountMap = new HashMap<>();
            for (List<Integer> bricks : wall) {
                int gap = 0;
                for (int i = 0; i < bricks.size() - 1; i++) {
                    int brick = bricks.get(i);
                    gap += brick;
                    gapCountMap.put(gap, gapCountMap.getOrDefault(gap, 0) + 1);
                }
            }
            int maxGap = 0;
            for (int gapCnt : gapCountMap.values()) {
                maxGap = Math.max(maxGap, gapCnt);
            }
            return wall.size() - maxGap;
        }
    }

}
