class MyCalendar {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // 使用treeMap，ceilingEntry获取key >= start 中最小的一个
        Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(start);
        // 使用treeMap，floorEntry获取key <= start 中最大的一个
        Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(start);
        // 如果没有比start更小的，就判断end <= ceilingEntry
        if ((floorEntry == null || floorEntry.getValue() <= start)
                && (ceilingEntry == null || end <= ceilingEntry.getKey())) {
            treeMap.put(start, end);
            return true;
        }
        return false;
    }
}
