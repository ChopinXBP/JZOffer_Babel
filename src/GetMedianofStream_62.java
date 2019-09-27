/**
 * 
 * @author ChopinXBP
 * ��εõ�һ���������е���λ����
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * 
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianofStream_62 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private PriorityQueue <Integer> minheap = new PriorityQueue <>();
	private PriorityQueue<Integer> maxheap = new PriorityQueue<>(15, new Comparator<Integer>() {
		@Override
		//��תΪ����
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});
	private int count = 0;
	
	//���д��ڵ�����λ�������ݷ�����С�ѣ�����С����λ�������ݷ�������
    public void Insert(Integer num) {
    	count++;
    	//����������Ϊ����ʱ�������Ƚ�������ɸѡ,���Ѷ���Ԫ�ؽ�����С��
    	if((count & 0x01) == 1) {
    		maxheap.add(num);
    		minheap.add(maxheap.poll());
    	}
    	//����������Ϊż��ʱ�������Ƚ�����С��ɸѡ,��С�Ѷ���Ԫ�ؽ�������
    	else {
    		minheap.add(num);
    		maxheap.add(minheap.poll());
    	}
    }

    public Double GetMedian() {
    	//����Ϊż��ʱ����С�Ѻ����Ѷ���Ϊ��λ��
    	if((count & 0x01) == 0) {
    		return new Double((minheap.peek() + maxheap.peek())) / 2;
    	}
    	//����Ϊ����ʱ����С�Ѷ���Ϊ��λ��
    	else {
    		return new Double(minheap.peek());
    	}
    }
}
