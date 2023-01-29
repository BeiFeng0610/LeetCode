class Solution {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] lines = new int[length];
        int offset = y * w / 32;
        int head = x1 / 32 + offset;
        int rear = x2 / 32 + offset;
        for (int i = head; i <= rear; i++) {
            lines[i] = -1;
        }
        lines[head] = lines[head] >>> (x1 % 32);
        lines[rear] = lines[rear] & (Integer.MIN_VALUE >> x2 % 32);
        return lines;
    }
}