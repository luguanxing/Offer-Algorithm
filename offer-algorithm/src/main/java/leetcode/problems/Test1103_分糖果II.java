package leetcode.problems;

import java.util.Arrays;

public class Test1103_分糖果II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().distributeCandies(7, 4)));
        System.out.println(Arrays.toString(new Solution().distributeCandies(10, 3)));
    }

    static class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int index = 1;
            int[] res = new int[num_people];
            while (candies > 0) {
                if (index < candies) {
                    // 当前的人可拿走足够的糖
                    res[(index - 1) % num_people] += index;
                    candies -= index;
                    index++;
                } else {
                    // 最后一人拿完剩下的糖
                    res[(index - 1) % num_people] += candies;
                    candies = 0;
                }
            }
            return res;
        }
    }

}
