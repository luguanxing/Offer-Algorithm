package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0219_存在重复元素II {

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyDuplicate(
                new int[]{1, 2, 3, 1}, 3
        ));
        System.out.println(new Solution().containsNearbyDuplicate(
                new int[]{1, 0, 1, 1}, 1
        ));
        System.out.println(new Solution().containsNearbyDuplicate(
                new int[]{1, 2, 3, 1, 2, 3}, 2
        ));
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> lastIndexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (lastIndexMap.containsKey(num) && i - lastIndexMap.get(num) <= k) {
                    return true;
                }
                lastIndexMap.put(num, i);
            }
            return false;
        }
    }

    static class Solution_窗口 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    int num = nums[i];
                    if (cntMap.containsKey(num)) {
                        return true;
                    }
                    cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
                } else {
                    int numRight = nums[i];
                    int numLeft = nums[i - k];
                    if (cntMap.containsKey(numRight)) {
                        return true;
                    }
                    cntMap.put(numRight, cntMap.getOrDefault(numRight, 0) + 1);
                    cntMap.put(numLeft, cntMap.get(numLeft) - 1);
                    if (cntMap.get(numLeft) == 0) {
                        cntMap.remove(numLeft);
                    }
                }
            }
            return false;
        }
    }

}
