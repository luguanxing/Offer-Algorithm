package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0873_最长的斐波那契子序列的长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{1, 3, 5}));
        System.out.println(new Solution().lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));
    }

    static class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            Set<Integer> set = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toSet());
            int len = arr.length;
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int num1 = arr[i];
                    int num2 = arr[j];
                    int num3 = num1 + num2;
                    int currentLen = 2;
                    while (set.contains(num3)) {
                        currentLen++;
                        max = Math.max(max, currentLen);
                        num1 = num2;
                        num2 = num3;
                        num3 = num1 + num2;
                    }
                }
            }
            return max;
        }
    }

    static class Solution_暴力 {
        int max = 0;

        public int lenLongestFibSubseq(int[] arr) {
            dfs(arr, 0, new ArrayList<>());
            return max <= 2 ? 0 : max;
        }

        private void dfs(int[] arr, int index, List<Integer> list) {
            if (checkOk(list)) {
                if (list.size() > max) {
                    System.out.println(max + "->" + list);
                }
                max = Math.max(max, list.size());
            } else {
                return;
            }
            if (index == arr.length) {
                return;
            }
            list.add(arr[index]);
            dfs(arr, index + 1, list);
            list.remove(list.size() - 1);
            dfs(arr, index + 1, list);
        }

        private boolean checkOk(List<Integer> list) {
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i - 2) + list.get(i - 1) != list.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
