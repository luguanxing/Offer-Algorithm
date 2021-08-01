package leetcode.contest.week252;

import java.util.ArrayList;
import java.util.List;

public class Test5830_三除数 {

    public static void main(String[] args) {
        System.out.println(new Solution().isThree(2));
        System.out.println(new Solution().isThree(4));
    }

    static class Solution {
        public boolean isThree(int n) {
            List<Integer> divs = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    divs.add(i);
                }
            }
            return divs.size() == 3;
        }
    }

}
