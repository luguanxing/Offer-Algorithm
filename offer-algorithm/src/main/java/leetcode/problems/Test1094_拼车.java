package leetcode.problems;

public class Test1094_拼车 {

    public static void main(String[] args) {
        // trips = [[2,1,5],[3,3,7]], capacity = 4
        System.out.println(new Solution().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        // trips = [[2,1,5],[3,3,7]], capacity = 5
        System.out.println(new Solution().carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }

    /*
        车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
        给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi]
        表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
        当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
     */
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int MAX = 1005;
            int[] road = new int[MAX];
            for (int[] trip : trips) {
                int num = trip[0];
                int start = trip[1];
                int end = trip[2];
                road[start] += num;
                road[end] -= num;
            }
            int current = 0;
            for (int i = 0; i < MAX; i++) {
                current += road[i];
                if (current > capacity) {
                    return false;
                }
            }
            return true;
        }
    }

}
