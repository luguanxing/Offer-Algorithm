package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0401_二进制手表 {

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
        System.out.println(new Solution().readBinaryWatch(9));
    }

    static class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            // 因所有数量较少，直接穷举，无须单独生成小时和分组的组合
            List<String> res = new ArrayList<>();
            for (int hour = 0; hour < 24; hour++) {
                for (int minute = 0; minute < 60; minute++) {
                    int hourCnt = Integer.bitCount(hour);
                    int minuteCnt = Integer.bitCount(minute);
                    if (hour <= 11 && hourCnt <= 4 && minuteCnt <= 6 && hourCnt + minuteCnt == turnedOn) {
                        res.add(hour + ":" + String.format("%02d", minute));
                    }
                }
            }
            return res;
        }
    }

}
