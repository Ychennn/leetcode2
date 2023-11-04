package solved20_29;

public class Solution26 {//删除有序数组中的重复项

    public int removeDuplicates(int[] nums) {
        int index = 0, curr = 1;
        while (curr < nums.length) {
            if (nums[index] == nums[curr]) {
                curr++;
            } else {
                nums[++index] = nums[curr];
            }
        }
        //index此时指向无重复项数组的最后一项(索引)
        //要求返回长度,所以应该+1
        return index + 1;
    }

    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = solution.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
