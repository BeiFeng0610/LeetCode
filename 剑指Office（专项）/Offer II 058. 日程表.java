class MyCalendar {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(start);
        Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(start);
        if ((floorEntry == null || floorEntry.getValue() <= start)
                && (ceilingEntry == null || end <= ceilingEntry.getKey())) {
            treeMap.put(start, end);
            return true;
        }
        return false;
    }
}
