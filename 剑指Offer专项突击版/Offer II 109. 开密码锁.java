class Solution {
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                // 获取给定密码旋转一次的所有情况，然后判断。
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    // 向前转，下面的是向后转
    public char numPrev(char x){
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x){
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 列出给定密码的所有的旋转可能性，指旋转一次的所有可能性
    public List<String> get(String status){
        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }

        return ret;
    }
}
