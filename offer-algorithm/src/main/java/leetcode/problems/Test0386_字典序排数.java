package leetcode.problems;

import java.util.*;

public class Test0386_字典序排数 {

    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13));
        System.out.println(new Solution().lexicalOrder(2));
    }

    static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1 ; i <= n; i++) {
                list.add(i);
            }
            Collections.sort(list, Comparator.comparing(String::valueOf));
            return list;
        }
    }

}
