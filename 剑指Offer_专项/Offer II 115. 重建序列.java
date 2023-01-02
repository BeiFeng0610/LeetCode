class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        //set查看序列集合中的元素是否完整(满足1～n)
        Set<Integer> set = new HashSet<>();
        int n = org.length;
        for(List<Integer> seq : seqs){
            for(int num : seq) set.add(num);
        }
        //原始序列只有一个元素且不在序列集中
        if(n == 1 && !set.contains(n)) return false;
        //序列集元素不完整
        if(set.size() != n) return false;

        //建元素之间的有向边关系
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //记录元素的入度
        int[] in = new int[n+1];
        for(int i = 1; i <= n; ++i) graph.put(i, new HashSet<>());
        for(List<Integer> seq : seqs){
            for(int i = 0; i < seq.size()-1; ++i){
                if(!graph.get(seq.get(i)).contains(seq.get(i+1))){
                    graph.get(seq.get(i)).add(seq.get(i+1));
                    in[seq.get(i+1)]++;
                }
            }
        }
        //准备拓扑排序，入度为0的元素入队，注意要想确定唯一序列，队列中每次只可能有唯一入度为零的元素
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; ++i){
            if(in[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> ls = new ArrayList<>();
        //入度为0的元素不唯一则无法确定唯一序列
        if(q.size() != 1) return false;
        while(!q.isEmpty()){
            if(q.size() != 1) return false;
            int cur = q.poll();
            ls.add(cur);
            if(graph.get(cur) == null) continue;
            for(int next : graph.get(cur)){
                in[next]--;
                if(in[next] == 0) q.offer(next);
            }
        }
        if(ls.size() != n) return false;
        //一一比较出队序列的元素顺序，若和原始不一致则重建失败
        for(int i = 0; i < n; ++i){
            if(ls.get(i) != org[i]) return false;
        }
        //全部元素符合重建成功
        return true;
    }
}
