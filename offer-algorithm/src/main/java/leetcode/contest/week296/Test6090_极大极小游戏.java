package leetcode.contest.week296;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6090_极大极小游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        System.out.println(new Solution().minMaxGame(new int[]{3}));
    }

    static class Solution {
        public int minMaxGame(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            while (list.size() > 1) {
                List<Integer> newList = new ArrayList<>();
                for (int i = 0; i < list.size() / 2; i++) {
                    if (i % 2 == 0) {
                        newList.add(Math.min(list.get(2 * i), list.get(2 * i + 1)));
                    } else {
                        newList.add(Math.max(list.get(2 * i), list.get(2 * i + 1)));
                    }
                }
                list = newList;
            }
            return list.get(0);
        }
    }

}
