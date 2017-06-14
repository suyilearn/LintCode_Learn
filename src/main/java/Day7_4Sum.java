import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by SunYing on 2017/6/14.
 */
public class Day7_4Sum {
    class Pair {
        Integer x;
        Integer y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override public int hashCode() {
            return this.x.hashCode() + this.y.hashCode();
        }

        @Override public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair pair = (Pair) obj;
            return (this.x == pair.x) && (this.y == pair.y);
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 4) {
            return rst;
        }
        Arrays.sort(numbers);
        HashMap<Integer, ArrayList<Pair>> integerArrayListHashMap = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (integerArrayListHashMap.containsKey(target - sum)) {
                    for (Pair p : integerArrayListHashMap.get(target - sum)) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(p.x);
                        list.add(p.y);
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        if (!rst.contains(list)) {
                            rst.add(list);
                        }
                    }
                }
            }
            for (int j = 0; j < i; j++) {
                int sum = numbers[i] + numbers[j];
                if (!integerArrayListHashMap.containsKey(sum)) {
                    integerArrayListHashMap.put(sum, new ArrayList<Pair>());
                }
                integerArrayListHashMap.get(sum).add(new Pair(numbers[j], numbers[i]));
            }            
        }
        return rst;
    }

}
