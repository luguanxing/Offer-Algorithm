package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0752_打开转盘锁 {

    public static void main(String[] args) {
        System.out.println(new Solution().openLock(
                new String[]{"0201", "0101", "0102", "1212", "2002"},
                "0202"
        ));
        System.out.println(new Solution().openLock(
                new String[]{"8888"},
                "0009"
        ));
        System.out.println(new Solution().openLock(
                new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"},
                "8888"
        ));
        System.out.println(new Solution().openLock(
                new String[]{"0000"},
                "8888"
        ));
    }

    static class Solution {

        public int openLock(String[] deadends, String target) {
            Set<String> failedSet = Arrays.stream(deadends).collect(Collectors.toSet());
            if (failedSet.contains("0000")) {
                return -1;
            }
            // 使用BFS检查生成taget的最短步数
            Set<String> visitedSet = new HashSet<>();
            Queue<Lock> queue = new ArrayDeque<>();
            queue.add(new Lock("0000", 0));
            visitedSet.add("0000");
            while (!queue.isEmpty()) {
                Lock lock = queue.poll();
                if (target.equals(lock.number)) {
                    return lock.step;
                }
                queue.addAll(lock.getNexts(visitedSet, failedSet));
            }
            return -1;
        }

        static class Lock {
            String number;
            int step;

            public Lock(String number, int step) {
                this.number = number;
                this.step = step;
            }

            public List<Lock> getNexts(Set<String> visitedSet, Set<String> failedSet) {
                List<Lock> next = new ArrayList<>();
                for (char c : getNextNum(number.charAt(0))) {
                    next.add(new Lock(c + number.substring(1), step + 1));
                }
                for (char c : getNextNum(number.charAt(1))) {
                    next.add(new Lock(number.substring(0, 1) + c + number.substring(2), step + 1));
                }
                for (char c : getNextNum(number.charAt(2))) {
                    next.add(new Lock(number.substring(0, 2) + c + number.substring(3), step + 1));
                }
                for (char c : getNextNum(number.charAt(3))) {
                    next.add(new Lock(number.substring(0, 3) + c, step + 1));
                }
                List<Lock> res = new ArrayList<>();
                for (Lock lock : next) {
                    if (visitedSet.contains(lock.number) || failedSet.contains(lock.number)) {
                        continue;
                    } else {
                        // 在这里更新将要判断的点，才能让后面生成的越来越少，否则复杂度降不下来
                        visitedSet.add(lock.number);
                        res.add(lock);
                    }
                }
                return res;
            }

            private char[] getNextNum(char c) {
                if (c == '0') {
                    return new char[]{'9', '1'};
                } else if (c == '9') {
                    return new char[]{'8', '0'};
                } else {
                    return new char[]{(char) (c - 1), (char) (c + 1)};
                }
            }
        }
    }

}
