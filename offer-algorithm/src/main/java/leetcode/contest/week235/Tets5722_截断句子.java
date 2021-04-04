package leetcode.contest.week235;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Tets5722_截断句子 {

    public static void main(String[] args) {
        System.out.println(new Solution().truncateSentence("Hello how are you Contestant", 4));
        System.out.println(new Solution().truncateSentence("What is the solution to this problem", 4));
        System.out.println(new Solution().truncateSentence("chopper is not a tanuki", 5));
    }

    static class Solution {
        public String truncateSentence(String s, int k) {
            String[] array = s.split(" ");
            String[] newArray = Arrays.copyOf(array, k);
            return Arrays.stream(newArray).collect(Collectors.joining(" "));
        }
    }

}
