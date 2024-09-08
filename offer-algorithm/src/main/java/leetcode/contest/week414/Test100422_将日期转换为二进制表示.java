package leetcode.contest.week414;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test100422_将日期转换为二进制表示 {

    public static void main(String[] args) {
        System.out.println(new Solution().convertDateToBinary("2080-02-29"));
        System.out.println(new Solution().convertDateToBinary("1900-01-01"));
    }

    static class Solution {
        public String convertDateToBinary(String date) {
            String res;
            String[] infos = date.split("-");
            for (int i = 0; i < infos.length; i++) {
                infos[i] = Integer.toBinaryString(Integer.parseInt(infos[i]));
            }
            return Arrays.stream(infos).collect(Collectors.joining("-"));
        }
    }

}
