package solved10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {//三数之和

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return null;

        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l, r;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;//剪枝
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    //下面是去重
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
