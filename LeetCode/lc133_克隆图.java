public Node cloneGraph(Node node) {
    HashMap<Node,Node> map = new HashMap<>();
    return cloneN(node, map);
}

public Node cloneN(Node node, HashMap<Node, Node> map) {
    if (node == null) {
        return node;
    }
    // 此结点没克隆过就返回克隆结点。
    if (map.containsKey(node)) {
        return map.get(node);
    }
    // 克隆结点
    Node cNode = new Node(node.val, new ArrayList<>());
    map.put(node, cNode);

    // 遍历邻结点，全部克隆并更新克隆结点的邻结点。
    for (Node n : node.neighbors) {
        cNode.neighbors.add(cloneN(n, map));
    }
    return cNode;
}
