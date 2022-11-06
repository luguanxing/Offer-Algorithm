package leetcode.contest.week318;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6229_对数组执行操作 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(new Solution().applyOperations(new int[]{0, 1})));
    }

    static class Solution {
        public int[] applyOperations(int[] nums) {
            int len = nums.length;
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            for (int i = 0; i < len - 1; i++) {
                if (list.get(i) == (int) list.get(i + 1)) {
                    list.set(i, list.get(i) * 2);
                    list.set(i + 1, 0);
                }
            }
            int[] res = new int[len];
            int idx = 0;
            for (int num : list) {
                if (num != 0) {
                    res[idx++] = num;
                }
            }
            return res;
        }
    }

}
