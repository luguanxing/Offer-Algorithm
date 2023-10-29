package leetcode.contest.week369;

public class Test100102_数组的最小相等和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSum(new int[]{3, 2, 0, 1, 0}, new int[]{6, 5, 0}));
        System.out.println(new Solution().minSum(new int[]{2, 0, 2, 0}, new int[]{1, 4}));
        System.out.println(new Solution().minSum(new int[]{9, 5}, new int[]{15, 12, 5, 21, 4, 26, 27, 9, 6, 29, 0, 18, 16, 0, 0, 0, 20}));
        System.out.println(new Solution().minSum(
                new int[]{20, 0, 18, 11, 0, 0, 0, 0, 0, 0, 17, 28, 0, 11, 10, 0, 0, 15, 29},
                new int[]{16, 9, 25, 16, 1, 9, 20, 28, 8, 0, 1, 0, 1, 27}
        ));
    }

    static class Solution {
        public long minSum(int[] nums1, int[] nums2) {
            long sum1 = 0;
            long sum2 = 0;
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums1) {
                // 0替换成1
                sum1 += Math.max(num, 1);
                if (num == 0) {
                    cnt1++;
                }
            }
            for (int num : nums2) {
                // 0替换成1
                sum2 += Math.max(num, 1);
                if (num == 0) {
                    cnt2++;
                }
            }
            if (sum1 > sum2 && cnt2 == 0) {
                return -1;
            }
            if (sum1 < sum2 && cnt1 == 0) {
                return -1;
            }
            return Math.max(sum1, sum2);
        }
    }

    static class Solution_分类讨论 {
        public long minSum(int[] nums1, int[] nums2) {
            long sum1 = 0;
            long sum2 = 0;
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums1) {
                sum1 += num;
                if (num == 0) {
                    cnt1++;
                }
            }
            for (int num : nums2) {
                sum2 += num;
                if (num == 0) {
                    cnt2++;
                }
            }
            if (sum1 == sum2) {
                if (cnt1 == cnt2) {
                    return (sum1 + cnt1);
                } else if (cnt1 > cnt2) {
                    if (cnt2 == 0) {
                        return -1;
                    } else {
                        return (sum1 + cnt1);
                    }
                } else {
                    if (cnt1 == 0) {
                        return -1;
                    } else {
                        return (sum2 + cnt2);
                    }
                }
            } else if (sum1 > sum2) {
                if (cnt1 == cnt2) {
                    if (cnt1 == 0) {
                        return -1;
                    }
                    return (sum1 + cnt1);
                } else if (cnt1 > cnt2) {
                    if (cnt2 == 0) {
                        return -1;
                    }
                    return (sum1 + cnt1);
                } else {
                    if (sum1 + cnt1 >= sum2 + cnt2) {
                        return (sum1 + cnt1);
                    } else {
                        if (cnt1 == 0) {
                            return -1;
                        }
                        return Math.min(sum1 + cnt2, sum1 + (cnt2 - cnt1));
                    }
                }
            } else {
                if (cnt1 == cnt2) {
                    if (cnt2 == 0) {
                        return -1;
                    }
                    return (sum2 + cnt2);
                } else if (cnt1 > cnt2) {
                    if (sum1 + cnt1 <= sum2 + cnt2) {
                        return (sum2 + cnt2);
                    } else {
                        if (cnt2 == 0) {
                            return -1;
                        }
                        return Math.min(sum2 + cnt1, sum2 + (cnt1 - cnt2));
                    }
                } else {
                    if (cnt1 == 0) {
                        return -1;
                    }
                    return (sum2 + cnt2);
                }
            }
        }
    }

}
