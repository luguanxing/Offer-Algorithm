package leetcode.problems;

import java.util.Arrays;

public class Test1894_找到需要补充粉笔的学生编号 {

    public static void main(String[] args) {
        System.out.println(new Solution().chalkReplacer(
                new int[]{5, 1, 5}, 22
        ));
        System.out.println(new Solution().chalkReplacer(
                new int[]{3, 4, 1, 2}, 25
        ));
    }

    static class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long sum = 0;
            for (int num : chalk) {
                sum += num;
            }
            long last = k % sum;
            for (int i = 0; i < chalk.length; i++) {
                if (last - chalk[i] < 0) {
                    return i;
                }
                last -= chalk[i];
            }
            return 0;
        }
    }

}
