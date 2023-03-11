package leetcode.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test17_05_字母与数字 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findLongestSubarray(new String[]{
                "A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"
        })));
        System.out.println(Arrays.toString(new Solution().findLongestSubarray(new String[]{
                "A", "A"
        })));
        System.out.println(Arrays.toString(new Solution().findLongestSubarray(new String[]{
                "A", "A", "A", "1", "B", "2", "C", "3", "D"
        })));
    }

    static class Solution {
        public String[] findLongestSubarray(String[] array) {
            Map<Integer, Integer> countIndexMap = new HashMap<>();
            countIndexMap.put(0, 0);
            String[] res = new String[]{};
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                // 计算当前字符和数字的差值
                char c = array[i].charAt(0);
                if (Character.isAlphabetic(c)) {
                    count++;
                } else {
                    count--;
                }
                // 查看相同差值的最远位置和当前的位置的距离
                if (countIndexMap.containsKey(count)) {
                    int len = i - countIndexMap.get(count);
                    if (len > res.length) {
                        res = Arrays.copyOfRange(array, countIndexMap.get(count), i + 1);
                    }
                }
                // 记录当前字符和数字的差值的位置，如果之前出现过则忽略
                countIndexMap.put(count, countIndexMap.getOrDefault(count, i + 1));
            }
            return res;
        }
    }

}
