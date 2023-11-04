package solved20_29;

public class Solution27 {//移除元素

    public int removeElement(int[] nums, int val) {
        int index = 0, curr = 0;
        while (curr < nums.length) {
            if (nums[curr] != val) {
                nums[index++] = nums[curr];
            }
            curr++;

        }
        return index;
    }

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        int len = solution.removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
