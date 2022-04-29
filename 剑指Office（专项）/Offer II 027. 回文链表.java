class Solution {
    // 元素都是单位，追加字符串反转对比即可。
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        return s.equals(reverse);
    }
}

class Solution2 {
    // 找到中点，反转后半部分，然后对比。
    public boolean isPalindrome(ListNode head) {
        ListNode mid = midNode(head);
        ListNode l1 = head;
        ListNode l2 = reverseList(mid.next);
        mid.next = null;
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public ListNode midNode(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode root) {
        ListNode head = new ListNode(-1);
        ListNode tmp = null;
        while (root != null) {
            tmp = root;
            root = root.next;
            tmp.next = head.next;
            head.next = tmp;
        }
        return head.next;
    }
}

class Solution3 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}

class Solution4 {
    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
