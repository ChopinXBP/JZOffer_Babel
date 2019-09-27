/**
 * 
 * @author ChopinXBP
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5��
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
	
	//����HashMap�������ڲ���������
    public static ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead == null) return null;
    	
    	HashMap<Integer, Integer> map = new HashMap<>();
    	LinkedList<Integer> dupnum = new LinkedList<>();
    	ListNode p = pHead;
    	int loc = 0;
    	while(p != null) {
    		if(map.containsKey(p.val)) {
    			//���ظ������һ���ظ��Ľ��
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
    	
    	//���������򣬶Խ��λ�������������򼴿ɣ�ʱ�临�Ӷ�ȡ���������Ӷ�
    	//Collections.sort(dupnum);
    	
    	//ע����ܲ�����ͷ���,�趨һ������ͷ��㣬��nextָ��pHead
    	ListNode newhead = new ListNode(-1);
    	newhead.next = pHead;
    	p = newhead;
    	loc = -1;
    	while(!dupnum.isEmpty()) {
    		int step = dupnum.pollFirst() - loc;
    		//ָ��Ӧɾ�����ǰһλ
    		for(int i = 0; i < step - 1; i++) {
    			p = p.next;
    			loc++;
    		}
    		p.next = p.next.next;
    		loc++;
    	}
    	
    	return newhead.next;
    }
    
	// ���õݹ�
	public static ListNode deleteDuplication2(ListNode pHead) {
		// ֻ��0����1����㣬�򷵻�
		if (pHead == null || pHead.next == null) {
			return pHead;
		}
		// ��ǰ������ظ����
		if (pHead.val == pHead.next.val) {
			ListNode pNode = pHead.next;
			while (pNode != null && pNode.val == pHead.val) {
				// ����ֵ�뵱ǰ�����ͬ��ȫ�����,�ҵ���һ���뵱ǰ��㲻ͬ�Ľ��
				pNode = pNode.next;
			}
			// �ӵ�һ���뵱ǰ��㲻ͬ�Ľ�㿪ʼ�ݹ�
			return deleteDuplication(pNode);
		}
		// ��ǰ��㲻���ظ����
		else {
			// ������ǰ��㣬����һ����㿪ʼ�ݹ�
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}

	//����ѭ��
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
				// �ҵ�����һ����ͬ�ڵ�
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
