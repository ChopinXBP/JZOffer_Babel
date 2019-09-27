/**
 * 
 * @author ChopinXBP 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 注意：1.指针为null，2.参数为0，3.参数大于结点数
 *
 */

public class FindKthToTail {

	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode Solution(ListNode head, int k){
		//指针为null或参数为0
		if(head == null || k == 0)return null;
		
		ListNode p = head;
		ListNode result = head;
		
		while(--k > 0){
			if(p.next == null)return null;		//参数大于结点数
			p = p.next;
		}
		
		while(p.next != null){
			p = p.next;
			result = result.next;
		}
		
		return result;
	}
	
}
