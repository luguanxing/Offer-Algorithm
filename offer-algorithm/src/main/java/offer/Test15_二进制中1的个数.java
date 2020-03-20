package offer;

public class Test15_二进制中1的个数 {

    public static void main(String[] args) {
        int num1 = 0x80000000;
        int num2 = 0x70000000;
        int num3 = -1;
        System.out.println(new Solution_去掉右边1().NumberOf1(num1));
        System.out.println(new Solution_去掉右边1().NumberOf1(num2));
        System.out.println(new Solution_去掉右边1().NumberOf1(num3));
    }

    static class Solution {
        public int NumberOf1(int n) {
            int flag = 1;
            int count = 0;
            for (int i = 1; i <= 32; i++) {
                count += (flag & n) > 0 ? 1 : 0;
                flag <<= 1;
            }
            return n >= 0 ? count : count + 1;
        }
    }

    static class Solution_去掉右边1 {
        public int NumberOf1(int n) {
            int count = 0;
            while (n != 0) {
                n &= n - 1;
                count++;
            }
            return n >= 0 ? count : count + 1;
        }
    }

}
