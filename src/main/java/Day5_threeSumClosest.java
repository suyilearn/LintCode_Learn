import java.util.Arrays;

/**
 * Created by SunYing on 2017/6/7.
 */
public class Day5_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        long closest = ((long) Integer.MAX_VALUE);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
            }

        }

        return (int) closest;
    }

}
