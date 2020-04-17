package offer;

import java.util.ArrayList;

public class Test59_滑动窗口的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
        System.out.println(new Solution().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 0));
    }

    static class Solution {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            if (num == null) {
                return null;
            }
            ArrayList<Integer> list = new ArrayList<>();
            if (size == 0 || num.length < size) {
                return list;
            }
            // 维护窗口中最大值，复杂度O(nk)
            for (int i = size - 1; i < num.length; i++) {
                int max = num[i];
                for (int k = 0; k < size; k++) {
                    max = Math.max(max, num[i - k]);
                }
                list.add(max);
            }
            return list;
        }
    }

}
