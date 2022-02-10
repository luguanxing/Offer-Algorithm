package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1447_最简分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().simplifiedFractions(1));
        System.out.println(new Solution().simplifiedFractions(2));
        System.out.println(new Solution().simplifiedFractions(3));
        System.out.println(new Solution().simplifiedFractions(4));
    }

    static class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> res = new ArrayList<>();
            for (int fm = 1; fm <= n; fm++) {
                for (int fz = 1; fz < fm; fz++) {
                    if (isOk(fz, fm)) {
                        res.add(fz + "/" + fm);
                    }
                }
            }
            return res;
        }

        private boolean isOk(int fz, int fm) {
            for (int i = 2; i <= fz; i++) {
                if (fz % i == 0 && fm % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
