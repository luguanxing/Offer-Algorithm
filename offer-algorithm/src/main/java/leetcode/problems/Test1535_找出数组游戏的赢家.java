package leetcode.problems;

import java.util.*;

public class Test1535_找出数组游戏的赢家 {

    public static void main(String[] args) {
        System.out.println(new Solution().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(new Solution().getWinner(new int[]{3, 2, 1}, 10));
        System.out.println(new Solution().getWinner(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(new Solution().getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
        System.out.println(new Solution().getWinner(new int[]{963, 541, 112, 470, 285, 93, 24, 953, 536, 363, 575, 522, 390, 9, 873, 940, 921, 198, 75}, 6));
    }

    static class Solution {
        public int getWinner(int[] arr, int k) {
            int len = arr.length;
            int currentMax = arr[0];
            int cnt = 0;
            for (int i = 1; i < len; i++) {
                if (arr[i] < currentMax) {
                    cnt++;
                } else {
                    currentMax = arr[i];
                    cnt = 1;
                }
                if (cnt == k) {
                    return currentMax;
                }
            }
            return currentMax;
        }
    }

    static class Solution_滑动窗口 {
        public int getWinner(int[] arr, int k) {
            int len = arr.length;
            k = Math.min(k, len - 1);
            int[] fullArr = new int[len * 2];
            System.arraycopy(arr, 0, fullArr, 0, len);
            System.arraycopy(arr, 0, fullArr, len, len);
            TreeMap<Integer, Integer> window = new TreeMap<>();
            // 构建窗口，长度为k
            for (int i = 0; i <= k; i++) {
                window.put(fullArr[i], window.getOrDefault(fullArr[i], 0) + 1);
            }
            // 判断首个元素
            if (fullArr[0] == window.lastKey()) {
                return fullArr[0];
            }
            // 判断后面的元素（需要下一位更大，而且是窗口内最大的）
            for (int i = 0; i < len; i++) {
                if (fullArr[i] < fullArr[i + 1] && fullArr[i + 1] == window.lastKey()) {
                    return fullArr[i + 1];
                }
                window.put(fullArr[i], window.get(fullArr[i]) - 1);
                if (window.get(fullArr[i]) == 0) {
                    window.remove(fullArr[i]);
                }
                window.put(fullArr[i + k + 1], window.getOrDefault(fullArr[i + k + 1], 0) + 1);
            }
            return -1;
        }
    }

}
