package leetcode.problems;

import java.util.*;

public class Test2178_拆分成最多数目的正偶数之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumEvenSplit(12));
        System.out.println(new Solution().maximumEvenSplit(7));
        System.out.println(new Solution().maximumEvenSplit(6));
        System.out.println(new Solution().maximumEvenSplit(28));
    }

    static class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> list = new ArrayList<>();
            if (finalSum % 2 == 1) {
                return list;
            }
            long numOf2 = finalSum / 2;
            for (long i = 1; i <= numOf2; i++) {
                if (i * (i + 1) / 2 >= numOf2) {
                    // 贪心：最多可以使用i个连续整数凑出numOf2
                    for (long j = 1; j <= i; j++) {
                        if (numOf2 >= j) {
                            // 使用连续整数凑
                            list.add(j * 2);
                            numOf2 -= j;
                        } else {
                            // 最后一个数重复了，加到之前最大的整数里
                            long lastNum = list.get(list.size() - 1);
                            list.remove(list.size() - 1);
                            list.add(lastNum + numOf2 * 2);
                        }
                    }
                    break;
                }
            }
            return list;
        }
    }

}
