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
            Map<Integer, Integer> map = new HashMap<>();
            List<TargetPair> pairs = new ArrayList<>();
            for (int i = 0; i < rains.length; i++) {
                int lake = rains[i];
                if (lake == 0) {
                    continue;
                }
                if (!map.containsKey(lake)) {
                    map.put(lake, i);
                } else {
                    Integer left = map.get(lake);
                    Integer right = i;
                    pairs.add(new TargetPair(left, right, lake));
                    map.remove(lake);
                }
            }
            pairs.sort(Comparator.comparingInt(o -> o.right));
            Set<Integer> lakes = new HashSet<>();
            for (int i = 0; i < rains.length; i++) {
                int lake = rains[i];
                if (lake > 0) {
                    if (lakes.contains(lake)) {
                        // 已经发生洪水
                        return new int[]{};
                    }
                    lakes.add(lake);
                    res[i] = -1;
                } else {
                    // 根据后续判断之前哪个需要优先抽取
                    if (!pairs.isEmpty()) {
                        boolean ok = false;
                        for (int j = 0; j < pairs.size(); j++) {
                            TargetPair pair = pairs.get(j);
                            if (pair.left < i) {
                                pairs.remove(pair);
                                res[i] = pair.lake;
                                lakes.remove(pair.lake);
                                ok = true;
                                break;
                            }
                        }
                        if (!ok) {
                            res[i] = 1;
                        }
                    } else {
                        res[i] = 1;
                    }
                }
            }
            return res;
        }

        static class TargetPair {
            int left;
            int right;
            int lake;

            public TargetPair(int left, int right, int lake) {
                this.left = left;
                this.right = right;
                this.lake = lake;
            }

            @Override
            public String toString() {
                return "(" + left + "," + right + ")" + "=" + lake;
            }
        }
    }

}
