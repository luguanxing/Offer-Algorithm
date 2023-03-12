package leetcode.contest.week336;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test6316_重排数组以得到最大前缀分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{2, -1, 0, 1, -3, 3, -3}));
        System.out.println(new Solution().maxScore(new int[]{-2, -3, 0}));
        System.out.println(new Solution().maxScore(new int[]{-2, -3, 1}));
    }

    static class Solution {
        public int maxScore(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list, Collections.reverseOrder());
            int res = 0;
            long sum = 0;
            for (int num : list) {
                sum += num;
                if (sum > 0) {
                    res++;
                }
            }
            return res;
        }
    }

}
