package leetcode.contest.week194;

import java.util.*;

public class Test5442_避免洪水泛滥 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 0, 1, 2})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{69, 0, 0, 0, 69})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{10, 20, 20})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 0, 2, 0, 2, 1})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 0, 1, 0, 2, 0, 2})));
    }

    static class Solution {
        public int[] avoidFlood(int[] rains) {
            int[] res = new int[rains.length];
            // 保存所有将出现洪水的湖位置以及将前后两次下雨位置保存下来
            Map<Integer, Integer> lakeMap = new HashMap<>();
            List<Target> targets = new ArrayList<>();
            for (int i = 0; i < rains.length; i++) {
                int lake = rains[i];
                if (lake == 0) {
                    continue;
                }
                if (!lakeMap.containsKey(lake)) {
                    lakeMap.put(lake, i);
                } else {
                    Integer first = lakeMap.get(lake);
                    Integer second = i;
                    targets.add(new Target(first, second, lake));
                    lakeMap.remove(lake);
                }
            }
            // 按第二次下雨位置优先排序
            targets.sort(Comparator.comparingInt(o -> o.second));
            Set<Integer> lakes = new HashSet<>();
            for (int i = 0; i < rains.length; i++) {
                int lake = rains[i];
                if (lake > 0) {
                    // 检测是否已经发生洪水
                    if (lakes.contains(lake)) {
                        return new int[]{};
                    }
                    lakes.add(lake);
                    res[i] = -1;
                } else {
                    // 遍历到不下雨时根据优先级抢修
                    if (!targets.isEmpty()) {
                        boolean targetCleared = false;
                        for (Target tartget : targets) {
                            if (tartget.first < i) {
                                targets.remove(tartget);
                                res[i] = tartget.lake;
                                lakes.remove(tartget.lake);
                                targetCleared = true;
                                break;
                            }
                        }
                        if (!targetCleared) {
                            res[i] = 1;
                        }
                    } else {
                        res[i] = 1;
                    }
                }
            }
            return res;
        }

        static class Target {
            int first;
            int second;
            int lake;

            public Target(int left, int right, int lake) {
                this.first = left;
                this.second = right;
                this.lake = lake;
            }

            @Override
            public String toString() {
                return "(" + first + "," + second + ")" + "=" + lake;
            }
        }
    }

}
