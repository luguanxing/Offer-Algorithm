package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0816_模糊坐标 {

    public static void main(String[] args) {
        System.out.println(new Solution().ambiguousCoordinates("(123)"));
        System.out.println(new Solution().ambiguousCoordinates("(00011)"));
        System.out.println(new Solution().ambiguousCoordinates("(0123)"));
        System.out.println(new Solution().ambiguousCoordinates("(100)"));
        System.out.println(new Solution().ambiguousCoordinates("(0010)"));
    }

    static class Solution {
        public List<String> ambiguousCoordinates(String s) {
            s = s.substring(1, s.length() - 1);
            List<String> res = new ArrayList<>();
            for (int i = 1; i < s.length(); i++) {
                String leftS = s.substring(0, i);
                String rightS = s.substring(i);
                for (int l = 1; l <= leftS.length(); l++) {
                    for (int r = 1; r <= rightS.length(); r++) {
                        String left = addPoint(leftS, l);
                        String right = addPoint(rightS, r);
                        if (left != null && right != null) {
                            res.add(String.format("(%s, %s)", left, right));
                        }
                    }
                }
            }
            return res;
        }

        private String addPoint(String s, int pos) {
            if (pos == s.length() && !s.startsWith("00") && !(s.length() > 1 && s.startsWith("0"))) {
                return s;
            }
            String iPart = s.substring(0, pos);
            String fPart = s.substring(pos);
            if (Double.parseDouble("0." + fPart) == 0) {
                return null;
            }
            if (iPart.startsWith("00")) {
                return null;
            }
            if (iPart.length() > 1 && iPart.startsWith("0")) {
                return null;
            }
            if (fPart.endsWith("0")) {
                return null;
            }
            return iPart + "." + fPart;
        }
    }

}
