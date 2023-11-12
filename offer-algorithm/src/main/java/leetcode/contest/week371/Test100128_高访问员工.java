package leetcode.contest.week371;

import java.util.*;

public class Test100128_高访问员工 {

    public static void main(String[] args) {
        // access_times = [["a","0549"],["b","0457"],["a","0532"],["a","0621"],["b","0540"]]
        System.out.println(new Solution().findHighAccessEmployees(Arrays.asList(
                Arrays.asList("a", "0549"),
                Arrays.asList("b", "0457"),
                Arrays.asList("a", "0532"),
                Arrays.asList("a", "0621"),
                Arrays.asList("b", "0540")
        )));
        // access_times = [["d","0002"],["c","0808"],["c","0829"],["e","0215"],["d","1508"],["d","1444"],["d","1410"],["c","0809"]]
        System.out.println(new Solution().findHighAccessEmployees(Arrays.asList(
                Arrays.asList("d", "0002"),
                Arrays.asList("c", "0808"),
                Arrays.asList("c", "0829"),
                Arrays.asList("e", "0215"),
                Arrays.asList("d", "1508"),
                Arrays.asList("d", "1444"),
                Arrays.asList("d", "1410"),
                Arrays.asList("c", "0809")
        )));
        // access_times = [["cd","1025"],["ab","1025"],["cd","1046"],["cd","1055"],["ab","1124"],["ab","1120"]]
        System.out.println(new Solution().findHighAccessEmployees(Arrays.asList(
                Arrays.asList("cd", "1025"),
                Arrays.asList("ab", "1025"),
                Arrays.asList("cd", "1046"),
                Arrays.asList("cd", "1055"),
                Arrays.asList("ab", "1124"),
                Arrays.asList("ab", "1120")
        )));
        // [["akuhmu","0454"],["aywtqh","0523"],["akuhmu","0518"],["ihhkc","0439"],["ihhkc","0508"],["akuhmu","0529"],["aywtqh","0530"],["aywtqh","0419"]]
        System.out.println(new Solution().findHighAccessEmployees(Arrays.asList(
                Arrays.asList("akuhmu", "0454"),
                Arrays.asList("aywtqh", "0523"),
                Arrays.asList("akuhmu", "0518"),
                Arrays.asList("ihhkc", "0439"),
                Arrays.asList("ihhkc", "0508"),
                Arrays.asList("akuhmu", "0529"),
                Arrays.asList("aywtqh", "0530"),
                Arrays.asList("aywtqh", "0419")
        )));
    }

    static class Solution {
        public List<String> findHighAccessEmployees(List<List<String>> access_times) {
            Map<String, List<String>> map = new HashMap<>();
            for (List<String> access_time : access_times) {
                String name = access_time.get(0);
                String time = access_time.get(1);
                List<String> list = map.getOrDefault(name, new ArrayList<>());
                list.add(time);
                map.put(name, list);
            }
            for (List<String> times : map.values()) {
                Collections.sort(times);
            }
            List<String> list = new ArrayList<>();
            for (String name : map.keySet()) {
                List<String> times = map.get(name);
                for (int i = 0; i < times.size() - 2; i++) {
                    if (inOneHour(times.get(i), times.get(i + 2))) {
                        list.add(name);
                        break;
                    }
                }
            }
            return list;
        }

        private boolean inOneHour(String s1, String s2) {
            int m1 = Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(2));
            int m2 = Integer.parseInt(s2.substring(0, 2)) * 60 + Integer.parseInt(s2.substring(2));
            return m2 - m1 < 60;
        }
    }

}
