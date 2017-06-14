/**
 * Created by SunYing on 2017/6/14.
 */
public class Day8_AplusB {
    //不是很懂
    public int aplusb(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

}
