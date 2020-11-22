package leetcode.contest.week216;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test5606_具有给定数值的最小字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().getSmallestString(3, 27));
        System.out.println(new Solution().getSmallestString(5, 73));
    }

    static class Solution {
        public String getSmallestString(int n, int k) {
            // 初始化数组
            int[] idx = new int[n];
            for (int i = 0; i < n; i++) {
                idx[i] = 1;
                k--;
            }
            // 从数组最后往前堆积，每个元素满26则往前，直到k没有了
            for (int i = n - 1; i >= 0; i--) {
                if (k > 0) {
                    int last = 26 - idx[i];
                    if (k <= last) {
                        idx[i] += k;
                        break;
                    } else {
                        k -= last;
                        idx[i] = 26;
                    }
                }
            }
            String res = Arrays.stream(idx)
                    .boxed()
                    .map(i -> (char)('a' + i - 1) + "")
                    .collect(Collectors.joining());
            return res;
        }
    }

}
