package leetcode.contest.week212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test5547_等差子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(
                new int[]{4, 6, 5, 9, 3, 7},
                new int[]{0, 0, 2},
                new int[]{2, 3, 5}
        ));
        System.out.println(new Solution().checkArithmeticSubarrays(
                new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10},
                new int[]{0, 1, 6, 4, 8, 7},
                new int[]{4, 4, 9, 7, 9, 10}
        ));
    }

    static class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Boolean> res = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                int left = l[i];
                int right = r[i];
                List<Integer> subList = new ArrayList<>(list.subList(left, right + 1));
                if (isOk(subList)) {
                    res.add(true);
                } else {
                    res.add(false);
                }
            }
            return res;
        }

        private boolean isOk(List<Integer> subList) {
            // 判断等差数列
            Collections.sort(subList);
            int maxDiff = subList.get(1) - subList.get(0);
            int minDiff = subList.get(1) - subList.get(0);
            for (int i = 2; i < subList.size(); i++) {
                maxDiff = Math.max(maxDiff, subList.get(i) - subList.get(i - 1));
                minDiff = Math.min(minDiff, subList.get(i) - subList.get(i - 1));
            }
            return maxDiff == minDiff;
        }
    }

}
