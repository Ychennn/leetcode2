package solved30_39;

import java.util.Arrays;

class Solution31 {// 下一个排列

    public void nextPermutation(int[] nums) {
        //总的思想：
        //先找出最大的索引left满足nums[left] < nums[left + 1],此时nums[left + 1] - nums[nums.length-1]为逆序
        //比如: nums = [1,2,7,4,3,1],找到left = 1 ,nums[left] = 2,下一步从后往前找找到第一个right
        //使得nums[right] > nums[left],找到right = 4,nums[right] = 3,此时交换nums[left]和nums[right]
        //此时nums = [1,3,7,4,2,1],因为需要让index后的数组变成最小,这个时候将index以后的数组进行逆置或者排序即可
        //(此时本来就是逆序的,因为第一步的处理),处理完后nums = [1,3,1,2,4,7]
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        //当nums本就为逆序数组的时候,比如[3,2,1],left经过上一步最终为-1,所以需要加这一步判断
        if (left >= 0) {
            int right = nums.length - 1;
            for (; right >= 0; right--) {
                if (nums[right] > nums[left]) break;
            }

            //不需要if (right >= 0),因为肯定能找到nums[right] > nums[left] && right>=0
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;

        }
        //Arrays.sort的效率会比逆置低,因为快排逆序数组时间复杂度为O(n^2)
        Arrays.sort(nums, left + 1, nums.length);
    }


    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        int[] nums = new int[]{1, 2, 7, 4, 3, 1};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.printf(num + "");
        }
    }
}