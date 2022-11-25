import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int tmp = num % 10;
            sum += tmp * tmp;
            num /= 10;
        }
        return sum;
    }
}