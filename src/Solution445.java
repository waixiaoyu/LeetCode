import java.util.Stack;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> sta1 = new Stack<>();
        Stack<Integer> sta2 = new Stack<>();
        Stack<Integer> staResult = new Stack<>();
        while (l1 != null) {
            sta1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sta2.push(l2.val);
            l2 = l2.next;
        }
        boolean bUpDigit = false;
        while (!sta1.isEmpty() || !sta2.isEmpty()) {
            int n1 = sta1.size() > 0 ? sta1.pop() : 0;
            int n2 = sta2.size() > 0 ? sta2.pop() : 0;
            int nUp = 0;
            if (bUpDigit) {
                nUp = 1;
                bUpDigit = false;
            }
            int nResult = n1 + n2 + nUp;
            if (nResult > 9) {
                bUpDigit = true;
                nResult -= 10;
            }
            staResult.push(nResult);
        }
        if (bUpDigit) {
            staResult.push(1);
        }
        ListNode lnResult = new ListNode(staResult.pop());
        ListNode lnHead = lnResult;
        while (!staResult.isEmpty()) {
            lnResult.next = new ListNode(staResult.pop());
            lnResult = lnResult.next;
        }
        return lnHead;
    }
}
