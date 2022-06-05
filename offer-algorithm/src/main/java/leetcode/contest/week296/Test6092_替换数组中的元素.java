package leetcode.contest.week296;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test6092_替换数组中的元素 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().arrayChange(
                new int[]{1, 2, 4, 6},
                new int[][]{{1, 3}, {4, 7}, {6, 1}}
        )));
        System.out.println(Arrays.toString(new Solution().arrayChange(
                new int[]{1, 2},
                new int[][]{{1, 3}, {2, 1}, {3, 2}}
        )));
    }

    static class Solution {
        public int[] arrayChange(int[] nums, int[][] operations) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int[] operation : operations) {
                int from = operation[0];
                int to = operation[1];
                int index = map.get(from);
                map.remove(from);
                map.put(to, index);
            }
            int[] res = new int[nums.length];
            for (Map.Entry<Integer, Integer> indexNum : map.entrySet()) {
                int num = indexNum.getKey();
                int index = indexNum.getValue();
                res[index] = num;
            }
            return res;
        }
    }

}
