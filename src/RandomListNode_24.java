/**
 * 
 * @author ChopinXBP 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 */

import java.util.HashMap;

public class RandomListNode_24 {

	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode newhead0 = new RandomListNode(0);
		RandomListNode newhead1 = new RandomListNode(1);
		RandomListNode newhead2 = new RandomListNode(2);
		newhead0.next = newhead1;
		newhead0.random = newhead2;
		newhead1.next = newhead2;
		newhead1.random = null;
		newhead2.random = newhead1;
		RandomListNode p = newhead0;
		while(p.next != null){
			System.out.print(p.label);
			p = p.next;
		}
		System.out.print(p.label);
		System.out.print('\n');
		p = newhead0;
		for(int i = 0; i < 3; i++){
			if(p.random == null){
				System.out.print('#');
			}else{
				System.out.print(p.random.label);
			}
			p = p.next;
		}
		System.out.print('\n');
		
		RandomListNode newheadx = Clone2(newhead0);
		p = newheadx;
		while(p.next != null){
			System.out.print(p.label);
			p = p.next;
		}
		System.out.print(p.label);
		System.out.print('\n');
		p = newheadx;
		for(int i = 0; i < 3; i++){
			if(p.random == null){
				System.out.print('#');
			}else{
				System.out.print(p.random.label);
			}
			p = p.next;
		}
	}
	
	//方法一：标记法，复杂度o(n^2)
    public static RandomListNode Clone(RandomListNode pHead)
    {
    	if(pHead == null)return null;
    	RandomListNode newhead = new RandomListNode(pHead.label);
    	RandomListNode pnew = newhead;
    	RandomListNode pold = pHead;
    	int count = 0;
    	
    	//先按next顺序从头复制链表
    	while(pold.next != null){
    		pold.label = count;			//标记当前结点所在链表位置
    		RandomListNode ptmp = new RandomListNode(pold.next.label);
    		pnew.next = ptmp;
    		pold = pold.next;
    		pnew = pnew.next;
    		count++;
    	}
    	
    	//若只有一个结点，可以直接返回。返回前需要考察其random指针指向的是null还是本结点，然后进行赋值。
    	if(count == 0){
    		if(pHead.random != null) newhead.random = newhead;
    		return newhead;
    	}
    	pold.label = count;			//收尾工作，标记最后一个结点
    	
    	pnew = newhead;
    	pold = pHead;
    	RandomListNode pnewtmp;
    	for(int i = 0; i <= count; i++){
    		//若该结点random值为空则保留，若不空则从头遍历到该结点所在位置对random进行赋值
    		if(pold.random != null){
    			int location = pold.random.label;	//寻找random结点所在位置
        		pnewtmp = newhead;
            	while(location > 0){
            		pnewtmp = pnewtmp.next;
            		location--;
            	}
            	pnew.random = pnewtmp;
    		}
        	if(i != count){
        		pnew = pnew.next;
        		pold = pold.next;
        	}
    	}
    	return newhead;    	
    }
    
    //方法二：哈希表法，复杂度o(n)，空间换时间
	public static RandomListNode Clone2(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode cur = pHead;
		while (cur != null) {
			map.put(cur, new RandomListNode(cur.label)); // 将新旧结点配对在哈希表里
			cur = cur.next;
		}
		cur = pHead;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(pHead);
	}


    //方法三：加长拆分法，复杂度o(n)，效率高
    public static RandomListNode Clone3(RandomListNode pHead)
    {
    	if(pHead == null)return null;    	
    	RandomListNode p = pHead;
    	
    	//若只有一个结点，可以直接返回。返回前需要考察其random指针指向的是null还是本结点，然后进行赋值。
    	if(p.next == null){
    		RandomListNode newhead = new RandomListNode(pHead.label);
    		if(pHead.random != null) newhead.random = newhead;
    		return newhead;
    	}
    	
    	//第一步：复制链表的每一个结点并插在该结点之后
    	while(p != null){
    		RandomListNode ptmp = new RandomListNode(p.label);
    		ptmp.next = p.next;
    		p.next = ptmp;
    		p = ptmp.next;
    	}
    	//收尾工作,p回到表头
		p = pHead;
		
    	//第二步：复制每一个结点的ramdom值
    	while(p != null){
    		if(p.random != null){
    			p.next.random = p.random.next;
    		}
    		p = p.next.next;
    	}
		
		//第三步，分离长链表   	
    	//这道题不能返回pHead，还要保留原链表的结构（实际上pHead有其他引用记录着，所以可以进行操作，但是要保证原链表结构不变）
    	RandomListNode newhead = new RandomListNode(0);	
    	p = newhead;
    	while(pHead!=null){
            p.next = pHead.next; 
            p = p.next;
            pHead.next = pHead.next.next; 
            pHead = pHead.next;
        }
        return newhead.next;
    }
    
    //方法四：递归，思路清晰，复杂度o(n)，空间效率低
    //此题转化为一个头结点和除去头结点剩余部分，剩余部分操作和原问题一致,递归复制每一个结点。
	public static RandomListNode Clone4(RandomListNode pHead) {
		if (pHead == null)
			return null;

		RandomListNode newNode = new RandomListNode(pHead.label);

		newNode.random = pHead.random;
		newNode.next = Clone(pHead.next);

		return newNode;
	}

	
	
}


