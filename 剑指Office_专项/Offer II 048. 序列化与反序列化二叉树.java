class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 初始化
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        
        // 广度优先遍历，拼接结点值，以及结点的子节点。
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
        // 删除最后一个逗号
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        // 拆分成数组
        String[] strings = data.substring(1, data.length() - 1).split(",");
        // 初始化根节点
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 根节点已经初始化，接下来从数组1下标开始
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 判断下标结点是否不为null，下标指向弹出结点的左节点。
            if (!strings[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                // 结点存在则加入队列
                queue.add(node.left);
            }
            // 下标前进，为null不用加入队列
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
    private StringBuilder toStr(TreeNode node, StringBuilder sb){ 
        // 序列化dfs，按照深度优先遍历拼接字符串
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
        // 提取字符串数组，塞到LinkedList，涉及头节点的操作，用LinkedList效率高
        String[] strNodes = data.split(",");
        List<String> nodes = new LinkedList<>(Arrays.asList(strNodes));
        return toTree(nodes);
    }
    private TreeNode toTree(List<String> nodes){ // 反序列化dfs
        // 如果头节点为null，直接返回null即可
        if(nodes.get(0).equals("null")){
            nodes.remove(0); // 对此结点（null）完成反序列化，及时从nodes中去除
            return null;
        }
        // 初始化结点
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        // 删除已经加入过的结点
        nodes.remove(0); // 对此结点完成反序列化，及时从nodes中去除
        root.left = toTree(nodes);
        root.right = toTree(nodes);
        return root;
    }
}
