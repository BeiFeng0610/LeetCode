class TripleInOne {
    private int n = 3;
    private int[][] data;
    private int[] locations;

    public TripleInOne(int stackSize) {
        data = new int[n][stackSize];
        locations = new int[n];
    }

    public void push(int stackNum, int value) {
        int[] stack = data[stackNum];
        int idx = locations[stackNum];
        if (idx < stack.length) {
            stack[idx] = value;
            locations[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int[] stack = data[stackNum];
        int idx = locations[stackNum];
        if (idx == 0) {
            return -1;
        }
        int val = stack[idx - 1];
        locations[stackNum]--;
        return val;
    }

    public int peek(int stackNum) {
        int[] stack = data[stackNum];
        int idx = locations[stackNum];
        if (idx == 0) {
            return -1;
        }
        return stack[idx - 1];
    }

    public boolean isEmpty(int stackNum) {
        return locations[stackNum] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */