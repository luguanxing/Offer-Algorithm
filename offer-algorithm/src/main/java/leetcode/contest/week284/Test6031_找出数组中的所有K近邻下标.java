package leetcode.contest.week284;

import java.util.ArrayList;
import java.util.List;

public class Test6031_找出数组中的所有K近邻下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
        System.out.println(new Solution().findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2));
    }

    static class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            List<Integer> res = new ArrayList<>();
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (Math.abs(i - j) <= k && nums[j] == key) {
                        res.add(i);
                        break;
                    }
                }
            }
            return res;
        }
    }

}
