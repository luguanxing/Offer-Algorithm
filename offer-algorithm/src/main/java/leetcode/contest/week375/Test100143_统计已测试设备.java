package leetcode.contest.week375;

public class Test100143_统计已测试设备 {

    public static void main(String[] args) {
        // batteryPercentages = [1,1,2,1,3]
        System.out.println(new Solution().countTestedDevices(new int[]{1, 1, 2, 1, 3}));
        // batteryPercentages = [0,1,2]
        System.out.println(new Solution().countTestedDevices(new int[]{0, 1, 2}));
    }

    static class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int len = batteryPercentages.length;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (batteryPercentages[i] >0) {
                    cnt++;
                    for (int j = i + 1; j < len; j++) {
                        if (batteryPercentages[j] > 0) {
                            batteryPercentages[j]--;
                        }
                    }
                }
            }
            return cnt;
        }
    }

}
