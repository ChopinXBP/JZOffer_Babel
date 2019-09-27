/**
 * 
 * @author ChopinXBP
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
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

	//��ϣ��
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
    
    //����ָ�뷨
    //1.�ֱ���p1��p2ָ������ͷ����p1ÿ����һ����p2ÿ���߶�����ֱ��p1==p2�ҵ��ڻ��е������㡣
    //��p1==p2ʱ��p2�������ڵ���Ϊ2x,p1�������ڵ���Ϊx,�軷����n���ڵ�,p2��p1����һȦ��2x=n+x; n=x;���Կ���p1ʵ������һ�����Ĳ�����
    //2.����㵽��ڵľ���Ϊa����ڵ����������Ϊb���������ٵ����Ϊc����֪a+b=x��b+c=x�����a=c��Ҳ������㵽��ھ���=�����㵽��ھ��롣
    //����p2ָ������ͷ����p1λ�ò��䣬p1,p2ÿ����һ��һ����a��ֱ��p1==p2; ��ʱp1��p2ָ�򻷵���ڡ�
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
