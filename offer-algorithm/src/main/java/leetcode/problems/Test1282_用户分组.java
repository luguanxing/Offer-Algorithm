package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1282_用户分组 {

    public static void main(String[] args) {
        System.out.println(new Solution().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(new Solution().groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }

    static class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            // 按groupSize分组
            Map<Integer, List<Integer>> groupSizeMap = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                int groupSize = groupSizes[i];
                List<Integer> list = groupSizeMap.getOrDefault(groupSize, new ArrayList<>());
                list.add(i);
                groupSizeMap.put(groupSize, list);
            }
            // 构建划分结果
            List<List<Integer>> result = new ArrayList<>();
            for (int groupSize : groupSizeMap.keySet()) {
                List<Integer> list = groupSizeMap.get(groupSize);
                for (int i = 1; i <= list.size() / groupSize; i++) {
                    result.add(list.subList((i - 1) * groupSize, i * groupSize));
                }
            }
            return result;
        }
    }

}
