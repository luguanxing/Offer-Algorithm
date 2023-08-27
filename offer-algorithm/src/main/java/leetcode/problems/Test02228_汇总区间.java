package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test02228_汇总区间 {

    public static void main(String[] args) {
        System.out.println(new Solution().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(new Solution().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            int len = nums.length;
            List<String> res = new ArrayList<>();
            for (int i = 0; i < len; ) {
                int start = nums[i];
                int cnt = 1;
                while (i + cnt < len && nums[i + cnt] == start + cnt) {
                    cnt++;
                }
                if (cnt == 1) {
                    res.add(start + "");
                    i++;
                } else {
                    res.add(start + "->" + (start + cnt - 1));
                    i += cnt;
                }
            }
            return res;
        }
    }

}
