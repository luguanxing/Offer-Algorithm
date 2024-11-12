package leetcode.problems;

import java.util.*;

public class Test0239_滑动窗口最大值 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(
                new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3
        )));
//        System.out.println(Arrays.toString(new Solution_单调栈优化().maxSlidingWindow(
//                new int[]{1}, 1
//        )));
//        System.out.println(Arrays.toString(new Solution_单调栈优化().maxSlidingWindow(
//                new int[]{1, -1}, 1
//        )));
//        System.out.println(Arrays.toString(new Solution_单调栈优化().maxSlidingWindow(
//                new int[]{9, 11}, 2
//        )));
//        System.out.println(Arrays.toString(new Solution_单调栈优化().maxSlidingWindow(
//                new int[]{4, -2}, 2
//        )));
//        System.out.println(Arrays.toString(new Solution_单调栈优化().maxSlidingWindow(
//                new int[]{1, 3, 1, 2, 0, 5}, 3
//        )));
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            int[] res = new int[len - k + 1];
            // 单调递减队列存储下标
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                // 保证单调性
                while (!deque.isEmpty() && nums[deque.peekLast()] < num) {
                    deque.pollLast();
                }
                deque.addLast(i);
                // 维护窗口长度为k
                if (i - deque.peekFirst() > k) {
                    deque.pollFirst();
                }
                // 添加数字
                if (i >= k - 1) {
                    res[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }

    static class Solution_比较数值 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> resList = new ArrayList<>();
            MyDeque myDeque = new MyDeque();
            for (int i = 0; i < nums.length; i++) {
                myDeque.push(nums[i]);
                if (i >= k - 1) {
                    // 取数，同时比较单调队列左边和窗口左侧
                    resList.add(myDeque.poll(nums[i - k + 1]));
                }
            }
            // 返回结果
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        class MyDeque {
            Deque<Integer> deque;

            public MyDeque() {
                this.deque = new ArrayDeque<>();
            }

            public void push(int num) {
                // 单调栈：保证内递减
                while (!deque.isEmpty()) {
                    if (deque.peekLast() < num) {
                        deque.pollLast();
                    } else {
                        break;
                    }
                }
                deque.addLast(num);
            }

            public int poll(int num) {
                // 只有单调队列左边和窗口左边对上时进行移除
                int head = deque.peekFirst();
                if (head == num) {
                    deque.pollFirst();
                }
                return head;
            }
        }
    }

    static class Solution_未优化 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> resList = new ArrayList<>();
            MyDeque myDeque = new MyDeque();
            for (int i = 0; i < nums.length; i++) {
                myDeque.push(nums[i]);
                if (i >= k - 1) {
                    resList.add(myDeque.poll());
                }
            }
            // 返回结果
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        class MyDeque {
            Deque<Integer> deque;

            public MyDeque() {
                this.deque = new ArrayDeque<>();
            }

            public void push(int num) {
                // 单调栈：保证内递减
                int smallerCnt = 0;
                while (!deque.isEmpty()) {
                    if (deque.peekLast() < num) {
                        deque.pollLast();
                        smallerCnt++;
                    } else {
                        break;
                    }
                }
                deque.addLast(num);
                for (int i = 1; i <= smallerCnt; i++) {
                    deque.addLast(num);
                }
            }

            public int poll() {
                return deque.pollFirst();
            }
        }
    }

    static class Solution_单调栈优化 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> resList = new ArrayList<>();
            // 使用单调栈计算窗口
            MyStack stack = new MyStack();
            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    // 窗口初始化
                    stack.push(nums[i]);
                } else {
                    // 窗口移动
                    stack.push(nums[i]);
                    resList.add(stack.max());
                    stack.pop(nums[i - k + 1]);
                }
            }
            // 返回结果
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        // 单调栈，保证栈内元素递减
        class MyStack {
            Deque<Integer> deque = new ArrayDeque<>();

            public void push(int num) {
                // 把前面比num小的去掉，再放入num
                while (!deque.isEmpty() && deque.peekLast() < num) {
                    deque.pollLast();
                }
                deque.addLast(num);
            }

            public int max() {
                return deque.peekFirst();
            }

            public void pop(int num) {
                if (num == deque.peekFirst()) {
                    deque.pollFirst();
                }
            }
        }
    }

    static class Solution_单调栈 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> resList = new ArrayList<>();
            // 使用单调栈计算窗口
            MyStack stack = new MyStack();
            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    // 窗口初始化
                    stack.push(nums[i]);
                } else {
                    // 窗口移动
                    stack.push(nums[i]);
                    resList.add(stack.max());
                    stack.pop();
                }
            }
            // 返回结果
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        // 单调栈，保证栈内元素递减
        class MyStack {
            Deque<Integer> deque = new ArrayDeque<>();

            public void push(int num) {
                // 把前面比num小的换成num
                int cnt = 0;
                while (!deque.isEmpty() && deque.peekLast() < num) {
                    deque.pollLast();
                    cnt++;
                }
                for (int i = 1; i <= cnt; i++) {
                    deque.addLast(num);
                }
                deque.addLast(num);
            }

            public int max() {
                return deque.peekFirst();
            }

            public void pop() {
                deque.pollFirst();
            }
        }
    }

    static class Solution_OLD {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            // 窗口内保持递减，遇到更大的替换前面全部
            List<Integer> window = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (window.isEmpty() || window.get(window.size() - 1) >= nums[i]) {
                    window.add(nums[i]);
                } else {
                    for (int j = window.size() - 1; j >= 0; j--) {
                        if (window.get(j) < nums[i]) {
                            window.set(j, nums[i]);
                        } else {
                            break;
                        }
                    }
                    window.add(nums[i]);
                }
            }
            res[0] = window.get(0);
            // 窗口滑动并计算
            for (int i = k; i < nums.length; i++) {
                window.remove(0);
                if (window.isEmpty() || window.get(window.size() - 1) >= nums[i]) {
                    window.add(nums[i]);
                } else {
                    for (int j = window.size() - 1; j >= 0; j--) {
                        if (window.get(j) < nums[i]) {
                            window.set(j, nums[i]);
                        } else {
                            break;
                        }
                    }
                    window.add(nums[i]);
                }
                res[i - k + 1] = window.get(0);
            }
            return res;
        }
    }

    static class Solution_TLE {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }
            res[0] = queue.peek();
            for (int i = k; i < nums.length; i++) {
                Integer addNum = nums[i];
                Integer removeNum = nums[i - k];
                queue.remove(removeNum);
                queue.add(addNum);
                res[i - k + 1] = queue.peek();
            }
            return res;
        }
    }

}
