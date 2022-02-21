package leetcode.problems;

import java.util.TreeSet;

public class Test0838_推多米诺 {

    public static void main(String[] args) {
        System.out.println(new Solution().pushDominoes("RR.L"));
        System.out.println(new Solution().pushDominoes(".L.R...LR..L.."));
    }

    static class Solution {
        public String pushDominoes(String dominoes) {
            // 计算左推和右推的下标
            int len = dominoes.length();
            TreeSet<Integer> lefts = new TreeSet<>();
            TreeSet<Integer> rights = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                if (dominoes.charAt(i) == 'L') {
                    lefts.add(i);
                }
                if (dominoes.charAt(i) == 'R') {
                    rights.add(i);
                }
            }
            // 看每个空点右侧的的左推和左侧的右推
            char[] res = new char[len];
            for (int i = 0; i < len; i++) {
                if (dominoes.charAt(i) != '.') {
                    res[i] = dominoes.charAt(i);
                } else {
                    int leftL = lefts.lower(i) == null ? Integer.MIN_VALUE : lefts.lower(i);
                    int leftR = rights.lower(i) == null ? Integer.MIN_VALUE : rights.lower(i);
                    int rightL = lefts.higher(i) == null ? Integer.MAX_VALUE : lefts.higher(i);
                    int rightR = rights.higher(i) == null ? Integer.MAX_VALUE : rights.higher(i);
                    // 关注右leftR和rightL
                    int distanceOfLeftR = Integer.MAX_VALUE;
                    int distanceOfRightL = Integer.MAX_VALUE;
                    if (leftR > leftL) {
                        distanceOfLeftR = i - leftR;
                    }
                    if (rightL < rightR) {
                        distanceOfRightL = rightL - i;
                    }
                    if (distanceOfLeftR < distanceOfRightL) {
                        res[i] = 'R';
                    } else if (distanceOfLeftR > distanceOfRightL) {
                        res[i] = 'L';
                    } else {
                        res[i] = '.';
                    }
                }
            }
            return new String(res);
        }
    }

}
