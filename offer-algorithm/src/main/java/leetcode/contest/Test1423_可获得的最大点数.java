package leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1423_可获得的最大点数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        System.out.println(new Solution().maxScore(new int[]{1, 6, 5, 4, 3, 2, 1}, 3));
    }

    static class Solution {
        public int maxScore(int[] cardPoints, int k) {
            // 换个思路，找中间连续n-k个数和最小片段
            int totalSum = 0;
            for (int num : cardPoints) {
                totalSum += num;
            }
            int nkSum = 0;
            for (int i = 0; i < cardPoints.length - k; i++) {
                nkSum += cardPoints[i];
            }
            int minK = nkSum;
            for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
                nkSum -= cardPoints[i - (cardPoints.length - k)];
                nkSum += cardPoints[i];
                minK = Math.min(minK, nkSum);
            }
            return totalSum - minK;
        }
    }

    static class Solution_暴力 {
        List<Integer> sumList = new ArrayList<>();

        public int maxScore(int[] cardPoints, int k) {
            // 枚举所有情况，找出最大值
            dfsCheck(cardPoints, 0, cardPoints.length - 1, k, 0);
            Collections.sort(sumList);
            return sumList.get(sumList.size() - 1);
        }

        public void dfsCheck(int[] cardPoints, int left, int right, int leftK, int currentSum) {
            if (leftK == 0) {
                sumList.add(currentSum);
                return;
            }
            dfsCheck(cardPoints, left + 1, right, leftK - 1, currentSum + cardPoints[left]);
            dfsCheck(cardPoints, left, right - 1, leftK - 1, currentSum + cardPoints[right]);
        }
    }

}
