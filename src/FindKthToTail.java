/**
 * 
 * @author ChopinXBP 
 * ����һ����������������е�����k����㡣
 * ע�⣺1.ָ��Ϊnull��2.����Ϊ0��3.�������ڽ����
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
		//ָ��Ϊnull�����Ϊ0
		if(head == null || k == 0)return null;
		
		ListNode p = head;
		ListNode result = head;
		
		while(--k > 0){
			if(p.next == null)return null;		//�������ڽ����
			p = p.next;
		}
		
		while(p.next != null){
			p = p.next;
			result = result.next;
		}
		
		return result;
	}
	
}
