/**
 * 
 * @author ChopinXBP
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 */

import java.util.HashMap;

public class EntryNodeOfLoop_54 {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//哈希表法
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
    	if(pHead == null) return null;
    	
        HashMap<ListNode, Boolean> map = new HashMap<>();
        ListNode p = pHead;
        while(p != null) {
        	if(map.containsKey(p))return p;
        	map.put(p, true);
        	p = p.next;
        }        
        return p;
    }
    
    //快慢指针法
    //1.分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相遇点。
    //当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数。
    //2.令起点到入口的距离为a，入口到相遇点距离为b，相遇点再到入口为c。已知a+b=x；b+c=x；因此a=c。也就是起点到入口距离=相遇点到入口距离。
    //再让p2指向链表头部，p1位置不变，p1,p2每次走一步一共走a步直到p1==p2; 此时p1与p2指向环的入口。
	ListNode EntryNodeOfLoop2(ListNode pHead) {
		if (pHead == null || pHead.next == null)
			return null;
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				p2 = pHead;
				while (p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				if (p1 == p2)
					return p1;
			}
		}
		return null;
	}

}
