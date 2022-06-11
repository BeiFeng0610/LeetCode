class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 不等于1，且没有循环，则一直找下去
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = pf(n);
        }

        return n==1;
    }

    private int pf(int i) {
        int sum = 0;
        while (i > 0) {
            int d = i % 10;
            i /= 10;
            sum += d * d;
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution().isHappy(19);
    }
}
class Solution2 {

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
