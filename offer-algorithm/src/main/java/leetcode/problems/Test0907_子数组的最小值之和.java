package leetcode.problems;

import java.util.*;

public class Test0907_子数组的最小值之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(new Solution().sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
        System.out.println(new Solution().sumSubarrayMins(new int[]{71, 55, 82, 55}));
    }

    static class Solution {
        public int sumSubarrayMins(int[] arr) {
            // 计算每个数能辐射的范围
            int MOD = 1000000007;
            int len = arr.length;
            long sum = 0;
            for (int i = 0; i < len; i++) {
                int l = i - 1;
                while (l >= 0 && arr[l] > arr[i]) {
                    l--;
                }
                int r = i + 1;
                while (r < len && arr[i] <= arr[r]) {
                    r++;
                }
                sum += (long) (i - l) * (long) (r - i) * (long) arr[i];
                sum %= MOD;
            }
            return (int) sum;
        }
    }

    static class Solution_单调栈 {
        public int sumSubarrayMins(int[] arr) {
            int MOD = 1000000007;
            int len = arr.length;
            long sum = 0;
            // 使用单调栈存储下标数据，用于计算辐射范围
            Deque<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i <= len; i++) {
                // 最后要放入一个0计算栈内所有剩下结果
                int num = i == len ? 0 : arr[i];
                while (!queue.isEmpty() && queue.peekLast()[0] > num) {
                    int beforeNum = queue.peekLast()[0];
                    int beforeIndex = queue.peekLast()[1];
                    queue.pollLast();
                    int beforeBeforeIndex = queue.isEmpty() ? -1 : queue.peekLast()[1];
                    sum += (long) (beforeIndex - beforeBeforeIndex) * (long) (i - beforeIndex) * (long) beforeNum;
                    sum %= MOD;
                }
                queue.add(new int[]{num, i});
            }
            return (int) sum;
        }
    }

    static class Solution_暴力 {
        public int sumSubarrayMins(int[] arr) {
            int MOD = 1000000007;
            int len = arr.length;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int min = arr[i];
                sum += min;
                sum %= MOD;
                for (int j = i + 1; j < len; j++) {
                    min = Math.min(min, arr[j]);
                    sum += min;
                    sum %= MOD;
                }
            }
            return sum;
        }
    }

}
