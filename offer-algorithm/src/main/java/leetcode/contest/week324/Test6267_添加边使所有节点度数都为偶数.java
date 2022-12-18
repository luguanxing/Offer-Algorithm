package leetcode.contest.week324;

import java.util.*;

public class Test6267_添加边使所有节点度数都为偶数 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(5, Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(3, 4),
                Arrays.asList(4, 2),
                Arrays.asList(1, 4),
                Arrays.asList(2, 5)
        )));
        System.out.println(new Solution().isPossible(4, Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        )));
        System.out.println(new Solution().isPossible(4, Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4)
        )));
        System.out.println(new Solution().isPossible(4, Arrays.asList(
                Arrays.asList(4, 1),
                Arrays.asList(3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3)
        )));
        System.out.println(new Solution().isPossible(4, Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 4)
        )));
        System.out.println(new Solution().isPossible(21, Arrays.asList(
                Arrays.asList(2, 19),
                Arrays.asList(16, 17),
                Arrays.asList(8, 14),
                Arrays.asList(2, 16),
                Arrays.asList(12, 20),
                Arrays.asList(12, 14),
                Arrays.asList(16, 18),
                Arrays.asList(15, 16),
                Arrays.asList(10, 21),
                Arrays.asList(3, 5),
                Arrays.asList(13, 18),
                Arrays.asList(17, 20),
                Arrays.asList(14, 17),
                Arrays.asList(9, 12),
                Arrays.asList(5, 15),
                Arrays.asList(5, 6),
                Arrays.asList(3, 7),
                Arrays.asList(2, 21),
                Arrays.asList(10, 13),
                Arrays.asList(8, 16),
                Arrays.asList(7, 18),
                Arrays.asList(4, 6),
                Arrays.asList(9, 1),
                Arrays.asList(13, 21),
                Arrays.asList(18, 20),
                Arrays.asList(7, 14),
                Arrays.asList(4, 19),
                Arrays.asList(5, 8),
                Arrays.asList(3, 11),
                Arrays.asList(11, 1),
                Arrays.asList(7, 12),
                Arrays.asList(4, 7),
                Arrays.asList(3, 16),
                Arrays.asList(13, 17),
                Arrays.asList(17, 19),
                Arrays.asList(9, 13),
                Arrays.asList(7, 19),
                Arrays.asList(10, 16),
                Arrays.asList(4, 13),
                Arrays.asList(4, 5),
                Arrays.asList(2, 15),
                Arrays.asList(12, 19),
                Arrays.asList(11, 16),
                Arrays.asList(2, 9),
                Arrays.asList(11, 17),
                Arrays.asList(17, 1),
                Arrays.asList(16, 21),
                Arrays.asList(4, 10),
                Arrays.asList(10, 14),
                Arrays.asList(14, 16),
                Arrays.asList(4, 1),
                Arrays.asList(13, 20),
                Arrays.asList(5, 20),
                Arrays.asList(4, 14),
                Arrays.asList(4, 21),
                Arrays.asList(10, 20),
                Arrays.asList(2, 14),
                Arrays.asList(8, 15),
                Arrays.asList(4, 8),
                Arrays.asList(6, 19),
                Arrays.asList(15, 1),
                Arrays.asList(19, 1),
                Arrays.asList(8, 19),
                Arrays.asList(15, 21),
                Arrays.asList(3, 12),
                Arrays.asList(11, 18),
                Arrays.asList(9, 17),
                Arrays.asList(18, 19),
                Arrays.asList(7, 21),
                Arrays.asList(3, 21),
                Arrays.asList(16, 19),
                Arrays.asList(11, 15),
                Arrays.asList(5, 1),
                Arrays.asList(8, 17),
                Arrays.asList(3, 15),
                Arrays.asList(8, 1),
                Arrays.asList(10, 19),
                Arrays.asList(3, 8),
                Arrays.asList(6, 16),
                Arrays.asList(2, 8),
                Arrays.asList(5, 18),
                Arrays.asList(11, 13),
                Arrays.asList(11, 20),
                Arrays.asList(14, 21),
                Arrays.asList(6, 20),
                Arrays.asList(4, 20),
                Arrays.asList(12, 13),
                Arrays.asList(5, 12),
                Arrays.asList(10, 11),
                Arrays.asList(9, 15),
                Arrays.asList(3, 19),
                Arrays.asList(9, 20),
                Arrays.asList(14, 18),
                Arrays.asList(21, 1),
                Arrays.asList(13, 19),
                Arrays.asList(8, 21),
                Arrays.asList(2, 13),
                Arrays.asList(3, 10),
                Arrays.asList(9, 18),
                Arrays.asList(19, 21),
                Arrays.asList(6, 7),
                Arrays.asList(3, 18),
                Arrays.asList(2, 18),
                Arrays.asList(6, 14),
                Arrays.asList(3, 17),
                Arrays.asList(5, 21),
                Arrays.asList(14, 20),
                Arrays.asList(8, 9),
                Arrays.asList(16, 1),
                Arrays.asList(3, 4),
                Arrays.asList(13, 1),
                Arrays.asList(5, 9),
                Arrays.asList(4, 15),
                Arrays.asList(17, 21),
                Arrays.asList(20, 21),
                Arrays.asList(2, 17),
                Arrays.asList(13, 14),
                Arrays.asList(11, 14),
                Arrays.asList(9, 16),
                Arrays.asList(10, 18),
                Arrays.asList(6, 15),
                Arrays.asList(6, 12),
                Arrays.asList(3, 13),
                Arrays.asList(5, 11),
                Arrays.asList(6, 1),
                Arrays.asList(12, 17),
                Arrays.asList(8, 10),
                Arrays.asList(5, 10),
                Arrays.asList(8, 18),
                Arrays.asList(4, 12),
                Arrays.asList(10, 1),
                Arrays.asList(6, 13),
                Arrays.asList(4, 18),
                Arrays.asList(7, 20),
                Arrays.asList(7, 16),
                Arrays.asList(2, 6),
                Arrays.asList(12, 21),
                Arrays.asList(4, 17),
                Arrays.asList(15, 18),
                Arrays.asList(13, 16),
                Arrays.asList(15, 20),
                Arrays.asList(7, 10),
                Arrays.asList(6, 10),
                Arrays.asList(2, 20),
                Arrays.asList(7, 15),
                Arrays.asList(18, 1),
                Arrays.asList(12, 1),
                Arrays.asList(3, 20),
                Arrays.asList(7, 1),
                Arrays.asList(14, 15),
                Arrays.asList(4, 9),
                Arrays.asList(11, 19),
                Arrays.asList(7, 9),
                Arrays.asList(5, 17),
                Arrays.asList(18, 21),
                Arrays.asList(6, 21),
                Arrays.asList(8, 11),
                Arrays.asList(6, 17),
                Arrays.asList(3, 14),
                Arrays.asList(7, 11),
                Arrays.asList(5, 7),
                Arrays.asList(7, 13),
                Arrays.asList(6, 8),
                Arrays.asList(6, 9),
                Arrays.asList(10, 12),
                Arrays.asList(5, 16),
                Arrays.asList(2, 4),
                Arrays.asList(17, 18),
                Arrays.asList(9, 11),
                Arrays.asList(12, 16),
                Arrays.asList(3, 6),
                Arrays.asList(12, 18),
                Arrays.asList(3, 9),
                Arrays.asList(11, 12),
                Arrays.asList(14, 19),
                Arrays.asList(10, 15),
                Arrays.asList(5, 13),
                Arrays.asList(8, 13),
                Arrays.asList(15, 17),
                Arrays.asList(2, 10),
                Arrays.asList(11, 21),
                Arrays.asList(20, 1),
                Arrays.asList(6, 18),
                Arrays.asList(2, 12),
                Arrays.asList(19, 20),
                Arrays.asList(6, 11),
                Arrays.asList(8, 12),
                Arrays.asList(2, 3),
                Arrays.asList(12, 15),
                Arrays.asList(2, 11),
                Arrays.asList(9, 10),
                Arrays.asList(7, 17),
                Arrays.asList(9, 19),
                Arrays.asList(13, 15),
                Arrays.asList(7, 8),
                Arrays.asList(4, 11),
                Arrays.asList(2, 5),
                Arrays.asList(5, 19),
                Arrays.asList(16, 20),
                Arrays.asList(15, 19),
                Arrays.asList(9, 14),
                Arrays.asList(14, 1),
                Arrays.asList(10, 17),
                Arrays.asList(9, 21),
                Arrays.asList(2, 7),
                Arrays.asList(8, 20),
                Arrays.asList(5, 14),
                Arrays.asList(4, 16)
        )));
    }

    static class Solution {
        public boolean isPossible(int n, List<List<Integer>> edges) {
            Map<Integer, Set<Integer>> reachMap = new HashMap<>();
            int[] cntMap = new int[n + 1];
            for (List<Integer> edge : edges) {
                int from = edge.get(0);
                int to = edge.get(1);
                cntMap[from]++;
                cntMap[to]++;
                Set<Integer> fromSet = reachMap.getOrDefault(from, new HashSet<>());
                fromSet.add(to);
                reachMap.put(from, fromSet);
                Set<Integer> toSet = reachMap.getOrDefault(to, new HashSet<>());
                toSet.add(from);
                reachMap.put(to, toSet);
            }
            List<Integer> odds = new ArrayList<>();
            for (int node = 1; node < cntMap.length; node++) {
                int cnt = cntMap[node];
                if (cnt % 2 == 1) {
                    odds.add(node);
                }
            }
            if (odds.size() > 4) {
                return false;
            }
            if (odds.size() == 1 || odds.size() == 3) {
                return false;
            }
            if (odds.size() == 0) {
                return true;
            }
            if (odds.size() == 2) {
                int n1 = odds.get(0);
                int n2 = odds.get(1);
                // n1-n2
                if (!reachMap.get(n1).contains(n2)) {
                    return true;
                }
                // n1-nx,nx-n2
                for (int nx = 1; nx <= n; nx++) {
                    if (!reachMap.get(n1).contains(nx) && !reachMap.get(n2).contains(nx)) {
                        return true;
                    }
                }
            }
            if (odds.size() == 4) {
                int n1 = odds.get(0);
                int n2 = odds.get(1);
                int n3 = odds.get(2);
                int n4 = odds.get(3);
                // n1-n2, n3-n4
                if (!reachMap.get(n1).contains(n2) && !reachMap.get(n3).contains(n4)) {
                    return true;
                }
                // n1-n3, n2-n4
                if (!reachMap.get(n1).contains(n3) && !reachMap.get(n2).contains(n4)) {
                    return true;
                }
                // n1-n4, n2-n3
                if (!reachMap.get(n1).contains(n4) && !reachMap.get(n2).contains(n3)) {
                    return true;
                }
            }
            return false;
        }
    }

}
