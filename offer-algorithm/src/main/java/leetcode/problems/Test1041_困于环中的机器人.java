package leetcode.problems;

public class Test1041_困于环中的机器人 {

    public static void main(String[] args) {
        System.out.println(new Solution().isRobotBounded("GGLLGG"));
        System.out.println(new Solution().isRobotBounded("GG"));
        System.out.println(new Solution().isRobotBounded("GL"));
        System.out.println(new Solution().isRobotBounded("GLRLLGLL"));
        System.out.println(new Solution().isRobotBounded("RGL"));
    }

    static class Solution {
        public boolean isRobotBounded(String instructions) {
            // position = [y,x,d]
            int[] pos = new int[]{0, 0, 0};
            for (char c : instructions.toCharArray()) {
                if (c == 'L') {
                    pos[2]++;
                    pos[2] %= 4;
                } else if (c == 'R') {
                    pos[2]--;
                    pos[2] += 4;
                    pos[2] %= 4;
                } else {
                    switch (pos[2]) {
                        case 0:
                            pos[1]++;
                            break;
                        case 1:
                            pos[0]--;
                            break;
                        case 2:
                            pos[1]--;
                            break;
                        case 3:
                            pos[0]++;
                            break;
                    }
                }
            }
            // 走完后在原点或者不向上说明会循环，只有相对原点向上走一圈后继续向上才可以（可新建坐标系参考）
            if (pos[0] == 0 && pos[1] == 0) {
                return true;
            }
            if (pos[2] != 0) {
                return true;
            }
            return false;
        }
    }

}
