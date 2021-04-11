package leetcode.contest.week236;

import java.util.ArrayList;
import java.util.List;

public class Test5727_找出游戏的获胜者 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheWinner(5, 2));
        System.out.println(new Solution().findTheWinner(6, 5));
        System.out.println(new Solution().findTheWinner(3, 1));
    }

    static class Solution {
        public int findTheWinner(int n, int k) {
            if (k == 1) {
                return n;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int index = 0;
            int cnt = 1;
            while (list.size() > 1) {
                cnt++;
                index++;
                if (index % list.size() == 0) {
                    index = 0;
                }
                if (cnt % k == 0) {
                    list.remove(index);
                    index--;
                }
            }
            return list.get(0);
        }
    }

}
