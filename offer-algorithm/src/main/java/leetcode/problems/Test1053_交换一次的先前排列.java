package leetcode.problems;

import java.util.Arrays;

public class Test1053_交换一次的先前排列 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(new Solution().prevPermOpt1(new int[]{1, 1, 5})));
        System.out.println(Arrays.toString(new Solution().prevPermOpt1(new int[]{1, 9, 4, 6, 7})));
        System.out.println(Arrays.toString(new Solution().prevPermOpt1(new int[]{1, 1, 9, 4, 9, 7, 7, 5, 3, 10, 4, 10, 2, 3, 4, 9, 4, 6, 5, 10, 7, 2, 9, 4, 10, 7, 10, 5, 10, 9, 5, 3, 6, 9, 3, 1, 2, 9, 1, 4, 5, 1, 3, 2, 10, 7, 9, 6, 9, 6, 9, 9, 1, 8, 7, 8, 9, 5, 9, 8, 6, 1, 10, 9})));
        System.out.println(Arrays.toString(new Solution().prevPermOpt1(new int[]{3, 1, 1, 3})));
    }

    static class Solution {
        public int[] prevPermOpt1(int[] arr) {
            int[] oldArr = arr.clone();
            int[] maxArr = null;
            int len = arr.length;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] > arr[i]) {
                        int oldI = arr[i];
                        int oldJ = arr[j];
                        arr[i] = oldJ;
                        arr[j] = oldI;
                        if (isSmaller(arr, oldArr)) {
                            if (isBigger(arr, maxArr)) {
                                maxArr = arr.clone();
                            }
                        }
                        arr[i] = oldI;
                        arr[j] = oldJ;
                        break;
                    }
                }
            }
            return maxArr == null ? arr : maxArr;
        }

        private boolean isSmaller(int[] arr, int[] oldArr) {
            if (oldArr == null) {
                return false;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < oldArr[i]) {
                    return true;
                } else if (arr[i] > oldArr[i]) {
                    return false;
                }
            }
            return false;
        }

        private boolean isBigger(int[] arr, int[] oldArr) {
            if (oldArr == null) {
                return true;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > oldArr[i]) {
                    return true;
                } else if (arr[i] < oldArr[i]) {
                    return false;
                }
            }
            return false;
        }
    }

}
