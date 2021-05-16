package leetcode.contest.week241;

import java.util.ArrayList;
import java.util.List;

public class Test5759_找出所有子集的异或总和再求和 {

    public static void main(String[] args) {
        System.out.println(new Solution().subsetXORSum(
                new int[]{1, 3}
        ));
        System.out.println(new Solution().subsetXORSum(
                new int[]{5, 1, 6}
        ));
        System.out.println(new Solution().subsetXORSum(
                new int[]{3, 4, 5, 6, 7, 8}
        ));
    }

    static class Solution {
        Integer res;
        List<Integer> list = new ArrayList<>();

        public int subsetXORSum(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            dfs(nums, 0);
            return res;
        }

        private void dfs(int[] nums, int i) {
            if (i == nums.length) {
                if (!list.isEmpty()) {
                    int currenRes = list.get(0);
                    for (int j = 1; j < list.size(); j++) {
                        currenRes ^= list.get(j);
                    }
                    if (res == null) {
                        res = currenRes;
                    } else {
                        res += currenRes;
                    }
                }
                return;
            }
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
            dfs(nums, i + 1);
        }
    }

}
