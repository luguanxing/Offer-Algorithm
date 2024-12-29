package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test1366_通过投票对团队排名 {

    public static void main(String[] args) {
        System.out.println(new Solution().rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        System.out.println(new Solution().rankTeams(new String[]{"WXYZ", "XYZW"}));
        System.out.println(new Solution().rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
    }

    static class Solution {
        public String rankTeams(String[] votes) {
            int rankSize = votes[0].length();
            Map<Character, int[]> infoMap = new HashMap<>();
            for (String vote : votes) {
                for (int i = 0; i < rankSize; i++) {
                    char team = vote.charAt(i);
                    int[] info = infoMap.getOrDefault(team, new int[rankSize]);
                    info[i]++;
                    infoMap.put(team, info);
                }
            }
            Pair[] pairs = new Pair[rankSize];
            int idx = 0;
            for (char team : infoMap.keySet()) {
                pairs[idx++] = new Pair(team, infoMap.get(team));
            }
            Arrays.sort(pairs, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    for (int i = 0; i < rankSize; i++) {
                        if (p1.info[i] != p2.info[i]) {
                            return p2.info[i] - p1.info[i];
                        }
                    }
                    return p1.team - p2.team;
                }
            });
            return Arrays.stream(pairs).map(p -> String.valueOf(p.team)).collect(Collectors.joining());
        }

        class Pair {
            Character team;
            int[] info;
            Pair(Character team, int[] info) {
                this.team = team;
                this.info = info;
            }
        }
    }

}
