package leetcode.problems;

import java.util.Arrays;

public class Test0462_最少移动次数使数组元素相等II {

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves2(new int[]{1, 2, 3}));
        System.out.println(new Solution().minMoves2(new int[]{1, 10, 2, 9}));
    }

    /**
     * 中位数证明：
     *
     * 很多人不明白为什么中位数是最优解，其实证明非常简单，下面来看看吧：
     *
     * 为了方便，我们先假设一共有2n+1个数，它们从小到大排序之后如下：
     *
     *  . . . a m b . . .
     * 其中m是中位数。此时，m左边有n个数，m右边也有n个数。我们假设把m左边所有数变成m需要的代价是x，把m右边所有数变成m的代价是y，此时的总代价就是t = x+y
     *
     * 好，如果你觉得中位数不是最优解，我们来看看把所有数都变成a的总代价是多少。 由于之前m右边n个数变成m的代价是y，现在让右边的数全变成a，此时右边的数的代价是y+(m-a)*n；m左边的n个数全变成a，它们的代价会减少到x-(m-a)*n。所以两边相加，结果还是 x-(m-a)*n + y+(m-a)*n == x+y。 但是，别忘了，m也要变成a，所以总代价是x+y+m-a，大于x+y。同理，如果让所有数都变成比m大的b，总代价则变为x+y+b-m（你可以自己算一下），依然比x+y大。并且越往左移或者往右移，这个值都会越来越大。 因此，在有2n+1个数的时候，选择中位数就是最优解。
     *
     * 这个证明同样可以很简单地推广到2n个数。
     *
     * . . . a b . . .
     * 假设a左边有n-1个数，b右边也有n-1个数。如果我们选择把所有数都变成a，设a左边所有数变成a的代价是x，b右边所有数变成a的代价是y，因此总代价是x+y+b-a（b也要变成a）。 现在尝试下如果把所有数变成b，那么a左边的总代价变成了x+(b-a)*(n-1)，b右边总代价变成了y-(b-a)*(n-1)，同时还要把a变成b，因此总代价同样为x+(b-a)*(n-1)+y-(b-a)*(n-1) == x+y+b-a。也就是说当总个数为2n时，两个中位数选哪个最终结果都一样，但是继续左移和继续右移，都会使总代价增加（可以自己试试）。
     *
     * 至此，证明了中位数是最优策略
     *
     * 因此，这道题你只需要找到中位数，然后简单计算一下就能得出结果了
     */
    static class Solution {
        public int minMoves2(int[] nums) {
            // 计算中位数
            int len = nums.length;
            Arrays.sort(nums);
            int mid;
            if (len % 2 == 1) {
                mid = nums[len / 2];
            } else {
                mid = (nums[len / 2] + nums[len / 2 - 1]) / 2;
            }
            // 计算移动到中位数的步数
            int res = 0;
            for (int num : nums) {
                res += Math.abs(num - mid);
            }
            return res;
        }
    }

}
