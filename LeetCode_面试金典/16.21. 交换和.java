import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        for (int i : array1) {
            sum1 += i;
        }
        int sum2 = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : array2) {
            sum2 += i;
            set.add(i);
        }
        int diff = sum2 - sum1;
        if ((diff & 1) == 1) {
            return new int[0];
        }
        diff /= 2;
        for (int i : array1) {
            if (set.contains(i + diff)) {
                return new int[]{i, i + diff};
            }
        }
        return new int[0];
    }
}