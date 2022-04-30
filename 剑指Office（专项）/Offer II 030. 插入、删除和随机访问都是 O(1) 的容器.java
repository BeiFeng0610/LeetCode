class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        // 判断是否存在，存在则false
        if (indices.containsKey(val)) {
            return false;
        }
        // 不存在则获得list数量，即可记录新元素在list中的下标
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        // 不存在则返回false
        if (!indices.containsKey(val)) {
            return false;
        }
        // 获取val在list的下标，用list最后一个元素覆盖，再删除最后一个元素，然后删除map中的元素。并更新最后一个元素的新位置。
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        // 获取全部数量，然后随机访问。
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
