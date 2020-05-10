package leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1424_对角线遍历II {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Stream.of(14, 12, 19, 16, 9).collect(Collectors.toList()));
        nums.add(Stream.of(13, 14, 15, 8, 11).collect(Collectors.toList()));
        nums.add(Stream.of(11, 13, 1).collect(Collectors.toList()));
        System.out.println(Arrays.toString(new Solution().findDiagonalOrder(nums)));
    }

    static class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            if (nums == null) {
                return null;
            }
            // 先计算对角线个数=宽度+最长边
            int height = nums.size();
            int maxLen = nums.stream().map(List::size).max(Integer::compareTo).orElse(0);
            int diagonalSize = height + maxLen;
            // 每个元素加到对角线的list前面中
            List<List<Integer>> diagonalList = new ArrayList<>();
            for (int i = 1; i <= diagonalSize; i++) {
                diagonalList.add(new ArrayList<>());
            }
            for (int y = 0; y < nums.size(); y++) {
                List<Integer> list = nums.get(y);
                for (int x = 0; x < list.size(); x++) {
                    diagonalList.get(x + y).add(0, nums.get(y).get(x));
                }
            }
            // 转换为数组并返回
            List<Integer> resultList = new ArrayList<>();
            diagonalList.forEach(resultList::addAll);
            int[] result = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
            return result;
        }
    }

    static class Solution_暴力 {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            if (nums == null) {
                return null;
            }
            // 对角线遍历
            List<Integer> resultList = new ArrayList<>();
            for (int y = 0; y < nums.size(); y++) {
                diagonalCheck(resultList, nums, y, 0);
            }
            // 从最左下边缘开始遍历，要包括最长边
            Integer maxLen = nums.stream().map(List::size).max(Integer::compareTo).orElse(0);
            for (int x = 1; x < maxLen; x++) {
                diagonalCheck(resultList, nums, nums.size() - 1, x);
            }
            int[] result = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
            return result;
        }

        public void diagonalCheck(List<Integer> resultList, List<List<Integer>> nums, int y, int x) {
            if (y < 0) {
                return;
            }
            if (0 <= y && y < nums.size() && 0 <= x && x < nums.get(y).size()) {
                resultList.add(nums.get(y).get(x));
            }
            diagonalCheck(resultList, nums, y - 1, x + 1);
        }
    }

}
