/**
 * 
 * @author ChopinXBP
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
 * 
 */

import java.util.HashMap;
import java.util.LinkedList;

public class DeleteDuplication_55 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode pHead = new ListNode(0);
		ListNode p1= new ListNode(0);
		ListNode p2= new ListNode(2);
		ListNode p3= new ListNode(2);
		ListNode p4= new ListNode(3);
		ListNode p5= new ListNode(3);
		ListNode p6= new ListNode(5);
		pHead.next = p1;
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		p4.next = p5;
		p5.next = p6;
		
		pHead = deleteDuplication(pHead);
		while(pHead != null) {
			System.out.print(pHead.val + " ");
			pHead = pHead.next;
		}
		
	}
	
	//利用HashMap（可用于不排序链表）
    public static ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null) return null;
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	LinkedList<Integer> dupnum = new LinkedList<>();
    	ListNode p = pHead;
    	int loc = 0;
    	while(p != null) {
    		if(map.containsKey(p.val)) {
    			//不重复放入第一次重复的结点
    			if(map.get(p.val) != -1) {
    				dupnum.add(map.get(p.val));
    				map.put(p.val, -1);
    			}
    			dupnum.add(loc);   			
    		}else {
    			map.put(p.val, loc);
    		}
    		loc++;
    		p = p.next;
    	}
    	
    	//若链表不排序，对结点位置容器进行排序即可，时间复杂度取决于排序复杂度
    	//Collections.sort(dupnum);
    	
    	//注意可能不保留头结点,设定一个辅助头结点，其next指向pHead
    	ListNode newhead = new ListNode(-1);
    	newhead.next = pHead;
    	p = newhead;
    	loc = -1;
    	while(!dupnum.isEmpty()) {
    		int step = dupnum.pollFirst() - loc;
    		//指向应删除结点前一位
    		for(int i = 0; i < step - 1; i++) {
    			p = p.next;
    			loc++;
    		}
    		p.next = p.next.next;
    		loc++;
    	}
    	
    	return newhead.next;
    }
    
	// 利用递归
	public static ListNode deleteDuplication2(ListNode pHead) {
		// 只有0个或1个结点，则返回
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		// 当前结点是重复结点
		if (pHead.val == pHead.next.val) {
			ListNode pNode = pHead.next;
			while (pNode != null && pNode.val == pHead.val) {
				// 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
				pNode = pNode.next;
			}
			// 从第一个与当前结点不同的结点开始递归
			return deleteDuplication(pNode);
		}
		// 当前结点不是重复结点
		else {
			// 保留当前结点，从下一个结点开始递归
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}

	//利用循环
	public static ListNode deleteDuplication3(ListNode pHead) {
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		ListNode Head = new ListNode(0);
		Head.next = pHead;
		ListNode pre = Head;
		ListNode last = Head.next;
		while (last != null) {
			if (last.next != null && last.val == last.next.val) {
				// 找到最后的一个相同节点
				while (last.next != null && last.val == last.next.val) {
					last = last.next;
				}
				pre.next = last.next;
				last = last.next;
			} else {
				pre = pre.next;
				last = last.next;
			}
		}
		return Head.next;
	}
}
