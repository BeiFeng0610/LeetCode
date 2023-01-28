class Solution {
    public int convertInteger(int A, int B) {
        int C = A ^ B;
        int count = 0;
        while (C != 0) {
            if ((C & 1) == 1) {
                count++;
            }
            C >>>= 1;
        }
        return count;
    }
}

class Solution {
    public int convertInteger(int A, int B) {
        int C = A ^ B;
        int count = 0;
        while (C != 0) {
            C &= (C - 1);
            count++;
        }
        return count;
    }
}