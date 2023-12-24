package leetcode.contest.week377;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test100148_最小数字游戏 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numberGame(new int[]{5, 4, 2, 3})));
        System.out.println(Arrays.toString(new Solution().numberGame(new int[]{2, 5})));
    }

        static class Solution {
            public int[] numberGame(int[] nums) {
                int len = nums.length;
                List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
                int[] arr = new int[len];
                int index = 0;
                while (!list.isEmpty()) {
                    Collections.sort(list);
                    arr[index++] = list.get(1);
                    arr[index++] = list.get(0);
                    list.remove(0);
                    list.remove(0);
                }
                return arr;
            }
        }

    }
