import java.util.Arrays;

/**
 * Created by SunYing on 2017/6/7.
 */
public class Day3_twoSum2 {
    public int towSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int count = 0;
        int left = 0;
        Arrays.sort(nums);
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                count += right - left;
                right--;
            } else {
                left++;
            }
        }
        return count;
    }

    public int twoSum2_2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                 count += (nums[i] + nums[j] > target) ? 1 : 0;
            }
        }
    }
}
