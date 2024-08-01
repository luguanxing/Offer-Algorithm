package leetcode.interview;

import java.util.*;
import java.util.stream.IntStream;

public class LCP40_心算挑战 {

    public static void main(String[] args) {
        // cards = [1,2,8,9], cnt = 3
        System.out.println(new Solution().maxmiumScore(new int[]{1, 2, 8, 9}, 3));
        // cards = [3,3,1], cnt = 1
        System.out.println(new Solution().maxmiumScore(new int[]{3, 3, 1}, 1));
        System.out.println(new Solution().maxmiumScore(new int[]{1, 3, 4, 5}, 4));
        System.out.println(new Solution().maxmiumScore(new int[]{3, 4, 5, 3, 4, 10, 7, 4}, 6));
        System.out.println(new Solution().maxmiumScore(new int[]{7, 1, 5, 8, 3, 3, 1, 2}, 7));
        System.out.println(new Solution().maxmiumScore(new int[]{7, 6, 4, 6}, 1));
    }

    static class Solution {
        public int maxmiumScore(int[] cards, int cnt) {
            // 先把前cnt个最大的加起来，若为奇数时偶换奇或者奇换偶（只需要换一次，不是全局）
            cards = IntStream.of(cards)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
            int sum = 0;
            for (int i = 0; i < cnt; i++) {
                sum += cards[i];
            }
            if (sum % 2 == 0) {
                return sum;
            }
            // cnt内的偶换cnt外的奇
            int e1 = -1;
            int o1 = -1;
            for (int i = 0; i < cards.length; i++) {
                if (i < cnt && cards[i] % 2 == 0) {
                    e1 = cards[i];
                }
                if (cnt <= i && cards[i] % 2 == 1) {
                    o1 = cards[i];
                    break;
                }
            }
            int sum1 = 0;
            if (e1 >= 0 && o1 >= 0) {
                sum1 = sum - e1 + o1;
            }
            // cnt内的奇换cnt外的偶
            int o2 = -1;
            int e2 = -1;
            for (int i = 0; i < cards.length; i++) {
                if (i < cnt && cards[i] % 2 == 1) {
                    o2 = cards[i];
                }
                if (cnt <= i && cards[i] % 2 == 0) {
                    e2 = cards[i];
                    break;
                }
            }
            int sum2 = 0;
            if (e2 >= 0 && o2 >= 0) {
                sum2 = sum - o2 + e2;
            }
            return Math.max(sum1, sum2);
        }
    }

    static class Solution_贪心错误 {
        public int maxmiumScore(int[] cards, int cnt) {
            List<Integer> odds = new ArrayList<>();
            List<Integer> evens = new ArrayList<>();
            for (int card : cards) {
                if (card % 2 == 0) {
                    evens.add(card);
                } else {
                    odds.add(card);
                }
            }
            Collections.sort(odds, Collections.reverseOrder());
            Collections.sort(evens, Collections.reverseOrder());
            int res = 0;
            while (cnt > 0) {
                if (cnt == 1) {
                    if (evens.isEmpty()) {
                        break;
                    }
                    res += evens.get(0);
                    cnt -= 1;
                    break;
                }
                // 选两个奇数或者一个偶数
                int n11 = 0;
                if (odds.size() > 1) {
                    n11 = odds.get(0) + odds.get(1);
                }
                int n2 = 0;
                if (!evens.isEmpty()) {
                    n2 = evens.get(0);
                }
                int n22 = 0;
                if (evens.size() > 1) {
                    n22 = evens.get(0) + evens.get(1);
                }
                int[] choices = new int[]{n11, n2, n22};
                Arrays.sort(choices);
                if (choices[2] == n11) {
                    res += n11;
                    odds.remove(0);
                    odds.remove(0);
                    cnt -= 2;
                } else if (choices[2] == n22) {
                    res += n22;
                    evens.remove(0);
                    evens.remove(0);
                    cnt -= 2;
                } else {
                    res += n2;
                    evens.remove(0);
                    cnt -= 1;
                }
            }
            return cnt == 0 ? res : 0;
        }
    }

}
