package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0046_全排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{}));
        System.out.println(new Solution().permute(null));
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return null;
            }
            // 初始化
            result.clear();
            current.clear();
            left.clear();
            for (int num : nums) {
                left.add(num);
            }
            // 回溯
            permute(current, left);
            return result;
        }

        public void permute(List<Integer> current, List<Integer> left) {
            if (left.size() == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            for (int i = 0; i < left.size(); i++) {
                Integer num = left.get(i);
                left.remove(i);
                current.add(num);
                permute(current, left);
                current.remove(current.size() - 1);
                left.add(i, num);
            }
        }
    }

    static class Solution_DFS {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null) {
                return null;
            }
            result.clear();
            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }
            permute(new ArrayList<>(), numList);
            return result;
        }

        public void permute(List<Integer> current, List<Integer> left) {
            if (left.size() == 0) {
                result.add(new ArrayList<>(current));
                return;
            }
            for (int i = 0; i < left.size(); i++) {
                Integer nextNum = left.get(i);
                ArrayList<Integer> nextCurrent = new ArrayList<>(current);
                ArrayList<Integer> nextLeft = new ArrayList<>(left);
                nextCurrent.add(nextNum);
                nextLeft.remove(i);
                permute(nextCurrent, nextLeft);
            }
        }
    }

}
