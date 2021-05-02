package leetcode.contest.week239;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test5747_将字符串拆分为递减的连续值 {

    public static void main(String[] args) {
        System.out.println(new Solution().splitString("4321"));
        System.out.println(new Solution().splitString("1234"));
        System.out.println(new Solution().splitString("050043"));
        System.out.println(new Solution().splitString("9080701"));
        System.out.println(new Solution().splitString("4771447713"));
        System.out.println(new Solution().splitString("22759227582275722756"));
    }

    static class Solution {
        private boolean res = false;
        private List<BigInteger> nums = new ArrayList<>();

        public boolean splitString(String s) {
            check(s);
            return res;
        }

        private void check(String s) {
            if (res || (s.isEmpty() && nums.size() > 1)) {
                res = true;
                return;
            }
            for (int i = 1; i <= s.length(); i++) {
                String currentStr = s.substring(0, i);
                BigInteger currentNum = new BigInteger(currentStr);
                if (!nums.isEmpty()) {
                    BigInteger lastOne = nums.get(nums.size() - 1);
                    if (currentNum.equals(lastOne.subtract(new BigInteger("1")))) {
                        nums.add(currentNum);
                        check(s.substring(i));
                        nums.remove(nums.size() - 1);
                    }
                } else {
                    nums.add(currentNum);
                    check(s.substring(i));
                    nums.remove(nums.size() - 1);
                }
            }
        }
    }

}
