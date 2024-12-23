package leetcode.problems;

import java.util.*;

public class Test0855_考场就座 {

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        room.seat();
        room.seat();
        room.seat();
        room.seat();
        room.leave(4);
        room.seat();
    }

    static class ExamRoom {
        TreeSet<Integer> set;
        int N;

        public ExamRoom(int n) {
            set = new TreeSet<>();
            N = n;
        }

        public int seat() {
            int pos = 0;
            if (set.size() > 0) {
                Integer last = null;
                // 找开头判断
                int currentMaxD = set.first();
                // 遍历所有学生找所有间隔中的位置
                for (Integer num : set) {
                    if (last != null) {
                        int d = (num - last) / 2;
                        if (d > currentMaxD) {
                            currentMaxD = d;
                            pos = last + d;
                        }
                    }
                    last = num;
                }
                // 找末尾判断
                if (N - 1 - set.last() > currentMaxD) {
                    pos = N - 1;
                }
            }
            set.add(pos);
            return pos;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }

}
