import java.util.Stack;

/**
 * Created by SunYing on 2017/6/14.
 */
public class Day11_AddLists2 {
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        } else if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Stack<ListNode> result = new Stack<ListNode>();
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        int carrier = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = 0;
            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum += s1.pop().val + s2.pop().val;
            } else if (!s1.isEmpty()) {
                sum += s1.pop().val;
            } else if (!s2.isEmpty()) {
                sum += s2.pop().val;
            }

            result.push(new ListNode((sum + carrier) % 10));
            carrier = (sum + carrier) / 10;
        }
        if (carrier == 1) {
            result.push(new ListNode(carrier));
        }

        ListNode node = new ListNode(0);
        ListNode dummy = node;
        while (!result.isEmpty()) {
            node.next = result.pop();
            node = node.next;
        }
        return dummy.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
}
