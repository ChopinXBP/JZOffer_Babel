/**
 * 
 * @author ChopinXBP
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：压入栈
 *
 */
import java.util.Stack;
import java.util.ArrayList;


class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class printListFromTailToHead_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
 
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;       
    }
}
