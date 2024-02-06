package leetcode.interview;

import java.util.*;
import java.util.stream.Collectors;

public class LCP30_魔塔游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().magicTower(new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150}));
        System.out.println(new Solution().magicTower(new int[]{-200, -300, 400, 0}));
        System.out.println(new Solution().magicTower(new int[]{5, -4, 1, -2, -2, -2, 4}));
        System.out.println(new Solution().magicTower(new int[]{1, 1, 1, -1, -1, -1}));
    }

    static class Solution {
        public int magicTower(int[] nums) {
            if (Arrays.stream(nums).sum() < 0) {
                return -1;
            }
            // 贪心+优先队列，每次血为负数时把前面最小移到后面
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            long endSum = 0;
            int cnt = 0;
            long hp = 0;
            while (!list.isEmpty()) {
                int num = list.remove(0);
                queue.add(num);
                hp += num;
                if (hp < 0) {
                    int maxCost = queue.poll();
                    endSum += maxCost;
                    hp -= maxCost;
                    cnt++;
                }
            }
            return hp + endSum >= 0 ? cnt : -1;
        }
    }

    static class Solution_队列超时 {
        public int magicTower(int[] nums) {
            if (Arrays.stream(nums).sum() < 0) {
                return -1;
            }
            // 贪心 + 优先队列，每次血为负数时把前面最小移到后面
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            int cnt = 0;
            int hp = 0;
            while (!list.isEmpty()) {
                int num = list.remove(0);
                queue.add(num);
                hp += num;
                if (hp < 0) {
                    int maxCost = queue.poll();
                    list.add(maxCost);
                    hp -= maxCost;
                    cnt++;
                }
            }
            return cnt;
        }
    }

    static class Solution_遇负数不断后移思路不对 {
        public int magicTower(int[] nums) {
            if (Arrays.stream(nums).sum() < 0) {
                return -1;
            }
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int cnt = 0;
            int hp = 0;
            while (!list.isEmpty()) {
                int num = list.remove(0);
                if (num > 0) {
                    hp += num;
                    continue;
                }
                // 往后探测，若负数和超过hp，把最大的移到后面
                PriorityQueue<Integer> queue = new PriorityQueue<>();
                queue.add(num);
                int sum = num;
                while (sum + hp >= 0 && !list.isEmpty() && list.get(0) < 0) {
                    int n = list.remove(0);
                    queue.add(n);
                    sum += n;
                }
                if (sum + hp >= 0) {
                    hp += sum;
                    continue;
                }
                int maxCost = queue.poll();
                list.add(maxCost);
                list.addAll(0, queue);
                cnt++;
            }
            return cnt;
        }
    }

}
