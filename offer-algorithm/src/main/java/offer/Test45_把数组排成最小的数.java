package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test45_把数组排成最小的数 {

    public static void main(String[] args) {
        System.out.println(new Solution().PrintMinNumber(new int[]{3, 32, 321}));
        System.out.println(new Solution().PrintMinNumber(new int[]{3, 5, 1, 4, 2}));
        System.out.println(new Solution().PrintMinNumber(new int[]{3, 323, 32123}));
    }

    static class Solution {
        public String PrintMinNumber(int[] numbers) {
            if (numbers == null) {
                return null;
            }
            List<String> stringList = new ArrayList<>();
            for (int number : numbers) {
                stringList.add(String.valueOf(number));
            }
            // 组成最小：比较先后连接谁更小一些并排好序
            String result = stringList
                    .stream()
                    .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
                    .collect(Collectors.joining());
            return result;
        }
    }

}
