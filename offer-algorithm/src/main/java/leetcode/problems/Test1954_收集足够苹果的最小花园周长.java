package leetcode.problems;

public class Test1954_收集足够苹果的最小花园周长 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPerimeter(1));
        System.out.println(new Solution().minimumPerimeter(13));
        System.out.println(new Solution().minimumPerimeter(1000000000));
    }

    static class Solution {
        public long minimumPerimeter(long neededApples) {
            /*
                对称，只算1/4象限即可
                 678910
                 56789
                 45678
                 34567
                 23456
                 12345
             */
            long need = (neededApples + 3) / 4;
            long sum = 0;
            long side = 0;
            while (sum < need) {
                side++;
                long current = (side + (side+side)) * (side);
                sum += current;
            }
            return 8 * side;
        }
    }

}
