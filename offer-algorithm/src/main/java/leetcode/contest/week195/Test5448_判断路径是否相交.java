package leetcode.contest.week195;

import java.util.HashSet;
import java.util.Set;

public class Test5448_判断路径是否相交 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPathCrossing("NES"));
        System.out.println(new Solution().isPathCrossing("NESWW"));
    }

    static class Solution {
        public boolean isPathCrossing(String path) {
            int y = 0;
            int x = 0;
            Set<String> set = new HashSet<>();
            set.add("0,0");
            for (Character ch : path.toCharArray()) {
                if (ch == 'N') {
                    y++;
                } else if (ch == 'E') {
                    x++;
                } else if (ch == 'W') {
                    x--;
                } else {
                    y--;
                }
                if (set.contains(y + "," + x)) {
                    return true;
                }
                set.add(y + "," + x);
            }
            return false;
        }
    }

}
