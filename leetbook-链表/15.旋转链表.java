class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode tmp = head;
        // 把结点放到list中
        while (tmp != null) {
            listNodes.add(tmp);
            tmp = tmp.next;
        }
        // 计算出旋转 n 次后的头结点下标（对应list中）
        int idx = listNodes.size() - (k % listNodes.size());
        // 下标等于 list 长度，表示旋转后还是原链表
        if (idx == listNodes.size()) {
            return head;
        } else {
            // 把原链表头尾接起来，然后把新头结点的前驱结点断开即可。
            listNodes.get(listNodes.size() - 1).next = listNodes.get(0);
            listNodes.get(idx - 1).next = null;
            return listNodes.get(idx);
        }
    }
}
