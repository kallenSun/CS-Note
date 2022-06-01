package leetcode.editor.cn;


import leetcode.editor.ListNode;


class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(-1);
        ListNode cur = dumpy;
        int co = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + co;
            cur.next = new ListNode(sum / 10);
            cur = cur.next;
            co = sum % 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (co != 0) {
            cur.next = new ListNode(co);
        }
        return dumpy.next;
    }


}
