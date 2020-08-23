package leetcode.contest.week203;

import java.util.ArrayList;
import java.util.List;

public class Test5495_圆形赛道上经过次数最多的扇区 {

    public static void main(String[] args) {
        System.out.println(new Solution().mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(new Solution().mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(new Solution().mostVisited(7, new int[]{1, 3, 5, 7}));
    }

    static class Solution {
        public List<Integer> mostVisited(int n, int[] rounds) {
            int[] stat = new int[n + 1];
            stat[rounds[0]]  = 1;
            for (int i = 1; i < rounds.length; i++) {
                int start = rounds[i - 1] + 1;
                int end = rounds[i];
                if (start <= end) {
                    for (int j = start; j <= end; j++) {
                        stat[j]++;
                    }
                } else {
                    for (int j = start; j <= end + n; j++) {
                        if (j <= n) {
                            stat[j]++;
                        } else {
                            stat[j - n]++;
                        }
                    }
                }
            }
            int max = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int times = stat[i];
                if (times > max) {
                    res.clear();
                    res.add(i);
                    max = times;
                } else if (times == max) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
