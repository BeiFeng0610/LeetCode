class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        // 自顶向下归并，把所有结点拆分成单个结点，然后归并
        if (head == null) {
            return head;
        }
        // 单个结点就返回
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 找到中心结点，右边界默认为null
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        // 继续分割左右区间
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        // 不可分割后，排序之后返回
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        // 临时头节点
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        // 判断两个链表，比较哪个大就插到临时结点中
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        // 判断剩余结点，直接插到临时结点后面
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        // 返回需要的链表
        return dummyHead.next;
    }
}

class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        // 获取链表长度
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        // 归并的窗口宽度，每次增加一倍   1 2 4 8
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                // 第一个头节点
                ListNode head1 = curr;
                // 根据宽度，指针偏移n结点
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 找到第二个头节点
                ListNode head2 = curr.next;
                // 两个链表断开连接
                curr.next = null;
                curr = head2;
                // 第二个链表也偏移，需要判断边界
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                // 如果curr不为空，则找到下一次循环的第一个头结点
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 排序两个链表加到临时头结点后
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                // 更新待插的尾结点
                while (prev.next != null) {
                    prev = prev.next;
                }
                // 更新下一次循环开始的结点
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
