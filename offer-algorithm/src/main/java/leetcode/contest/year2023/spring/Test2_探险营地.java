package leetcode.contest.year2023.spring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2_探险营地 {

    public static void main(String[] args) {
        System.out.println(new Solution().adventureCamp(new String[]{"leet->code", "leet->code->Campsite->Leet", "leet->code->leet->courier"}));
        System.out.println(new Solution().adventureCamp(new String[]{"Alice->Dex", "", "Dex"}));
        System.out.println(new Solution().adventureCamp(new String[]{"", "Gryffindor->Slytherin->Gryffindor", "Hogwarts->Hufflepuff->Ravenclaw"}));
        System.out.println(new Solution().adventureCamp(new String[]{"xO->xO->xO", "xO->BKbWDH", "xO->BKbWDH", "BKbWDH->mWXW", "LSAYWW->LSAYWW", "oAibBvPdJ", "LSAYWW->u", "LSAYWW->LSAYWW"}));
    }

    static class Solution {
        public int adventureCamp(String[] expeditions) {
            Set<String> visited = new HashSet<>();
            if (!expeditions[0].isEmpty()) {
                visited.addAll(Arrays.asList(expeditions[0].split("->")));
            }
            int res = -1;
            int maxCnt = 0;
            Set<String> currentVisited = new HashSet<>();
            for (int i = 1; i < expeditions.length; i++) {
                String expedition = expeditions[i];
                if (expedition.isEmpty()) {
                    continue;
                }
                int cnt = 0;
                for (String v : expedition.split("->")) {
                    if (!visited.contains(v) && !currentVisited.contains(v)) {
                        currentVisited.add(v);
                        cnt++;
                    }
                }
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    res = i;
                }
            }
            return res;
        }
    }

}
