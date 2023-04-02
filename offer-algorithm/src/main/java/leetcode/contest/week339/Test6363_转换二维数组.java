package leetcode.contest.week339;

import java.util.*;

public class Test6363_转换二维数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
        System.out.println(new Solution().findMatrix(new int[]{1, 2, 3, 4}));
    }

    static class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int num : nums) {
                boolean notSet = true;
                for (List<Integer> list : res) {
                    if (!list.contains(num)) {
                        list.add(num);
                        notSet = false;
                        break;
                    }
                }
                if (notSet) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    res.add(list);
                }
            }
            return res;
        }
    }

}
