class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int in = 0, out = 0, count = 0;
            while (count < n) {
                int j = (i + count) % n;
                in += gas[j];
                out += cost[j];
                if (out > in) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return i;
            } else {
                i += count;
            }
        }
        return -1;
    }
}
