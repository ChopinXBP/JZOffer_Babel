/**
 * 
 * @author ChopinXBP
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;


public class MoreThanHalfNum_Solution_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalfNum_Solution2(array));
	}

	
	//////////////////////����һ����������///////////////////////
	public static class Data{
		int data;
		int num;
		Data(int data){
			this.data = data;
			num = 1;
		}
	}
	
	public static int MoreThanHalfNum_Solution(int [] array) {
		if (array.length <= 0) return 0;
		
        HashSet<Data> datalist = new HashSet<>();
        for(int i = 0; i < array.length; i++){
        	if(!isExistNum(datalist, array[i])){
        		Data newdata = new Data(array[i]);
        		datalist.add(newdata);
        	}
        }
        
        int result = 0;
        for(Data it : datalist){
			if(it.num > array.length / 2){
				result = it.data;
			}
		}
        
        return result;
    }
	
	public static boolean isExistNum(HashSet<Data> datalist, int i){
		for(Data it : datalist){
			if(it.data == i){
				it.num++;
				return true;
			}
		}
		return false;
	}
	
	//////////////////////����һ�Ľ���HashMap///////////////////////
	public static int MoreThanHalfNum_Solution1(int[] array) {
		//����HashMap��keyֵ�洢Ԫ�أ�valֵ�洢����
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {

			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				int count = map.get(array[i]);
				map.put(array[i], ++count);
			}
		}
		
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Integer key = (Integer) entry.getKey();
			Integer val = (Integer) entry.getValue();
			if (val > array.length / 2) {
				return key;
			}
		}
		return 0;
	}
	
	////////////////������������Ѱ����λ��������˼�룩//////////////////
	public static int MoreThanHalfNum_Solution2(int[] array) {
		if (array.length <= 0)
			return 0;

		int start = 0;
		int length = array.length;
		int end = length - 1;
		int middle = length >> 1;

		int index = Partition(array, start, end);	

		//��index���õ���middle��Ҳ������λ������index>middle������λ����index��ߣ���index<middle,����λ����index�ұ�
		//�ݹ��ҵ���indexƥ������λ��λ��
		while (index != middle) {
			if (index > middle) {
				index = Partition(array, start, index - 1);
			} else {
				index = Partition(array, index + 1, end);
			}
		}
		int result = array[middle];

		//������ִ����Ƿ񳬹�һ��
		int times = 0;
		for (int i = 0; i < length; ++i) {
			if (array[i] == result)
				times++;
		}
		if (times * 2 < length) {
			System.out.println(times);
			return 0;
		} else {
			return result;
		}
	}

	//��flagΪ�磬���Ͻ�������Ԫ�أ����Ԫ��ȫС��flag����Ӧ��ֵ���ұ�Ԫ��ȫ����flag����Ӧ��ֵ��������λ������λ��
	public static int Partition(int[] array, int start, int end) {
		int flag = (array[start] + array[end]) / 2;

		while (start < end) {
			while (array[end] > flag) {
				end--;
			}
			swap(array, start, end);
			while (array[start] <= flag) {
				start++;
			}
			swap(array, start, end);
		}
		return start;
	}

	public static void swap(int[] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}
	
	////////////////�����������ߴ����㷨�������ص㣩//////////////////
	public int MoreThanHalfNum_Solution3(int[] array) {
		if (array.length <= 0) {
			return 0;
		}
		int result = array[0];
		int times = 1;			//��ʼ��������Ϊ1	

		//����ǰ����Ϊ0����result����Ϊ��ǰ���֡�����ǰ������result��ͬ������+1������ͬ��-1��
		//����Ŀ�����ֳ��ִ������������ּ��������࣬������result�д������Ϊ���ɵ�Ŀ������
		for (int i = 0; i < array.length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			}
			else if (array[i] == result)
				times++;
			else
				times--;
		}
		
		//����result�л��ɵ�Ŀ�����ֳ��ִ�������������ȷ��
		int time = 0;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == result)
				time++;
		}
		
		if (time * 2 < array.length) {
			//System.out.println(time);
			return 0;
		} else {
			return result;
		}
	}

}
