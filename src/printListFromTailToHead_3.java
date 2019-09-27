/**
 * 
 * @author ChopinXBP
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * ˼·��ѹ��ջ
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
