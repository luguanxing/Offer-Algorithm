package leetcode.contest.week283;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test6019_替换数组中的非互质数 {

    public static void main(String[] args) {
        System.out.println(new Solution().replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}));
        System.out.println(new Solution().replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3}));
        System.out.println(new Solution().replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561}));
        System.out.println(new Solution().replaceNonCoprimes(new int[]{287, 41, 49, 287, 899, 23, 23, 20677, 5, 825}));
    }

    static class Solution {
        Map<String, Integer> gcdMap = new HashMap<>();

        public List<Integer> replaceNonCoprimes(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int index = 0;
            while (index + 1 < list.size()) {
                int current = list.get(index);
                int next = list.get(index + 1);
                int gcd = gcd(current, next);
                if (gcd > 1) {
                    long lcm = ((long) current * next) / gcd;
                    list.remove(index);
                    list.remove(index);
                    list.add(index, (int) lcm);
                    if (index - 1 >= 0 && gcd(list.get(index), list.get(index - 1)) > 1) {
                        index--;
                    }
                } else {
                    index++;
                }
            }
            return list;
        }

        private int gcd(int a, int b) {
            if (gcdMap.containsKey(a + "," + b)) {
                return gcdMap.get(a + "," + b);
            }
            if (b == 0) {
                return a;
            } else {
                int gcd = gcd(b, a % b);
                gcdMap.put(a + "," + b, gcd);
                return gcd;
            }
        }
    }

}
