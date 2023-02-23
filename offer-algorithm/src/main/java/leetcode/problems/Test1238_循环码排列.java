package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1238_循环码排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().circularPermutation(2, 3));
        System.out.println(new Solution().circularPermutation(3, 2));
    }

    static class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> list = new ArrayList<>();
            // 格雷码生成g(i)=i ^ i/2
            for (int i = 0; i < 1 << n; i++) {
                list.add(i ^ (i / 2));
            }
            list.addAll(list);
            int idx = list.indexOf(start);
            return list.subList(idx, idx + (1 << n));
        }
    }

}
