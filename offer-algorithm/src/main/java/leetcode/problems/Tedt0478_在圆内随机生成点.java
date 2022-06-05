package leetcode.problems;

import java.util.Arrays;
import java.util.Random;

public class Tedt0478_在圆内随机生成点 {

    public static void main(String[] args) {
        Solution solution = new Solution(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(solution.randPoint()));//返回[-0.02493，-0.38077]
        System.out.println(Arrays.toString(solution.randPoint()));//返回[0.82314,0.38945]
        System.out.println(Arrays.toString(solution.randPoint()));//返回[0.36572,0.17248]
    }

    static class Solution {
        double x, y, r;

        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            while (true) {
                double deltaX = new Random().nextDouble() * 2 * r - r;
                double deltaY = new Random().nextDouble() * 2 * r - r;
                if (deltaX * deltaX + deltaY * deltaY > r * r) {
                    continue;
                }
                return new double[]{x + deltaX, y + deltaY};
            }
        }
    }

}
