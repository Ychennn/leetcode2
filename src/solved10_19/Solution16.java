package solved10_19;

import java.util.Arrays;

public class Solution16 {//最接近的三数之和

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int l, r, sum;

        //这道题的去重主要是因为重复的答案会影响效率
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];

                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum > target) {
                    //去重
                    r--;
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < target) {
                    //去重
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else {
                    //相等的话,绝对值差为0,就是最接近的情况,直接返回
                    return target;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution16 solution = new Solution16();
        int i = solution.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(i);
    }
}
