package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1104_二叉树寻路 {

    public static void main(String[] args) {
        System.out.println(new Solution().pathInZigZagTree(14));
        System.out.println(new Solution().pathInZigZagTree(26));
    }

    static class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            // 构建Z树
            List<Integer> nums = new ArrayList<>();
            int level = 1;
            int index = 1;
            boolean isReverse = false;
            while (nums.size() < 1000005) {
                List<Integer> levelNums = new ArrayList<>();
                for (int i = 1; i <= level; i++) {
                    levelNums.add(index++);
                }
                if (isReverse) {
                    Collections.reverse(levelNums);
                }
                nums.addAll(levelNums);
                level = level * 2;
                isReverse = !isReverse;
            }
            // 找到label并返回父节点
            List<Integer> res = new ArrayList<>();
            int pos = nums.indexOf(label) + 1;
            while (pos > 0) {
                res.add(0, nums.get(pos - 1));
                pos = pos / 2;
            }
            return res;
        }
    }

}
