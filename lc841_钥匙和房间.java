class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int num = 0;
        boolean[] kai = new boolean[n];
        kai[0] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(rooms.get(0));
        while (!queue.isEmpty()) {
            List<Integer> temp = queue.remove();
            num++;
            for (Integer i : temp) {
                if (!kai[i]) {
                    kai[i] = true;
                    queue.offer(rooms.get(i));
                }
            }

        }
        return num == n;
    }
}
