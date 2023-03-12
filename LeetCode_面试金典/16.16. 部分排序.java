import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] subSort(int[] array) {
        Deque<Integer> stack = new LinkedList<>();
        int m = array.length, n = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] < array[stack.peek()]) {
                int pop = stack.pop();
                max = Math.max(max, array[pop]);
                m = Math.min(m, pop);
                n = i;
            }
            if (array[i] < max) {
                n = i;
            }
            stack.push(i);
        }
        return m == array.length ? new int[]{-1, -1} : new int[]{m, n};
    }
}

class Solution {
    public int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int len = array.length;
        int max = array[0];
        int min = array[len - 1];
        for(int i = 1; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = Math.max(max, array[i]);
            }

            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        return new int[] {first, last};
    }
}

class Solution {
    public int[] subSort(int[] array) {
        if (array == null || array.length < 2) {
            return new int[]{-1, -1};
        }
        int min = array[array.length - 1];
        int m = -1;
        for (int j = array.length - 2; j >= 0; j--) {
            if (array[j] <= min) {
                min = array[j];
            } else {
                m = j;
            }
        }
        int max = array[0];
        int n = -1;
        for (int j = 1; j < array.length; j++) {
            if (array[j] >= max) {
                max = array[j];
            } else {
                n = j;
            }
        }
        return new int[]{m, n};
    }
}