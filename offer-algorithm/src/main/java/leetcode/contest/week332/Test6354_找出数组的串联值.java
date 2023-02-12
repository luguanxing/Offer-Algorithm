package leetcode.contest.week332;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6354_找出数组的串联值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheArrayConcVal(new int[]{7, 52, 2, 4}));
        System.out.println(new Solution().findTheArrayConcVal(new int[]{5, 14, 13, 8, 12}));
    }

    static class Solution {
        public long findTheArrayConcVal(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            long sum = 0;
            while (!list.isEmpty()) {
                if (list.size() == 1) {
                    sum += list.get(0);
                    list.remove(0);
                } else {
                    sum += Long.parseLong(list.get(0) + "" + list.get(list.size() - 1));
                    list.remove(0);
                    list.remove(list.size() - 1);
                }
            }
            return sum;
        }
    }

}
