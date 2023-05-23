package leetcode.problems;

import java.util.*;

public class Test1090_受标签影响的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestValsFromLabels(
                new int[]{3, 2, 3, 2, 1},
                new int[]{1, 0, 2, 2, 1},
                2,
                1
        ));
    }

    static class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
            for (int i = 0; i < values.length; i++) {
                pq.add(new int[]{values[i], labels[i]});
            }
            int sum = 0;
            int cnt = 0;
            Map<Integer, Integer> takenMap = new HashMap<>();
            while (!pq.isEmpty()){
                // 注意遍历优先队列不能写成for遍历，如for(int[] valueLable : pq)这样结果是不准的
                // 但是可以使用for遍历new ArrayList<>(priorityQueue)
                int[] valueLable = pq.poll();
                int value = valueLable[0];
                int lable = valueLable[1];
                int takenCnt = takenMap.getOrDefault(lable, 0);
                if (takenCnt < useLimit) {
                    sum += value;
                    takenMap.put(lable, takenCnt + 1);
                    cnt++;
                }
                if (cnt == numWanted) {
                    break;
                }
            }
            return sum;
        }
    }
}
