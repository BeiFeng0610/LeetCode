class Solution {
    public int[] findClosedNumbers(int num) {
        if (num == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = getBig(num);
        res[1] = getSmall(num);
        return res;
    }

    private int getBig(int num) {
        int cnt = 0;
        while (cnt < 31 && (num & (1 << cnt)) == 0) {
            cnt++;
        }
        int b1 = cnt;

        while (cnt < 31 && (num & (1 << cnt)) > 0) {
            cnt++;
        }
        if (cnt == 31) {
            return -1;
        }
        num ^= (1 << cnt--);
        num ^= (1 << cnt--);

        num = onezoreswap(num, cnt, b1);
        return num;
    }

    private int getSmall(int num) {
        int cnt = 0;
        while (cnt < 31 && (num & (1 << cnt)) > 0) {
            cnt++;
        }
        int b0 = cnt;

        while (cnt < 31 && (num & (1 << cnt)) == 0) {
            cnt++;
        }
        if (cnt == 31) {
            return -1;
        }
        num ^= (1 << cnt--);
        num ^= (1 << cnt--);

        num = onezoreswap(num, cnt, b0);
        return num;
    }

    private static int onezoreswap(int num, int cnt, int bit) {
        for (int i = 0; i < bit && cnt > bit - 1; i++, cnt--) {
            num ^= (1 << i);
            num ^= (1 << cnt);
        }
        return num;
    }
}