class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tou = new ListNode(0);
        ListNode result = tou;
        ListNode temp;
        // 这个就是暴力法
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tou.next = list1;
                list1 = list1.next;
                tou = tou.next;
            } else if (list1.val == list2.val) {
                tou.next = list1;
                list1 = list1.next;
                tou = tou.next;
                tou.next = list2;
                list2 = list2.next;
                tou = tou.next;
            } else {
                tou.next = list2;
                list2 = list2.next;
                tou = tou.next;
            }
        }
        if (list1 != null) {
            tou.next = list1;
        }
        if (list2 != null) {
            tou.next = list2;
        }
        return result.next;
    }
}
