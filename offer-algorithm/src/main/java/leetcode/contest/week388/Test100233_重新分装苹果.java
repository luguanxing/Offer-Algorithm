package leetcode.contest.week388;

import java.util.Arrays;

public class Test100233_重新分装苹果 {

    public static void main(String[] args) {
        // apple = [1,3,2], capacity = [4,3,1,5,2]
        System.out.println(new Solution().minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}));
        // apple = [5,5,5], capacity = [2,4,2,7]
        System.out.println(new Solution().minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7}));
    }

    static class Solution {
        public int minimumBoxes(int[] apple, int[] capacity) {
            int sum = Arrays.stream(apple).sum();
            Arrays.sort(capacity);
            int res = 0;
            int currentCapacity = 0;
            for (int i = capacity.length - 1; i >= 0; i--) {
                currentCapacity += capacity[i];
                res++;
                if (currentCapacity >= sum) {
                    break;
                }
            }
            return res;
        }
    }

}
