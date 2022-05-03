class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid < 0) {
                if (stack.isEmpty()) {
                    list.add(asteroid);
                } else {
                    while (!stack.isEmpty()) {
                        if (-asteroid == stack.peek()) {
                            stack.pop();
                            break;
                        } else if (-asteroid > stack.peek()) {
                            stack.pop();
                            if (stack.isEmpty()) list.add(asteroid);
                        } else {
                            break;
                        }
                    }
                }
            } else {
                stack.push(asteroid);
            }

        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            list.add(stack.removeLast());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}

class Solution2 {
    public int[] asteroidCollision(int[] asteroids) {
        int top = -1, len = asteroids.length;
        int[] stack = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = asteroids[i];
            if (top != -1 && stack[top] > 0 && cur < 0) {
                if (stack[top] + cur > 0) {
                    continue;
                } else if (stack[top] + cur < 0) {
                    i--;
                }
                top--;
            }else {
                stack[++top] = cur; // 其他情形，cur入栈
            }
        }

        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}
