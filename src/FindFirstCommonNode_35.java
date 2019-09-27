/**
 * 
 * @author ChopinXBP
 * 输入两个链表，找出它们的第一个公共结点。
 *
 */

import java.util.LinkedList;


public class FindFirstCommonNode_35 {

	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode Node0 = new ListNode(0);
		ListNode Node1 = new ListNode(1);
		ListNode Node2 = new ListNode(2);
		ListNode Node3 = new ListNode(3);
		ListNode Node4 = new ListNode(4);
		ListNode Node5 = new ListNode(5);
		ListNode Node6 = new ListNode(6);
		Node0.next = Node1;
		Node1.next = Node2;
		Node2.next = Node3;
		Node3.next = Node4;		
		Node4.next = Node5;
		Node5.next = Node6;
		
		System.out.println(FindFirstCommonNode(Node0, Node6).val);
		System.out.println(FindFirstCommonNode2(Node0, Node6).val);
	}

	//方法1：等长遍历法（不需要开辟栈空间）
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null) return null;
		 if(pHead1 == pHead2) return pHead1;
		 
		 //计算链表1的长度
		 ListNode plong = pHead1;
		 int length1 = 1;
		 while(plong.next != null){
			 plong = plong.next;
			 length1++;
		 }
		 
		 //计算链表2的长度
		 ListNode pshort = pHead2;
		 int length2 = 1;
		 while(pshort.next != null){
			 pshort = pshort.next;
			 length2++;
		 }		 
		 
		 //确定链表长短与差值num
		 int num;
		 if(length1 > length2){
			 plong = pHead1;
			 pshort = pHead2;
			 num = length1 - length2;
		 }else{
			 plong = pHead2;
			 pshort = pHead1;
			 num = length2 - length1;
		 }
		 
		 //遍历长链表前num个结点，使两链表等长
		 while(num-- > 0){
			 if(plong == pshort)return plong;
			 plong = plong.next;
		 }
		 
		 //依次遍历两个链表的每一个结点，num用于奇偶标志
		 num = 0;
		 while(plong.next != null || pshort.next != null){
			 if(plong == pshort) return plong;			 
			 if((num & 0x01) == 0){
				 plong = plong.next;
			 }else{
				 pshort = pshort.next;
			 }
			 num++;
		 }	
		 if(plong == pshort)return plong;
		 return null;
    }
	
	//方法2：辅助栈法
	public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null) return null;
		 if(pHead1 == pHead2) return pHead1;
		 
		 //元素入栈
		 LinkedList<ListNode> p1stack = new LinkedList<>();
		 LinkedList<ListNode> p2stack = new LinkedList<>();
		 ListNode pListNode = pHead1;
		 while(pListNode != null){
			 p1stack.add(pListNode);
			 pListNode = pListNode.next;
		 }
		 pListNode = pHead2;
		 while(pListNode != null){
			 p2stack.add(pListNode);
			 pListNode = pListNode.next;
		 }
		 
		 //依次检验栈顶元素。如果栈顶元素不想等直接返回初始的pListNode，此时的pListNode为null
		 while(!p1stack.isEmpty() && !p2stack.isEmpty()){
			 if(p1stack.getLast() == p2stack.getLast()){
				 pListNode = p1stack.getLast();
				 p1stack.pollLast();
				 p2stack.pollLast();
				 if(p1stack.isEmpty() || p2stack.isEmpty()) return pListNode;
			 }else{
				 return pListNode;
			 }
		 }
		 
		 return null;
   }
}
