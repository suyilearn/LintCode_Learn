import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SunYing on 2017/6/13.
 */
public class Day7_FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 4) {
            return rst;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int third = 0;
                int four = numbers.length - 1;
                while (third < four) {
                    int sum = numbers[i] + numbers[j] + numbers[third] + numbers[four];
                    if (sum < target) {
                        third++;
                    } else if (sum > target) {
                        four--;
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[third]);
                        list.add(numbers[four]);
                        rst.add(list);
                        third++;
                        four--;
                        while (third < four && numbers[third] == numbers[third - 1]) {
                            third++;
                        }
                        while (third < four && numbers[four] == numbers[four + 1]) {
                            four--;
                        }
                    }
                }
            }
        }
        return rst;
    }
}
