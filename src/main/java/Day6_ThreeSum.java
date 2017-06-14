import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SunYing on 2017/6/8.
 */
public class Day6_ThreeSum {
    public ArrayList<ArrayList<Integer>> treeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length <= 2) {
            return rst;
        }
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 2; i--) {
            if (i < numbers.length - 1 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            ArrayList<ArrayList<Integer>> twoSum = callTwoSum(numbers, i, 0 - numbers[i]);
            for (int j = 0; j < twoSum.size(); j++) {
                twoSum.get(j).add(numbers[i]);
            }
            rst.addAll(twoSum);
        }
        return rst;
    }


    public ArrayList<ArrayList<Integer>> callTwoSum(int[] nums, int end, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        int left = 0;
        int right = end;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                ArrayList<Integer> match = new ArrayList<Integer>();
                match.add(nums[left]);
                match.add(nums[right]);
                rst.add(match);
                left++;
                right--;
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right++;
            }
        }
        return rst;
    }
}