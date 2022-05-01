package leetcode.contest.week291;

import java.util.HashMap;
import java.util.Map;

public class Test6048_必须拿起的最小连续卡牌数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(new Solution().minimumCardPickup(new int[]{1, 0, 5, 3}));
        System.out.println(new Solution().minimumCardPickup(new int[]{70, 37, 70, 41, 1, 62, 71, 49, 38, 50, 29, 76, 29, 41, 22, 66, 88, 18, 85, 53}));
        System.out.println(new Solution().minimumCardPickup(new int[]{70, 37, 70, 41, 1, 62, 71, 49, 38, 50, 29, 76, 29, 41, 22, 66, 88, 18, 85, 53}));
    }

    static class Solution {
        public int minimumCardPickup(int[] cards) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < cards.length; i++) {
                int card = cards[i];
                if (indexMap.containsKey(card)) {
                    int lastIndex = indexMap.get(card);
                    res = Math.min(res, i - lastIndex + 1);
                }
                indexMap.put(card, i);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

}
