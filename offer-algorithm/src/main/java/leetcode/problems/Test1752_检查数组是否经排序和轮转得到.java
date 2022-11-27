package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test1752_检查数组是否经排序和轮转得到 {

    public static void main(String[] args) {
        System.out.println(new Solution().check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().check(new int[]{2, 1, 3, 4}));
    }

    static class Solution {
        public boolean check(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<Integer> dlist = new ArrayList<>();
            dlist.addAll(list);
            dlist.addAll(list);
            Collections.sort(list);
            String full = dlist.toString();
            String part = list.toString();
            return full.contains(part.substring(1, part.length() - 1));
        }
    }

}
