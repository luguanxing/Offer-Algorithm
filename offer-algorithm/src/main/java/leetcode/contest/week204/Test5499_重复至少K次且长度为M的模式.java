package leetcode.contest.week204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5499_重复至少K次且长度为M的模式 {

    public static void main(String[] args) {
        System.out.println(new Solution().containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
        System.out.println(new Solution().containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        System.out.println(new Solution().containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3));
        System.out.println(new Solution().containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(new Solution().containsPattern(new int[]{2, 2, 2, 2}, 2, 3));
        System.out.println(new Solution().containsPattern(new int[]{2, 2}, 1, 2));
    }

    static class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            List<Integer> list = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            for (int i = 0; i <= list.size() - m * k; i++) {
                List<Integer> mkList = list.subList(i, i + m * k);
                List<Integer> mList = mkList.subList(0, m);
                List<Integer> _mkList = new ArrayList<>();
                for (int j = 1; j <= k; j++) {
                    _mkList.addAll(mList);
                }
                if (_mkList.toString().equals(mkList.toString())) {
                    return true;
                }
            }
            return false;
        }
    }

}
