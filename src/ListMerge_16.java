/**
 * 
 * @author ChopinXBP 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *  
 *
 */


public class ListMerge_16 {
	
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1 = new ListNode(0);
		ListNode head2 = new ListNode(1);
		ListNode p1 = head1;
		ListNode p2 = head2;
		for (int i = 1; i < 5; i++) {
			ListNode newnode1 = new ListNode(2 * i);
			ListNode newnode2 = new ListNode(2 * i + 1);
			p1.next = newnode1;
			p1 = p1.next;
			p2.next = newnode2;
			p2 = p2.next;
		}
		p1 = head1;
		System.out.print("原序列1： ");
		while(p1 != null) {
			System.out.print(p1.val);
			p1 = p1.next;
		}
		p2 = head2;
		System.out.print("\n原序列2： ");
		while(p2 != null) {
			System.out.print(p2.val);
			p2 = p2.next;
		}
		
		ListNode result = Solution(head1,head2);
		ListNode p3 = result;
		System.out.print("\n合并序列： ");
		while(p3 != null) {
			System.out.print(p3.val);
			p3 = p3.next;
		}
	}

	
	public static ListNode Solution(ListNode list1, ListNode list2){
		
		//if(list1 == null && list2 == null) return null;	//已经被以下两种情况包含
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		
		ListNode result = new ListNode(0);
		ListNode head = result;
		ListNode p1 = list1;
		ListNode p2 = list2;
		if(p1.val <= p2.val){
			result.val = p1.val;
			p1 = p1.next;
		}		
		else{
			result.val = p2.val;
			p2 = p2.next;
		}
			
		
		while(p1 != null && p2 != null){
			if(p1.val <= p2.val){
				result.next = p1;
				p1 = p1.next;
			}else{
				result.next = p2;
				p2 = p2.next;
			}
			
			result = result.next;
		}
		
		
		if(p1 == null)
			result.next = p2;
		else if(p2 == null)
			result.next = p1;
				
		return head;
	}
	
}
