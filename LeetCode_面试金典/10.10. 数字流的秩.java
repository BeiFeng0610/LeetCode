import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class StreamRank {
    private List<Integer> list;
    public StreamRank() {
        list = new ArrayList<>();
    }

    public void track(int x) {
        int index = getRankOfNumber(x);
        list.add(index, x);
    }

    public int getRankOfNumber(int x) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}