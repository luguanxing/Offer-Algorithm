package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test2537_统计好子数组的数目 {

    public static void main(String[] args) {
        // nums = [1,1,1,1,1], k = 10
        System.out.println(new Solution().countGood(new int[]{1, 1, 1, 1, 1}, 10));
        // nums = [3,1,4,3,2,2,4], k = 2
        System.out.println(new Solution().countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
    }

    static class Solution {
        public long countGood(int[] nums, int k) {
            int len = nums.length;
            long res = 0;
            int currentCnt = 0;
            // 滑动窗口统计
            Map<Integer, Integer> map = new HashMap<>();
            int l = 0;
            int r = 0;
            while (r < len) {
                int rNum = nums[r];
                map.put(rNum, map.getOrDefault(rNum, 0) + 1);
                currentCnt += map.get(rNum) - 1;
                while (currentCnt >= k && l < r) {
                    res += len - r;
                    int lNum = nums[l];
                    currentCnt -= map.get(lNum) - 1;
                    map.put(lNum, map.get(lNum) - 1);
                    if (map.get(lNum) == 0) {
                        map.remove(lNum);
                    }
                    l++;
                }
                r++;
            }
            return res;
        }
    }

}
