class Solution {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
      
        /*
           二进制除法
           被除数右移（防止越界） 减去 除数，如果大于零，
              相当于第i位可以上1，res+=记录。
              然后用被除数减去，除数左移i位。
        */ 
        
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                a -= (b << i);
                if (res > Integer.MAX_VALUE - (1 << i)) {
                    return Integer.MIN_VALUE;
                }
                res += (1 << i);
            }
        }

        return sign == 1 ? res : -res;
    }
}
