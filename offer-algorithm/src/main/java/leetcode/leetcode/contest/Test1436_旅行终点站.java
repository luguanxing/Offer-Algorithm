package leetcode.leetcode.contest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1436_旅行终点站 {

    public static void main(String[] args) {
        List<String> list2 = Stream.of("New York", "Lima").collect(Collectors.toList());
        List<String> list1 = Stream.of("London", "New York").collect(Collectors.toList());
        List<String> list3 = Stream.of("Lima", "Sao Paulo").collect(Collectors.toList());
        List<List<String>> lists = Stream.of(list1, list2, list3).collect(Collectors.toList());
        System.out.println(new Solution().destCity(lists));
    }

    static class Solution {
        public String destCity(List<List<String>> paths) {
            Map<String, String> map = new HashMap<>();
            paths.forEach(kvs -> map.put(kvs.get(0), kvs.get(1)));
            // 找出不为起点的城市
            return map.values()
                    .stream()
                    .filter(v -> !map.containsKey(v))
                    .findFirst()
                    .orElse(null);
        }
    }

}
