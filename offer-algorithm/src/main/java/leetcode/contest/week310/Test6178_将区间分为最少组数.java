package leetcode.contest.week310;

public class Test6178_将区间分为最少组数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minGroups(new int[][]{
                {5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}
        }));
        System.out.println(new Solution().minGroups(new int[][]{
                {1, 3}, {5, 6}, {8, 10}, {11, 13}
        }));
        System.out.println(new Solution().minGroups(new int[][]{
                {351436, 933571}, {667214, 975379}, {782454, 919174}, {231661, 764081}, {848495, 902497}, {332817, 520328}, {740795, 762394}, {665739, 726786}, {546865, 686588}, {360501, 846864}
        }));
        System.out.println(new Solution().minGroups(new int[][]{
                {441459, 446342}, {801308, 840640}, {871890, 963447}, {228525, 336985}, {807945, 946787}, {479815, 507766}, {693292, 944029}, {751962, 821744}
        }));
    }

    static class Solution {
        public int minGroups(int[][] intervals) {
            // 找重叠最厉害的区间
            int MAX = 1000005;
            int[] diff = new int[MAX];
            for (int interval[] : intervals) {
                int start = interval[0];
                int end = interval[1];
                diff[start]++;
                diff[end+1]--;
            }
            int max = 0;
            int currentSum = 0;
            for (int i = 0; i < MAX; i++) {
                currentSum += diff[i];
                max = Math.max(max, currentSum);
            }
            return max;
        }
    }

}
