package leetcode.problems;

import java.util.*;

public class Test0970_强整数 {

    public static void main(String[] args) {
        System.out.println(new Solution().powerfulIntegers(2, 3, 10));
        System.out.println(new Solution().powerfulIntegers(3, 5, 15));
        System.out.println(new Solution().powerfulIntegers(2, 1, 10));
    }

    static class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> set1 = new TreeSet<>();
            for (int i = 0; Math.pow(x, i) <= bound; i++) {
                int num1 = (int) Math.pow(x, i);
                if (set1.contains(num1)) {
                    break;
                }
                set1.add(num1);
            }
            Set<Integer> set2 = new TreeSet<>();
            Set<Integer> res = new TreeSet<>();
            for (int j = 0; Math.pow(y, j) <= bound; j++) {
                int num2 = (int) Math.pow(y, j);
                if (set2.contains(num2)) {
                    break;
                }
                set2.add(num2);
                for (int num1 : set1) {
                    if (num1 + num2 <= bound) {
                        res.add(num1 + num2);
                    }
                }
            }
            return new ArrayList<>(res);
        }
    }

}
