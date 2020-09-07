package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0347_前K个高频元素 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{1, 2}, 2)));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numMap = new HashMap<>();
            for (int num : nums) {
                numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            }
            List<Integer> numList = numMap.keySet().stream().collect(Collectors.toList());
            List<Integer> cntList = numMap.values().stream().collect(Collectors.toList());
            for (int i = 0; i < cntList.size(); i++) {
                for (int j = i + 1; j < cntList.size(); j++) {
                    if (cntList.get(i) < cntList.get(j)) {
                        int tmp = cntList.get(i);
                        cntList.set(i, cntList.get(j));
                        cntList.set(j, tmp);
                        tmp = numList.get(i);
                        numList.set(i, numList.get(j));
                        numList.set(j, tmp);
                    }
                }
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = numList.get(i);
            }
            return res;
        }
    }

}
