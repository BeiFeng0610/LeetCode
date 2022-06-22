import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = ret.size();
        if (x <= ret.get(0)) {
            return ret.subList(0, k);
        } else if (ret.get(n - 1) <= x) {
            return ret.subList(n - k, n);
        } else {
            int idx = Collections.binarySearch(ret, x);
            if (idx < 0) {
                idx = -idx - 1;
            }
            int low = Math.max(0, idx - k - 1), high = Math.min(ret.size() - 1, idx + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x)) {
                    high--;
                } else if ((x - ret.get(low)) > (ret.get(high) - x)) {
                    low++;
                } else {
                    System.out.println("unhandled case:" + low + " " + high);
                }
            }
            return ret.subList(low, high + 1);
        }
    }
}