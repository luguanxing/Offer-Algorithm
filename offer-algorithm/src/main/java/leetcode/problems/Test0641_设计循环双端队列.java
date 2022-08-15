package leetcode.problems;

public class Test0641_设计循环双端队列 {

    public static void main(String[] args) {
//        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//        System.out.println(circularDeque.insertLast(1));                    // 返回 true
//        System.out.println(circularDeque.insertLast(2));                    // 返回 true
//        System.out.println(circularDeque.insertFront(3));                    // 返回 true
//        System.out.println(circularDeque.insertFront(4));                    // 已经满了，返回 false
//        System.out.println(circularDeque.getRear());                // 返回 2
//        System.out.println(circularDeque.isFull());                        // 返回 true
//        System.out.println(circularDeque.deleteLast());                    // 返回 true
//        System.out.println(circularDeque.insertFront(4));                    // 返回 true
//        System.out.println(circularDeque.getFront());                // 返回 4

//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.insertLast(5));
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.insertLast(8));
//        System.out.println(circularDeque.deleteLast());
//        System.out.println(circularDeque.getFront());


        MyCircularDeque circularDeque = new MyCircularDeque(4);
        System.out.println(circularDeque.insertLast(9));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertFront(6));
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(6));
    }

    static class MyCircularDeque {
        int[] nums;
        int start;
        int end;
        int cnt;
        int limit;

        public MyCircularDeque(int k) {
            nums = new int[k];
            start = 0;
            end = -1;
            cnt = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (cnt == limit) {
                return false;
            }
            start = (start - 1 + limit) % limit;
            nums[start] = value;
            cnt++;
            return true;
        }

        public boolean insertLast(int value) {
            if (cnt == limit) {
                return false;
            }
            end = (end + 1 + limit) % limit;
            nums[end] = value;
            cnt++;
            return true;
        }

        public boolean deleteFront() {
            if (cnt == 0) {
                return false;
            }
            start = (start + 1) % limit;
            cnt--;
            return true;
        }

        public boolean deleteLast() {
            if (cnt == 0) {
                return false;
            }
            end = (end - 1) % limit;
            cnt--;
            return true;
        }

        public int getFront() {
            if (cnt == 0) {
                return -1;
            }
            return nums[(start + limit) % limit];
        }

        public int getRear() {
            if (cnt == 0) {
                return -1;
            }
            return nums[(end + limit) % limit];
        }

        public boolean isEmpty() {
            return cnt == 0;
        }

        public boolean isFull() {
            return cnt == limit;
        }
    }

}
