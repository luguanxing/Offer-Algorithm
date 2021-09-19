package leetcode.contest.week259;

import java.util.HashMap;
import java.util.Map;

public class Test5877_检测正方形 {

    public static void main(String[] args) {
        DetectSquares ds = new DetectSquares();
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        System.out.println(ds.count(new int[]{11, 10}));
        System.out.println(ds.count(new int[]{14, 8}));
        ds.add(new int[]{14, 8});
        ds.add(new int[]{11, 2});
        System.out.println(ds.count(new int[]{11, 10}));
    }

    static class DetectSquares {
        Map<String, Integer> map = new HashMap<>();

        public DetectSquares() {

        }

        public void add(int[] point) {
            String key = point[0] + "," + point[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        public int count(int[] point) {
            // 只找下方对角线的点
            int res = 0;
            int x = point[0];
            int y = point[1];
            for (String key : map.keySet()) {
                int delX = Integer.parseInt(key.split(",")[0]);
                int delY = Integer.parseInt(key.split(",")[1]);
                int delCnt = map.get(key);
                if (delX != x && delY != y && Math.abs(delX - x) == Math.abs(delY - y) && delCnt > 0) {
                    // 计算平行X的点(delX, y)和平行Y的点(x, delY)个数
                    int xParCnt = map.getOrDefault(delX + "," + y, 0);
                    int yParCnt = map.getOrDefault(x + "," + delY, 0);
                    res += delCnt * xParCnt * yParCnt;
                }
            }
            return res;
        }
    }

}
