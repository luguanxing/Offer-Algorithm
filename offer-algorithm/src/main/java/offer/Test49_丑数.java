package offer;


import java.util.ArrayList;
import java.util.List;

public class Test49_丑数 {

    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(1));
        System.out.println(new Solution().GetUglyNumber_Solution(7));
        System.out.println(new Solution().GetUglyNumber_Solution(8));
    }

    static class Solution {
        public int GetUglyNumber_Solution(int index) {
            if (index == 0) {
                return 0;
            }
            // 从小到大计算仅含2,3,5因子的丑数
            List<Integer> uglyNumberList = new ArrayList<>();
            uglyNumberList.add(1);
            for (int i = 1; i < index; i++) {
                // 从之前丑数中乘2,3,5并找出大于上一个丑数里相对最小的
                int min = uglyNumberList.get(i - 1) * 2;
                int lastUgly = uglyNumberList.get(i - 1);
                for (int j = 0; j < i; j++) {
                    Integer ugly = uglyNumberList.get(j);
                    int ugly2 = ugly * 2;
                    int ugly3 = ugly * 3;
                    int ugly5 = ugly * 5;
                    if (ugly2 > lastUgly) {
                        min = Math.min(min, ugly2);
                    }
                    if (ugly3 > lastUgly) {
                        min = Math.min(min, ugly3);
                    }
                    if (ugly5 > lastUgly) {
                        min = Math.min(min, ugly5);
                    }
                }
                uglyNumberList.add(min);
            }
            return uglyNumberList.get(index - 1);
        }
    }

    static class Solution_遍历 {
        public int GetUglyNumber_Solution(int index) {
            int uglyCnt = 0;
            int num = 0;
            // 遍历判断每个数是不是丑数直到丑数个数达到index个
            while (uglyCnt < index) {
                num++;
                if (isUgly(num)) {
                    uglyCnt++;
                }
            }
            return num;
        }

        private boolean isUgly(int num) {
            while (num % 2 == 0) {
                num = num / 2;
            }
            while (num % 3 == 0) {
                num = num / 3;
            }
            while (num % 5 == 0) {
                num = num / 5;
            }
            return num == 1;
        }
    }

}
