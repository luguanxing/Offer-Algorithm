package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1670_设计前中后队列 {

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        System.out.println(q.list);
        q.pushBack(2);    // [1, 2]
        System.out.println(q.list);
        q.pushMiddle(3);  // [1, 3, 2]
        System.out.println(q.list);
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.list);
        q.popFront();     // 返回 1 -> [4, 3, 2]
        System.out.println(q.list);
        q.popMiddle();    // 返回 3 -> [4, 2]
        System.out.println(q.list);
        q.popMiddle();    // 返回 4 -> [2]
        System.out.println(q.list);
        q.popBack();      // 返回 2 -> []
        System.out.println(q.list);
        q.popFront();     // 返回 -1 -> [] （队列为空）
        System.out.println(q.list);
    }

    static class FrontMiddleBackQueue {
        List<Integer> list;

        public FrontMiddleBackQueue() {
            list = new ArrayList<>();
        }

        public void pushFront(int val) {
            list.add(0, val);
        }

        public void pushMiddle(int val) {
            int size = list.size();
            list.add(size / 2, val);
        }

        public void pushBack(int val) {
            list.add(val);
        }

        public int popFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(0);
        }

        public int popMiddle() {
            if (list.isEmpty()) {
                return -1;
            }
            int size = list.size();
            return list.remove((size - 1) / 2);
        }

        public int popBack() {
            if (list.isEmpty()) {
                return -1;
            }
            int size = list.size();
            return list.remove(size - 1);
        }
    }

}
