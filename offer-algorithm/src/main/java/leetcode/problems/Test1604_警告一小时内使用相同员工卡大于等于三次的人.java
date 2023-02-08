package leetcode.problems;

import java.util.*;

public class Test1604_警告一小时内使用相同员工卡大于等于三次的人 {

    public static void main(String[] args) {
        System.out.println(new Solution().alertNames(
                new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
                new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}
        ));
        System.out.println(new Solution().alertNames(
                new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"},
                new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}
        ));
        System.out.println(new Solution().alertNames(
                new String[]{"john", "john", "john"},
                new String[]{"23:58", "23:59", "00:01"}
        ));
        System.out.println(new Solution().alertNames(
                new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"},
                new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}
        ));
    }

    static class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            int len = keyName.length;
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                String name = keyName[i];
                String time = keyTime[i];
                int ts = parseTime(time);
                List<Integer> list = map.getOrDefault(name, new ArrayList<>());
                list.add(ts);
                map.put(name, list);
            }
            List<String> res = new ArrayList<>();
            for (String name : map.keySet()) {
                List<Integer> list = map.get(name);
                Collections.sort(list);
                for (int i = 2; i < list.size(); i++) {
                    if (list.get(i) - list.get(i - 2) <= 60) {
                        res.add(name);
                        break;
                    }
                }
            }
            Collections.sort(res);
            return res;
        }

        private int parseTime(String time) {
            String[] infos = time.split(":");
            return Integer.parseInt(infos[0]) * 60 + Integer.parseInt(infos[1]);
        }
    }

}
