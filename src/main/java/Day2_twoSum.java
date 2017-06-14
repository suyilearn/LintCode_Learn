/**
 * Created by SunYing on 2017/6/7.
 */
public class Day2_twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length < 2) {
            return rst;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            long sum = ((long) (nums[start] + nums[end]));
            if (target == sum) {
                rst[0] = start + 1;
                rst[1] = end + 1;
            } else if (target > sum) {
                start++;
            } else {
                end--;
            }

        }

        return rst;
    }
}
