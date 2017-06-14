import java.util.HashMap;

/**
 * Created by SunYing on 2017/6/7.
 */
public class Day4_twoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] rst = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                rst[0] = map.get(target - nums[i]) + 1;
                rst[1] = i + 1;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return rst;
    }
}
