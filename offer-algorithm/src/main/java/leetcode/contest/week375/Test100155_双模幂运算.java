package leetcode.contest.week375;

import java.math.BigInteger;
import java.util.*;

public class Test100155_双模幂运算 {

    public static void main(String[] args) {
        // variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
        System.out.println(new Solution().getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
        // variables = [[39,3,1000,1000]], target = 17
        System.out.println(new Solution().getGoodIndices(new int[][]{{39, 3, 1000, 1000}}, 17));
    }

    static class Solution {
        public List<Integer> getGoodIndices(int[][] variables, int target) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < variables.length; i++) {
                int[] variable = variables[i];
                BigInteger a = new BigInteger(String.valueOf(variable[0]));
                BigInteger b = new BigInteger(String.valueOf(variable[1]));
                BigInteger c = new BigInteger(String.valueOf(variable[2]));
                BigInteger m = new BigInteger(String.valueOf(variable[3]));
                if (a.modPow(b, new BigInteger("10")).modPow(c, m).intValue() == target) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
