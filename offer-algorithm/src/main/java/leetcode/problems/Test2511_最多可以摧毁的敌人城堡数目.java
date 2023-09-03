package leetcode.problems;

import java.util.TreeSet;

public class Test2511_最多可以摧毁的敌人城堡数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
        System.out.println(new Solution().captureForts(new int[]{0, 0, 1, -1}));
        System.out.println(new Solution().captureForts(new int[]{1, -1, -1, 1, 1}));
        System.out.println(new Solution().captureForts(new int[]{-1, -1, 0, 1, 0, 0, 1, -1, 1, 0}));
    }

    static class Solution {
        public int captureForts(int[] forts) {
            TreeSet<Integer> emptySet = new TreeSet<>();
            TreeSet<Integer> forceSet = new TreeSet<>();
            for (int i = 0; i < forts.length; i++) {
                if (forts[i] == -1) {
                    emptySet.add(i);
                } else if (forts[i] == 1) {
                    forceSet.add(i);
                }
            }
            int max = 0;
            for (int f : forceSet) {
                Integer lastEmpty = emptySet.lower(f);
                Integer lastForce = forceSet.lower(f);
                if (lastEmpty != null && (lastForce == null || lastForce < lastEmpty)) {
                    max = Math.max(max, f - 1 - lastEmpty);
                }
                Integer nextEmpty = emptySet.higher(f);
                Integer nextForce = forceSet.higher(f);
                if (nextEmpty != null && (nextForce == null || nextEmpty < nextForce)) {
                    max = Math.max(max, nextEmpty - 1 - f);
                }
            }
            return max;
        }
    }

    static class Solution2 {
        public int captureForts(int[] forts) {
            TreeSet<Integer> emptySet = new TreeSet<>();
            for (int i = 0; i < forts.length; i++) {
                if (forts[i] == -1) {
                    emptySet.add(i);
                }
            }
            int max = 0;
            for (int i = 0; i < forts.length; i++) {
                if (forts[i] == 1) {
                    if (emptySet.lower(i) != null) {
                        int cnt = 0;
                        for (int k = i - 1; k > emptySet.lower(i); k--) {
                            if (forts[k] == 0) {
                                cnt++;
                            } else {
                                cnt = 0;
                                break;
                            }
                        }
                        max = Math.max(max, cnt);
                    }
                    if (emptySet.higher(i) != null) {
                        int cnt = 0;
                        for (int k = i + 1; k < emptySet.higher(i); k++) {
                            if (forts[k] == 0) {
                                cnt++;
                            } else {
                                cnt = 0;
                                break;
                            }
                        }
                        max = Math.max(max, cnt);
                    }
                }
            }
            return max;
        }
    }

}
