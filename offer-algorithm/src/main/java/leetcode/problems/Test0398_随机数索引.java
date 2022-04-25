package leetcode.problems;

import java.util.*;

public class Test0398_随机数索引 {

    public static void main(String[] args) {

    }

    static class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    list.add(i);
                }
            }
            return list.get(new Random().nextInt(list.size()));
        }
    }

    static class Solution_Map {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public Solution_Map(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                list.add(i);
                map.put(num, list);
            }
        }

        public int pick(int target) {
            List<Integer> indexs = map.get(target);
            return indexs.get(new Random().nextInt(indexs.size()));
        }
    }

}
