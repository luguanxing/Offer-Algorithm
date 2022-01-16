package leetcode.contest.week276;

import java.util.HashMap;
import java.util.Map;

public class Test5194_得到目标值的最少行动次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves(5, 0));
        System.out.println(new Solution().minMoves(19, 2));
        System.out.println(new Solution().minMoves(10, 4));
        System.out.println(new Solution().minMoves(1000, 88));
    }

    static class Solution {
        public int minMoves(int target, int leftDoubles) {
            int res = 0;
            int current = target;
            while (leftDoubles > 0 && current > 1) {
                if (current % 2 == 0) {
                    current /= 2;
                    leftDoubles--;
                } else {
                    current--;
                }
                res++;
            }
            return res + (current-1);
        }
    }

}
