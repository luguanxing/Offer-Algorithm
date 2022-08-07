package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test0636_函数的独占时间 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().exclusiveTime(
                        2,
                        Arrays.stream(new String[]{
                                "0:start:0", "1:start:2", "1:end:5", "0:end:6"
                        }).collect(Collectors.toList())
                )
        ));
        System.out.println(Arrays.toString(
                new Solution().exclusiveTime(
                        1,
                        Arrays.stream(new String[]{
                                "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"
                        }).collect(Collectors.toList())
                )
        ));
        System.out.println(Arrays.toString(
                new Solution().exclusiveTime(
                        2,
                        Arrays.stream(new String[]{
                                "0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"
                        }).collect(Collectors.toList())
                )
        ));
        System.out.println(Arrays.toString(
                new Solution().exclusiveTime(
                        2,
                        Arrays.stream(new String[]{
                                "0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8"
                        }).collect(Collectors.toList())
                )
        ));
        System.out.println(Arrays.toString(
                new Solution().exclusiveTime(
                        1,
                        Arrays.stream(new String[]{
                                "0:start:0", "0:end:0"
                        }).collect(Collectors.toList())
                )
        ));
    }

    static class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            Stack<Integer> stack = new Stack<>();
            int[] stat = new int[n];
            int lastId = -1;
            int lastTs = 0;
            for (String log : logs) {
                int id = Integer.parseInt(log.split(":")[0]);
                int ts = Integer.parseInt(log.split(":")[2]);
                String action = log.split(":")[1];
                if (action.equals("start")) {
                    if (lastId != -1) {
                        stat[lastId] += ts - lastTs;
                    }
                    lastId = id;
                    lastTs = ts;
                    stack.add(id);
                } else if (action.equals("end")) {
                    stat[id] += ts - lastTs + 1;
                    stack.pop();
                    lastId = stack.isEmpty() ? -1 : stack.peek();
                    lastTs = ts + 1;
                }
            }
            return stat;
        }
    }

}
