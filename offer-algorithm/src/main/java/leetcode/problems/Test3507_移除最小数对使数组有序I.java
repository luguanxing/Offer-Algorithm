package leetcode.problems;

import java.util.*;

public class Test3507_移除最小数对使数组有序I {

    public static void main(String[] args) {
        // nums = [5,2,3,1]
        System.out.println(new Solution().minimumPairRemoval(new int[]{5, 2, 3, 1}));
        // nums = [1,2,2]
        System.out.println(new Solution().minimumPairRemoval(new int[]{1, 2, 2}));
        // [2,2,-1,3,-2,2,1,1,1,0,-1]
        System.out.println(new Solution().minimumPairRemoval(new int[]{2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1}));
    }

    static class Solution {
        public int minimumPairRemoval(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            int cnt = 0;
            while (!isAsc(list)) {
                list = replace(list);
                cnt++;
            }
            return cnt;
        }

        public boolean isAsc(List<Integer> list) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) {
                    return false;
                }
            }
            return true;
        }

        public List<Integer> replace(List<Integer> list) {
            int sum = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                sum = Math.min(sum, list.get(i) + list.get(i - 1));
            }
            boolean isReplaced = false;
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                newList.add(list.get(i));
                if (i > 0 && list.get(i) + list.get(i - 1) == sum && !isReplaced) {
                    newList.remove(newList.size() - 1);
                    newList.set(newList.size() - 1, sum);
                    isReplaced = true;
                }
            }
            return newList;
        }
    }

}
