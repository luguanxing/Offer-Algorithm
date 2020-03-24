package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Test21_调整数组顺序使奇数位于偶数前面 {

    @FunctionalInterface
    interface MyOrder {
        // 函数式接口，用户自定义排序逻辑实现
        void order(int[] array);
    }

    static void runMyOrder(MyOrder myOrder, int[] array) {
        // 接收自定义逻辑和数组，使用接口计算数组
        myOrder.order(array);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        runMyOrder(new Solution()::reOrderArray, array1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        runMyOrder(new Solution_无相对顺序()::reOrderArray, array2);
        System.out.println(Arrays.toString(array2));
    }

    static class Solution {
        public void reOrderArray(int[] array) {
            if (array == null) {
                return;
            }
            // 分出奇数和偶数
            List<Integer> oddList = new ArrayList<>();
            List<Integer> evenList = new ArrayList<>();
            for (int num : array) {
                if (num % 2 == 1) {
                    oddList.add(num);
                } else {
                    evenList.add(num);
                }
            }
            AtomicReference<Integer> index = new AtomicReference<>(0);
            oddList.forEach(num -> array[index.getAndSet(index.get() + 1)] = num);
            evenList.forEach(num -> array[index.getAndSet(index.get() + 1)] = num);
        }
    }

    static class Solution_无相对顺序 {
        public void reOrderArray(int[] array) {
            if (array == null) {
                return;
            }
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                while (array[left] % 2 == 1) {
                    // 找到最左边偶数
                    left++;
                    continue;
                }
                while (array[right] % 2 == 0) {
                    // 找到最右边奇数
                    right--;
                    continue;
                }
                // 交换最左边偶数和最右边计数
                if (left < right) {
                    int tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                }
            }
        }
    }

}
