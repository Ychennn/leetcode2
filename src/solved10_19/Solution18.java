package solved10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {//四数之和

    private List<List<Integer>> res;
    private List<Integer> tmp;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();

        Arrays.sort(nums);
        func(nums, target, 0, 0, 0);
        return res;
    }

    private void func(int[] nums, int target, int count, int start, long sum) {
        if (count == 4 && sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        } else if (count >= 4) {
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                tmp.add(nums[i]);
                func(nums, target, count + 1, i + 1, sum + nums[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums, target);
        System.out.println(lists);
    }
}
