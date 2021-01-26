package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1128_等价多米诺骨牌对的数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().numEquivDominoPairs(
                new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}
        ));
    }

    static class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            Map<String, Integer> map = new HashMap<>();
            for (int[] dominoe : dominoes) {
                Arrays.sort(dominoe);
                map.put(Arrays.toString(dominoe), map.getOrDefault(Arrays.toString(dominoe), 0) + 1);
            }
            int res = 0;
            for (int cnt : map.values()) {
                res += (cnt - 1) * cnt / 2;
            }
            return res;
        }
    }

}
