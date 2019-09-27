/**
 * 
 * @author ChopinXBP
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ��
 * ���磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}��
 * �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� 
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� 
 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class maxInWindows_63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> result = maxInWindows(num, 3);
		for(int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> result = new ArrayList<>();
    	if(num == null || size <= 0 || size > num.length) return result;
    	//��¼Ԫ���±�Ķ��� ��ֻ��¼�±꣩	
    	LinkedList<Integer> list = new LinkedList<>();
    	//������ʼ���У��ӳ�ʼ���ڵ����ڶ���Ԫ��k��ʼִ��һ�β�������ǰ���󽫶�����Ԫ��kС������Ԫ��ɾ��������Ԫ��k���ڶ��ף���ʱ��βԪ�����
    	for(int i = 0; i < size - 1; i++) {
    		while(!list.isEmpty() && num[i] > num[list.peekFirst()]) {
    			list.pollFirst();
    		}
    		list.addFirst(i);
    	}
    	
    	//��ʼ�������Ԫ��Ϊsize - 1��������ÿһ����Ԫ��k = num[i]    	
    	for(int i = size - 1; i < num.length; i++) {
    		//��ǰ������ȥ��kС��Ԫ�أ���k�������
    		while(!list.isEmpty() && num[i] > num[list.peekFirst()]) {
    			list.pollFirst();
    		}
    		list.addFirst(i);
    		//����βԪ�أ���ǰ���ֵ�����꣩�Ƿ񳬳����ڷ�Χ�����Ƴ����ڣ�����������ɾȥ��ÿ���ƶ����ɾȥһ����
    		if(i - list.peekLast() + 1 > size) {
    			list.pollLast();
    		}
    		result.add(num[list.peekLast()]);
    	}
    	  	
    	return result;
    }	
}
