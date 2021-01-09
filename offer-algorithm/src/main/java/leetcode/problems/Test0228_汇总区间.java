package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0228_汇总区间 {

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(
                new int[]{0, 1, 2, 4, 5, 7}
        ));
        System.out.println(new Solution().summaryRanges(
                new int[]{0, 2, 3, 4, 6, 8, 9}
        ));
        System.out.println(new Solution().summaryRanges(
                new int[]{}
        ));
        System.out.println(new Solution().summaryRanges(
                new int[]{-1}
        ));
        System.out.println(new Solution().summaryRanges(
                new int[]{0}
        ));
    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                if (current.isEmpty() || current.get(current.size() - 1) == num - 1) {
                    // 连续继续填充
                    current.add(num);
                } else {
                    // 不连续，重新分段
                    if (current.size() == 1) {
                        res.add(current.get(0) + "");
                    } else {
                        res.add(current.get(0) + "->" + current.get(current.size() - 1));
                    }
                    current.clear();
                    current.add(num);
                }
            }
            if (!current.isEmpty()) {
                if (current.size() == 1) {
                    res.add(current.get(0) + "");
                } else {
                    res.add(current.get(0) + "->" + current.get(current.size() - 1));
                }
            }
            return res;
        }
    }

}
