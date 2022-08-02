package leetcode.problems;

public class Test0622_设计循环队列 {

    public static void main(String[] args) {
        /*
            MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
            System.out.println(circularQueue.enQueue(1)); // 返回 true
            System.out.println(circularQueue.enQueue(2)); // 返回 true
            System.out.println(circularQueue.enQueue(3)); // 返回 true
            System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
            System.out.println(circularQueue.Rear()); // 返回 3
            System.out.println(circularQueue.isFull()); // 返回 true
            System.out.println(circularQueue.deQueue()); // 返回 true
            System.out.println(circularQueue.enQueue(4)); // 返回 true
            System.out.println(circularQueue.Rear()); // 返回 4
         */
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.Front());

    }

    static class MyCircularQueue {
        int[] nums;
        int start;
        int end;
        int cnt;

        public MyCircularQueue(int k) {
            nums = new int[k];
            start = 0;
            end = nums.length - 1;
            cnt = 0;
        }

        public boolean enQueue(int value) {
            if (cnt >= nums.length) {
                return false;
            }
            end = (end + 1) % nums.length;
            nums[end] = value;
            cnt++;
            return true;
        }

        public boolean deQueue() {
            if (cnt <= 0) {
                return false;
            }
            start = (start + 1) % nums.length;
            cnt--;
            return true;
        }

        public int Front() {
            if (cnt <= 0) {
                return -1;
            }
            return nums[start];
        }

        public int Rear() {
            if (cnt <= 0) {
                return -1;
            }
            return nums[end];
        }

        public boolean isEmpty() {
            return cnt == 0;
        }

        public boolean isFull() {
            return cnt == nums.length;
        }
    }

}
