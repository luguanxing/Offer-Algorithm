package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1390_四因数 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumFourDivisors(new int[]{21, 4, 7}));
        System.out.println(new Solution().sumFourDivisors(new int[]{21, 21}));
        System.out.println(new Solution().sumFourDivisors(new int[]{1, 2, 3, 4, 5}));
    }

    static class Solution {
        public int sumFourDivisors(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += getSumOfFourDivisors(num);
            }
            return sum;
        }

        private int getSumOfFourDivisors(int num) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    list.add(i);
                    if (i != num / i) {
                        list.add(num / i);
                    }
                }
                if (list.size() > 4) {
                    break;
                }
            }
            return list.size() == 4 ? list.stream().reduce(0, Integer::sum) : 0;
        }
    }

}
