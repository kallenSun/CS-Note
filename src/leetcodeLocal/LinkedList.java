package leetcodeLocal;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2022/2/16 <br>
 * @since V9.0 <br>
 */
public class LinkedList {

    private ListNode head;

    private ListNode tail;

    static class ListNode {
        int val;
        ListNode next;  // 内存的地址值
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void push(int val) {
        if (head == null && tail == null) {
             head = new ListNode(val);
             tail = head;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    public boolean getValue(int value) {
        ListNode cur = head;

        while (cur != null) {

            cur = cur.next;

            if (cur.val == value) {
                return true;
            }
        }
        return false;
    }


}
