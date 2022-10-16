class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int pre = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int tmp = getNum(chars[i]);
            if (tmp < pre) {
                num -= tmp;
            } else {
                num += tmp;
            }
            pre = tmp;
        }
        return num;
    }

    private int getNum(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}