/**
 * 
 * @author ChopinXBP 
 * 输入一个链表，反转链表后，输出新链表的表头。
 *  
 *
 */

public class ReverseList_15 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int i = 0; i < 5; i++) {
			ListNode newnode = new ListNode(i + 1);
			p.next = newnode;
			p = p.next;
		}
		p = head;
		System.out.print("原序列： ");
		for (int i = 0; i < 6; i++) {
			System.out.print(p.val);
			p = p.next;
		}
		p = Solution(head);

		System.out.print("\n翻转序列： ");
		for (int i = 0; i < 6; i++) {
			System.out.print(p.val);
			p = p.next;
		}
	}

	public static ListNode Solution(ListNode head) {
		if (head == null)
			return null;
		else if (head.next == null)
			return head;

		ListNode temp = head.next;		//指向前一个结点
		ListNode later = head;			//指向后一个结点

		//每次循环先定义一个former指向下一个结点，将temp与later所指结点反向，并依次前进later与temp
		while (temp.next != null) {

			ListNode former = temp.next;	//指向下一个结点
			temp.next = later;
			later = temp;
			temp = former;

		}

		temp.next = later;		//将最后两个结点反向
		head.next = null;		//去掉头两个结点的自循环

		return temp;
	}
}

/*
//第一种方法是：非递归方法

struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
            val(x), next(NULL) {
    }
};
class Solution {
public:
    ListNode* ReverseList(ListNode* pHead) {
         
        if(pHead==NULL) return NULL;//注意程序鲁棒性
         
        ListNode* pNode=pHead;//当前指针
        ListNode* pReverseHead=NULL;//新链表的头指针
        ListNode* pPrev=NULL;//当前指针的前一个结点
         
        while(pNode!=NULL){//当前结点不为空时才执行
            ListNode* pNext=pNode->next;//链断开之前一定要保存断开位置后边的结点
             
            if(pNext==NULL)//当pNext为空时，说明当前结点为尾节点
                pReverseHead=pNode;
  
            pNode->next=pPrev;//指针反转
            pPrev=pNode;
            pNode=pNext;
        }
        return pReverseHead;
    }
}
 
//第二种方法是：递归方法 
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) :
            val(x), next(NULL) {
    }
};
class Solution {
public:
    ListNode* ReverseList(ListNode* pHead) {
        //如果链表为空或者链表中只有一个元素
        if(pHead==NULL||pHead->next==NULL) return pHead;
         
        //先反转后面的链表，走到链表的末端结点
        ListNode* pReverseNode=ReverseList(pHead->next);
         
        //再将当前节点设置为后面节点的后续节点
        pHead->next->next=pHead;
        pHead->next=NULL;
         
        return pReverseNode;
         
    }
};
*/
