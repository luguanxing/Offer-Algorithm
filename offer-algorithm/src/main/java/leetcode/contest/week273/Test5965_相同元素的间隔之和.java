package leetcode.contest.week273;

import utils.FileReader;

import java.util.*;

public class Test5965_相同元素的间隔之和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{10, 5, 10, 10})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{10, 10, 10})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{1, 1})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{1})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{})));
        System.out.println(Arrays.toString(new Solution().getDistances(new int[]{5, 5, 1, 5, 5, 5})));
        String line = FileReader.readLine("/Users/luguanxing/1");
        String[] strs = line.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(Arrays.toString(new Solution().getDistances(nums)));
    }

    static class Solution {
        public long[] getDistances(int[] arr) {
            // 记录每个数出现的下标
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                list.add(i);
                map.put(num, list);
            }
            // 计算前缀和
            Map<Integer, List<Long>> sumMap = new HashMap<>();
            for (int num : map.keySet()) {
                List<Integer> list = map.get(num);
                List<Long> sumList = new ArrayList<>();
                long sum = 0;
                for (int index : list) {
                    sum += index;
                    sumList.add(sum);
                }
                sumMap.put(num, sumList);
            }
            // 计算下标绝对值差的和
            long[] res = new long[arr.length];
            for (int i = 0; i < arr.length; i++) {
                long sum = 0;
                List<Integer> list = map.get(arr[i]);
                List<Long> sumList = sumMap.get(arr[i]);
                int pos = Collections.binarySearch(list, i);
                // 小于i的部分，注意中间结果需要转long
                sum += (long)(pos + 1) * i - sumList.get(pos);
                // 大于i的部分，注意中间结果需要转long
                sum += sumList.get(sumList.size() - 1) - sumList.get(pos) - (long)(sumList.size() - pos - 1) * i;
                res[i] = sum;
            }
            return res;
        }
    }

    static class Solution_TLE {
        public long[] getDistances(int[] arr) {
            // 记录每个数出现的下标
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                List<Integer> list = map.getOrDefault(num, new ArrayList<>());
                list.add(i);
                map.put(num, list);
            }
            // 计算下标绝对值差的和
            long[] res = new long[arr.length];
            for (int i = 0; i < arr.length; i++) {
                long sum = 0;
                for (int index : map.get(arr[i])) {
                    sum += Math.abs(i - index);
                }
                res[i] = sum;
            }
            return res;
        }
    }

}
