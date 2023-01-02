class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid < 0) {
                // 负数为空时，直接添加到list
                if (stack.isEmpty()) {
                    list.add(asteroid);
                } else {
                    while (!stack.isEmpty()) {
                        // 与栈顶相等则抵消，直接返回
                        if (-asteroid == stack.peek()) {
                            stack.pop();
                            break;
                        } else if (-asteroid > stack.peek()) {
                            stack.pop();
                            // 如果绝对值大于则干碎一个，干碎完加入list
                            if (stack.isEmpty()) list.add(asteroid);
                        } else {
                            // 小于直接返回
                            break;
                        }
                    }
                }
            } else {
                // 正数进栈
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
        // 模拟栈，top为栈针。
        int[] stack = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = asteroids[i];
            // 栈不空，栈顶为正数，cur为负数。开始较量
            if (top != -1 && stack[top] > 0 && cur < 0) {
                // 正数绝对值大，负数被干碎
                if (stack[top] + cur > 0) {
                    continue;
                } else if (stack[top] + cur < 0) {
                    // 负数绝对值大，正数被干碎，-- 是为了下一次循环继续拿负数比较
                    i--;
                }
                // 被干碎了或者同归于尽都弹出一个
                top--;
            }else {
                // 栈空进栈，栈顶为负数进栈，cur为正数进栈
                stack[++top] = cur; // 其他情形，cur入栈
            }
        }

        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}
