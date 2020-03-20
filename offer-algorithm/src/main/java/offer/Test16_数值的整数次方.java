package offer;

public class Test16_数值的整数次方 {

    public static void main(String[] args){
        System.out.println(new Solution().Power(2, 3));
        System.out.println(new Solution().Power(2, -1));
        System.out.println(new Solution().Power(2, 0));
        System.out.println(new Solution().Power(0, -1));
        System.out.println(new Solution().Power(0, 2));
    }

    static class Solution {
        public double Power(double base, int exponent) {
            if (base == 0) {
                return 0;
            }
            if (exponent == 0) {
                return 1;
            }
            Double result = base;
            for (int i = 1; i < Math.abs(exponent); i++) {
                result = result * base;
            }
            return exponent > 0 ? result : 1 / result;
        }
    }

}
