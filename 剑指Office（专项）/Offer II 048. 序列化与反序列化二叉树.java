class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!strings[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);
            }
            i++;
            if (!strings[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}


class Codec2 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); // 利用StringBuilder拼接
        return toStr(root, sb).toString();
    }
    private StringBuilder toStr(TreeNode node, StringBuilder sb){ // 序列化dfs
        if(node == null) {
            sb.append("null,");
        } else{
            sb.append(Integer.toString(node.val) + ",");
            sb = toStr(node.left, sb);
            sb = toStr(node.right, sb);
        }
        return sb;
    }
    public TreeNode deserialize(String data) {
        String[] strNodes = data.split(",");
        List<String> nodes = new LinkedList<>(Arrays.asList(strNodes)); // 涉及头节点的操作，用LinkedList效率高
        return toTree(nodes);
    }
    private TreeNode toTree(List<String> nodes){ // 反序列化dfs
        if(nodes.get(0).equals("null")){
            nodes.remove(0); // 对此结点（null）完成反序列化，及时从nodes中去除
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0); // 对此结点完成反序列化，及时从nodes中去除
        root.left = toTree(nodes);
        root.right = toTree(nodes);
        return root;
    }
}
