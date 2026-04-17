package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test3761_镜像对之间最小绝对距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().minMirrorPairDistance(new int[]{12, 21, 45, 33, 54}));
        System.out.println(new Solution().minMirrorPairDistance(new int[]{120, 21}));
        System.out.println(new Solution().minMirrorPairDistance(new int[]{21, 120}));
    }

    static class Solution {
        public int minMirrorPairDistance(int[] nums) {
            int res = Integer.MAX_VALUE;
            Map<Integer, Integer> reIdxMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int reNum = Integer.parseInt(
                        new StringBuilder(String.valueOf(num))
                                .reverse()
                                .toString()
                );
                if (reIdxMap.containsKey(num)) {
                    res = Math.min(res, i - reIdxMap.get(num));
                }
                reIdxMap.put(reNum, i);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

}
