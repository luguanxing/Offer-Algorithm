package leetcode.problems;

import java.util.TreeMap;

public class Test0220_存在重复元素III {

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(
                new int[]{1, 2, 3, 1}, 3, 0
        ));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(
                new int[]{1, 0, 1, 1}, 1, 2
        ));
        System.out.println(new Solution().containsNearbyAlmostDuplicate(
                new int[]{1, 5, 9, 1, 5, 9}, 2, 3
        ));
    }

    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeMap<Long, Integer> window = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                long num = nums[i];
                // 判断是否window中该位置左右数相差有符合小于t
                Long lessOne = window.floorKey(num);
                Long moreOne = window.ceilingKey(num);
                if ((lessOne != null && num - t <= lessOne) || (moreOne != null && moreOne <= num + t)) {
                    return true;
                }
                // 增减元素维护窗口
                window.put(num, window.getOrDefault(num, 0) + 1);
                if (i >= k) {
                    window.put((long) nums[i - k], window.get(num) - 1);
                    if (window.get((long) nums[i - k]) == 0) {
                        window.remove((long) nums[i - k]);
                    }
                }
            }
            return false;
        }
    }

}
