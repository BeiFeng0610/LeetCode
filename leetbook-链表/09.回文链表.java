class Solution {
    private ListNode frontPointer;

    // 直接递归到最后一个结点
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            // 最后一个结点的下一个结点一定是空结点，返回true， 这边就是false
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            // 判断剩余头节点 和 尾结点的值
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            // 更新头结点
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
