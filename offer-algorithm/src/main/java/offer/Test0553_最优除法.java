package offer;

public class Test0553_最优除法 {

    public static void main(String[] args) {
        System.out.println(new Solution().optimalDivision(new int[]{1000, 100, 10, 2}));
        System.out.println(new Solution().optimalDivision(new int[]{1000}));
        System.out.println(new Solution().optimalDivision(new int[]{1000, 1000}));
    }

    static class Solution {
        public String optimalDivision(int[] nums) {
            String res = dfs(0, nums);
            return res;
        }

        private String dfs(int index, int[] nums) {
            if (index == nums.length - 1) {
                return nums[index] + "";
            }
            if (index == nums.length - 2) {
                return nums[nums.length - 2] + "/" + nums[nums.length - 1];
            }
            if (index == 0) {
                return nums[index] + "/(" + dfs(index + 1, nums) + ")";
            } else {
                return nums[index] + "/" + dfs(index + 1, nums);
            }
        }
    }

    static class Solution_冗余 {
        public String optimalDivision(int[] nums) {
            String res = dfs(0, nums);
            return res.substring(1, res.length() - 1);
        }

        private String dfs(int index, int[] nums) {
            if (index == nums.length - 1) {
                return "(" + nums[index] + ")";
            }
            if (index == nums.length - 2) {
                return "(" + nums[nums.length - 2] + "/" + nums[nums.length - 1] + ")";
            }
            return "(" + nums[index] + "/" + dfs(index + 1, nums) + ")";
        }
    }

}
