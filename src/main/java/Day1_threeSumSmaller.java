import java.util.Arrays;

/**
 * Created by SunYing on 2017/6/7.
 */
public class Day1_threeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int rst = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else {
                    rst += k - j;
                    j++;
                }
            }
        }
        return rst;
    }
}
