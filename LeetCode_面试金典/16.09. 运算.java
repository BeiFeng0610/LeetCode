class Operations {

    public Operations() {

    }

    public int minus(int a, int b) {
        int c = -b;
        return a + c;
    }

    public int multiply(int a, int b) {
        boolean sy = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sy = true;
        }
        int c = Math.abs(a);
        int d = Math.abs(b);
        int res = 0;
        for (int i = 0; i < d; i++) {
            res += c;
        }
        return sy ? -res : res;
    }

    public int divide(int a, int b) {
        boolean sy = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sy = true;
        }
        int count = 0;
        int c = Math.abs(a);
        int d = Math.abs(b);
        if (c < d) {
            return 0;
        }
        while (c > 0) {
            c -= d;
            count++;
        }
        return sy ? -count : count;
    }
}

/**
 * Your Operations object will be instantiated and called as such:
 * Operations obj = new Operations();
 * int param_1 = obj.minus(a,b);
 * int param_2 = obj.multiply(a,b);
 * int param_3 = obj.divide(a,b);
 */