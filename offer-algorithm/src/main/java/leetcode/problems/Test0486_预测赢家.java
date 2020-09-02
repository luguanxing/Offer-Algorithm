package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0486_预测赢家 {

    public static void main(String[] args) {
        System.out.println(new Solution().PredictTheWinner(new int[]{0}));
        System.out.println(new Solution().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new Solution().PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

    static class Solution {
        public boolean PredictTheWinner(int[] nums) {
            List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int maxGet = check(numList, true, 0);
            return maxGet >= 0;
        }

        private int check(List<Integer> numList, boolean first, int sum) {
            if (numList.size() == 1) {
                if (first) {
                    return sum + numList.get(0);
                } else {
                    return sum - numList.get(0);
                }
            } else {
                int left = numList.get(0);
                int right = numList.get(numList.size() - 1);
                if (first) {
                    numList.remove(0);
                    int takeLeft = check(numList, !first, sum + left);
                    numList.add(0, left);
                    numList.remove(numList.size() - 1);
                    int takeRight = check(numList, !first, sum + right);
                    numList.add(numList.size(), right);
                    return Math.max(takeLeft, takeRight);
                } else {
                    numList.remove(0);
                    int takeLeft = check(numList, !first, sum - left);
                    numList.add(0, left);
                    numList.remove(numList.size() - 1);
                    int takeRight = check(numList, !first, sum - right);
                    numList.add(numList.size(), right);
                    return Math.min(takeLeft, takeRight);
                }
            }
        }
    }

}
