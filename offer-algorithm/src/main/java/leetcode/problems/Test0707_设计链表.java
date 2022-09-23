package leetcode.problems;

public class Test0707_设计链表 {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(1, 0);
        linkedList.get(0);
    }

    static class MyLinkedList {
        int MAX_SIZE = 1005;
        int[] nums;
        int cnt;

        public MyLinkedList() {
            nums = new int[MAX_SIZE];
            cnt = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= cnt) {
                return -1;
            }
            return nums[index];
        }

        public void addAtHead(int val) {
            int[] newNums = new int[MAX_SIZE];
            newNums[0] = val;
            for (int i = 0; i < cnt; i++) {
                newNums[i + 1] = nums[i];
            }
            nums = newNums;
            cnt++;
        }

        public void addAtTail(int val) {
            nums[cnt] = val;
            cnt++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > cnt) {
                return;
            }
            int[] newNums = new int[MAX_SIZE];
            for (int i = 0; i < index; i++) {
                newNums[i] = nums[i];
            }
            newNums[index] = val;
            for (int i = index; i < cnt; i++) {
                newNums[i + 1] = nums[i];
            }
            nums = newNums;
            cnt++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= cnt) {
                return;
            }
            int[] newNums = new int[MAX_SIZE];
            for (int i = 0; i < index; i++) {
                newNums[i] = nums[i];
            }
            for (int i = index; i < cnt - 1; i++) {
                newNums[i] = nums[i + 1];
            }
            nums = newNums;
            cnt--;
        }
    }

}
