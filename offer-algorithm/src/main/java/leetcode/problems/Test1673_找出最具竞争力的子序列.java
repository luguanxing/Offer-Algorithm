package leetcode.problems;

import java.util.*;

public class Test1673_找出最具竞争力的子序列 {

    public static void main(String[] args) {
        // nums = [3,5,2,6], k = 2
        System.out.println(Arrays.toString(new Solution().mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        // nums = [2,4,3,3,5,4,9,6], k = 4
        System.out.println(Arrays.toString(new Solution().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
        System.out.println(Arrays.toString(new Solution().mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3)));
        System.out.println(Arrays.toString(new Solution().mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
    }

    static class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int[] res = new int[k];
            // 单调栈
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                // 当前数大于栈尾并且 数组后面剩下的个数足够填满栈时 才移除栈尾
                while (!deque.isEmpty() && deque.peekLast() > num && nums.length - i > k - deque.size()) {
                    deque.pollLast();
                }
                deque.addLast(num);
                if (deque.size() == k) {
                    List<Integer> list = new ArrayList<>(deque);
                    for (int j = 0; j < k; j++) {
                        res[j] = list.get(j);
                    }
                }
            }
            return res;
        }
    }

}
