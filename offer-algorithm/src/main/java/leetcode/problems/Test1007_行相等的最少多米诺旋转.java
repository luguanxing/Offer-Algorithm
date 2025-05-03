package leetcode.problems;

import java.util.*;

public class Test1007_行相等的最少多米诺旋转 {

    public static void main(String[] args) {
        // tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
        System.out.println(new Solution().minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        // tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
        System.out.println(new Solution().minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
        System.out.println(new Solution().minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println(new Solution().minDominoRotations(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    static class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            // 选择顶部的第一个元素作为top目标值
            int ans1 = getResult(tops, bottoms, tops[0]);
            // 选择底部的第一个元素作为top目标值，合法时要加上首次的切换
            int ans2 = getResult(tops, bottoms, bottoms[0]);
            if (ans2 != -1) {
                ans2++;
            }
            // 选择顶部的第一个元素作为bottom目标值
            int ans3 = getResult(bottoms, tops, tops[0]);
            if (ans3 != -1) {
                ans3++;
            }
            // 选择底部的第一个元素作为bottom目标值
            int ans4 = getResult(bottoms, tops, bottoms[0]);
            Set<Integer> ansSet = new TreeSet<>();
            for (int ans : new int[]{ans1, ans2, ans3, ans4}) {
                if (ans != -1) {
                    ansSet.add(ans);
                }
            }
            return ansSet.isEmpty() ? -1 : ansSet.stream().findFirst().get();
        }

        private int getResult(int[] tops, int[] bottoms, int top) {
            int len = tops.length;
            int cnt = 0;
            for (int i = 1; i < len; i++) {
                if (tops[i] == top) {
                    continue;
                } else if (bottoms[i] == top) {
                    cnt++;
                } else {
                    return -1;
                }
            }
            return cnt;
        }
    }

}
