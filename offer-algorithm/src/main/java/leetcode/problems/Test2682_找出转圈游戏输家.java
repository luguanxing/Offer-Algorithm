package leetcode.problems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test2682_找出转圈游戏输家 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().circularGameLosers(5, 2)));
        System.out.println(Arrays.toString(new Solution().circularGameLosers(4, 4)));
        System.out.println(Arrays.toString(new Solution().circularGameLosers(6, 1)));
    }

    static class Solution {
        public int[] circularGameLosers(int n, int k) {
            int[] friends = new int[n];
            int current = 0;
            int cnt = 1;
            while (friends[current] < 1) {
                friends[current]++;
                current += (cnt++) * k;
                current %= n;
            }
            return IntStream.range(1, n + 1).filter(i -> friends[i - 1] == 0).toArray();
        }
    }

}
