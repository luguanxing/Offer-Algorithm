package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class Test05_02_二进制数转字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().printBin(0.625));
        System.out.println(new Solution().printBin(0.1));
    }

    static class Solution {
        public String printBin(double num) {
            List<Double> list = new ArrayList<>();
            double d = 0.5;
            while (String.valueOf(d).length() - 2 <= 6) {
                list.add(d);
                d = d * 0.5;
            }
            String res = "0.";
            for (double p : list) {
                if (num >= p) {
                    num -= p;
                    res += "1";
                    if (num == 0) {
                        break;
                    }
                } else {
                    res += "0";
                }
            }
            return num == 0 ? res : "ERROR";
        }
    }

}
