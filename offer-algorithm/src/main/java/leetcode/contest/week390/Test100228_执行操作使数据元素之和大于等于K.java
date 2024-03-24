package leetcode.contest.week390;

public class Test100228_执行操作使数据元素之和大于等于K {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(11));
        System.out.println(new Solution().minOperations(1));
        System.out.println(new Solution().minOperations(2));
        System.out.println(new Solution().minOperations(3));
        System.out.println(new Solution().minOperations(4));
    }

    static class Solution {
        public int minOperations(int k) {
            int min = k - 1; // 用于存储最小操作次数

            // 遍历可能的复制次数b
            for (int b = 1; b < k; b++) {
                // 计算在当前复制次数b下，需要的增加操作次数a
                int a = (k + b - 1) / b;
                // 检查当前的操作总数是否为最小值
                int currentOperations = (a - 1) + (b - 1);
                min = Math.min(min, currentOperations);
            }

            return min;
        }
    }


}
