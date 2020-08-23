package leetcode.contest.week203;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5497_查找大小为M的最新分组 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
        System.out.println(new Solution().findLatestStep(new int[]{3, 5, 1, 4, 2}, 2));
        System.out.println(new Solution().findLatestStep(new int[]{1}, 1));
        System.out.println(new Solution().findLatestStep(new int[]{2, 1}, 2));
    }

    static class Solution {
        public int findLatestStep(int[] arr, int m) {
            if (m == arr.length) {
                return m;
            }
            // 左开右开区间，两个连续的数之间包含为连续的1长度
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(0);
            treeSet.add(arr.length + 1);
            // 逆序拆分，使用了tree加速查找拆分的位置，并在每次拆分后判断左右连续1的长度是否符合条件
            for (int i = arr.length - 1; i >= 0; i--) {
                int divIndex = arr[i];
                int lower = treeSet.lower(divIndex);
                int higher = treeSet.higher(divIndex);
                if (divIndex - lower - 1 == m || higher - divIndex - 1 == m) {
                    return i;
                } else {
                    treeSet.add(divIndex);
                }
            }
            return -1;
        }
    }

    static class Solution_暴力 {
        public int findLatestStep(int[] arr, int m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= arr.length; i++) {
                sb.append('1');
            }
            String target = "";
            for (int i = 1; i <= m; i++) {
                target += "1";
            }
            if (sb.toString().equals(target)) {
                return target.length();
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                int index = arr[i] - 1;
                sb.setCharAt(index, '0');
                Set<String> set = Stream.of(sb.toString().split("0")).collect(Collectors.toSet());
                if (set.contains(target)) {
                    return i;
                }
            }
            return -1;
        }
    }

}
