/**
 * 
 * @author ChopinXBP 
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
	
	//����һ����Ƿ������Ӷ�o(n^2)
    public static RandomListNode Clone(RandomListNode pHead)
    {
    	if(pHead == null)return null;
    	RandomListNode newhead = new RandomListNode(pHead.label);
    	RandomListNode pnew = newhead;
    	RandomListNode pold = pHead;
    	int count = 0;
    	
    	//�Ȱ�next˳���ͷ��������
    	while(pold.next != null){
    		pold.label = count;			//��ǵ�ǰ�����������λ��
    		RandomListNode ptmp = new RandomListNode(pold.next.label);
    		pnew.next = ptmp;
    		pold = pold.next;
    		pnew = pnew.next;
    		count++;
    	}
    	
    	//��ֻ��һ����㣬����ֱ�ӷ��ء�����ǰ��Ҫ������randomָ��ָ�����null���Ǳ���㣬Ȼ����и�ֵ��
    	if(count == 0){
    		if(pHead.random != null) newhead.random = newhead;
    		return newhead;
    	}
    	pold.label = count;			//��β������������һ�����
    	
    	pnew = newhead;
    	pold = pHead;
    	RandomListNode pnewtmp;
    	for(int i = 0; i <= count; i++){
    		//���ý��randomֵΪ�����������������ͷ�������ý������λ�ö�random���и�ֵ
    		if(pold.random != null){
    			int location = pold.random.label;	//Ѱ��random�������λ��
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
    
    //����������ϣ�������Ӷ�o(n)���ռ任ʱ��
	public static RandomListNode Clone2(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode cur = pHead;
		while (cur != null) {
			map.put(cur, new RandomListNode(cur.label)); // ���¾ɽ������ڹ�ϣ����
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


    //���������ӳ���ַ������Ӷ�o(n)��Ч�ʸ�
    public static RandomListNode Clone3(RandomListNode pHead)
    {
    	if(pHead == null)return null;    	
    	RandomListNode p = pHead;
    	
    	//��ֻ��һ����㣬����ֱ�ӷ��ء�����ǰ��Ҫ������randomָ��ָ�����null���Ǳ���㣬Ȼ����и�ֵ��
    	if(p.next == null){
    		RandomListNode newhead = new RandomListNode(pHead.label);
    		if(pHead.random != null) newhead.random = newhead;
    		return newhead;
    	}
    	
    	//��һ�������������ÿһ����㲢���ڸý��֮��
    	while(p != null){
    		RandomListNode ptmp = new RandomListNode(p.label);
    		ptmp.next = p.next;
    		p.next = ptmp;
    		p = ptmp.next;
    	}
    	//��β����,p�ص���ͷ
		p = pHead;
		
    	//�ڶ���������ÿһ������ramdomֵ
    	while(p != null){
    		if(p.random != null){
    			p.next.random = p.random.next;
    		}
    		p = p.next.next;
    	}
		
		//�����������볤����   	
    	//����ⲻ�ܷ���pHead����Ҫ����ԭ����Ľṹ��ʵ����pHead���������ü�¼�ţ����Կ��Խ��в���������Ҫ��֤ԭ����ṹ���䣩
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
    
    //�����ģ��ݹ飬˼·���������Ӷ�o(n)���ռ�Ч�ʵ�
    //����ת��Ϊһ��ͷ���ͳ�ȥͷ���ʣ�ಿ�֣�ʣ�ಿ�ֲ�����ԭ����һ��,�ݹ鸴��ÿһ����㡣
	public static RandomListNode Clone4(RandomListNode pHead) {
		if (pHead == null)
			return null;

		RandomListNode newNode = new RandomListNode(pHead.label);

		newNode.random = pHead.random;
		newNode.next = Clone(pHead.next);

		return newNode;
	}

	
	
}


