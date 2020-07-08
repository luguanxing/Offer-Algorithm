package leetcode.interview;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test16_11_跳水板 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(new Solution().divingBoard(1, 1, 0)));
        System.out.println(Arrays.toString(new Solution().divingBoard(2, 1118596, 979)));
    }

    static class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[]{};
            }
            Set<Integer> set = new TreeSet<>();
            for (int shoterNum = 0; shoterNum <= k; shoterNum++) {
                int longerNum = k - shoterNum;
                set.add(shorter * shoterNum + longer * longerNum);
            }
            int[] res = new int[set.size()];
            int index = 0;
            for (int len : set) {
                res[index++] = len;
            }
            return res;
        }
    }

}
