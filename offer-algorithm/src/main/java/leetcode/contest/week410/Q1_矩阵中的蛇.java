package leetcode.contest.week410;

import java.util.*;

public class Q1_矩阵中的蛇 {

    public static void main(String[] args) {
        // n = 2, commands = ["RIGHT","DOWN"]
        System.out.println(new Solution().finalPositionOfSnake(2, Arrays.asList("RIGHT", "DOWN")));
        // n = 3, commands = ["DOWN","RIGHT","UP"]
        System.out.println(new Solution().finalPositionOfSnake(3, Arrays.asList("DOWN", "RIGHT", "UP")));
    }

    static class Solution {
        public int finalPositionOfSnake(int n, List<String> commands) {
            int y = 0;
            int x = 0;
            for (String command : commands) {
                if (command.equals("UP")) {
                    y--;
                } else if (command.equals("DOWN")) {
                    y++;
                } else if (command.equals("LEFT")) {
                    x--;
                } else if (command.equals("RIGHT")) {
                    x++;
                }
            }
            return y * n + x;
        }
    }

}
